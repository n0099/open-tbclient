package com.baidu.tieba.video.cloudmusic;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.cloudmusic.a.a;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes7.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView gCf;
    private BdListView kFM;
    private NoDataView mNoDataView;
    private CloudMusicData.MusicTagList nNA;
    private com.baidu.tieba.video.cloudmusic.a.a nNy;
    private d.a nNz;
    private int tagId = 0;
    private int jYt = 1;
    private CustomMessageListener nNB = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.nNy != null) {
                CloudMusicListFragment.this.nNy.notifyDataSetChanged();
            }
        }
    };

    public static CloudMusicListFragment a(CloudMusicData.MusicTagList musicTagList) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("music_list_key", musicTagList);
        CloudMusicListFragment cloudMusicListFragment = new CloudMusicListFragment();
        cloudMusicListFragment.setArguments(bundle);
        return cloudMusicListFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_cloud_music_list, viewGroup, false);
        this.nNA = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.kFM = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.nNy = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.kFM.setAdapter((ListAdapter) this.nNy);
        this.kFM.setExOnSrollToBottomListener(this);
        this.kFM.setDivider(null);
        this.nNy.a(this);
        this.gCf = new PbListView(getPageContext().getPageActivity());
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0201);
        this.gCf.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.pA(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.nNA != null && this.nNz != null && this.nNA.page != null) {
            this.tagId = this.nNA.tag_id;
            this.jYt = this.nNA.page.has_more;
            this.nNz.c(this.nNA);
        }
        this.kFM.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.isNetWorkAvailable()) {
                    CloudMusicListFragment.this.nNz.a(CloudMusicListFragment.this.nNy.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), R.string.neterror);
                }
            }
        });
        registerListener(this.nNB);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void v(BdListView bdListView) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(getPageContext().getPageActivity(), R.string.neterror);
        } else if (this.nNz != null && this.jYt != 0) {
            this.nNz.KF(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.gCf.changeSkin(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.nNz = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.nNA = musicTagList;
        if (this.nNy != null) {
            this.nNy.fX(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void yV(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void dSv() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.kFM.setNextPage(this.gCf);
            }
            this.gCf.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.gCf.endLoadData();
        }
        this.jYt = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void yW(boolean z) {
        if (this.gCf != null) {
            if (z) {
                if (this.gCf.getView().getParent() == null) {
                    this.kFM.setNextPage(this.gCf);
                }
                this.gCf.showLoadingViewWithoutEmptyView();
                this.gCf.startLoadData();
                return;
            }
            this.gCf.endLoadData();
            this.kFM.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void KC(int i) {
        this.nNy.ah(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void KD(int i) {
        this.nNy.ah(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void KE(int i) {
        this.nNy.ah(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.nNz.dCd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.nNz != null) {
            this.nNz.cFK();
        }
        com.baidu.tieba.video.cloudmusic.data.a.dSC().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.nNy != null && this.nNy.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.nNy.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
