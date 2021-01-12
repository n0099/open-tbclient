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
    private PbListView gxy;
    private BdListView kvq;
    private NoDataView mNoDataView;
    private com.baidu.tieba.video.cloudmusic.a.a nBi;
    private d.a nBj;
    private CloudMusicData.MusicTagList nBk;
    private int tagId = 0;
    private int jOB = 1;
    private CustomMessageListener nBl = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.nBi != null) {
                CloudMusicListFragment.this.nBi.notifyDataSetChanged();
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
        this.nBk = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.kvq = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.nBi = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.kvq.setAdapter((ListAdapter) this.nBi);
        this.kvq.setExOnSrollToBottomListener(this);
        this.kvq.setDivider(null);
        this.nBi.a(this);
        this.gxy = new PbListView(getPageContext().getPageActivity());
        this.gxy.createView();
        this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0201);
        this.gxy.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.pu(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.nBk != null && this.nBj != null && this.nBk.page != null) {
            this.tagId = this.nBk.tag_id;
            this.jOB = this.nBk.page.has_more;
            this.nBj.c(this.nBk);
        }
        this.kvq.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.isNetWorkAvailable()) {
                    CloudMusicListFragment.this.nBj.a(CloudMusicListFragment.this.nBi.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), R.string.neterror);
                }
            }
        });
        registerListener(this.nBl);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void v(BdListView bdListView) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(getPageContext().getPageActivity(), R.string.neterror);
        } else if (this.nBj != null && this.jOB != 0) {
            this.nBj.Kg(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.gxy.changeSkin(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.nBj = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.nBk = musicTagList;
        if (this.nBi != null) {
            this.nBi.fZ(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void yD(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void dPU() {
        if (this.gxy != null) {
            if (this.gxy.getView().getParent() == null) {
                this.kvq.setNextPage(this.gxy);
            }
            this.gxy.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.gxy.endLoadData();
        }
        this.jOB = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void yE(boolean z) {
        if (this.gxy != null) {
            if (z) {
                if (this.gxy.getView().getParent() == null) {
                    this.kvq.setNextPage(this.gxy);
                }
                this.gxy.showLoadingViewWithoutEmptyView();
                this.gxy.startLoadData();
                return;
            }
            this.gxy.endLoadData();
            this.kvq.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Kd(int i) {
        this.nBi.ah(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Ke(int i) {
        this.nBi.ah(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Kf(int i) {
        this.nBi.ah(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.nBj.dzE();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.nBj != null) {
            this.nBj.cEk();
        }
        com.baidu.tieba.video.cloudmusic.data.a.dQb().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.nBi != null && this.nBi.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.nBi.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
