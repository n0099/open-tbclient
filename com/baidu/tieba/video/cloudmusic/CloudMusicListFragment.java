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
/* loaded from: classes23.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView gre;
    private BdListView kno;
    private NoDataView mNoDataView;
    private com.baidu.tieba.video.cloudmusic.a.a nBF;
    private d.a nBG;
    private CloudMusicData.MusicTagList nBH;
    private int tagId = 0;
    private int jFM = 1;
    private CustomMessageListener nBI = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.nBF != null) {
                CloudMusicListFragment.this.nBF.notifyDataSetChanged();
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

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_cloud_music_list, viewGroup, false);
        this.nBH = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.kno = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.nBF = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.kno.setAdapter((ListAdapter) this.nBF);
        this.kno.setExOnSrollToBottomListener(this);
        this.kno.setDivider(null);
        this.nBF.a(this);
        this.gre = new PbListView(getPageContext().getPageActivity());
        this.gre.createView();
        this.gre.setContainerBackgroundColorResId(R.color.CAM_X0201);
        this.gre.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.qP(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.nBH != null && this.nBG != null && this.nBH.page != null) {
            this.tagId = this.nBH.tag_id;
            this.jFM = this.nBH.page.has_more;
            this.nBG.c(this.nBH);
        }
        this.kno.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.isNetWorkAvailable()) {
                    CloudMusicListFragment.this.nBG.a(CloudMusicListFragment.this.nBF.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), R.string.neterror);
                }
            }
        });
        registerListener(this.nBI);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void v(BdListView bdListView) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(getPageContext().getPageActivity(), R.string.neterror);
        } else if (this.nBG != null && this.jFM != 0) {
            this.nBG.LZ(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.gre.changeSkin(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.nBG = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.nBH = musicTagList;
        if (this.nBF != null) {
            this.nBF.ge(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void yE(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void dTT() {
        if (this.gre != null) {
            if (this.gre.getView().getParent() == null) {
                this.kno.setNextPage(this.gre);
            }
            this.gre.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.gre.endLoadData();
        }
        this.jFM = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void yF(boolean z) {
        if (this.gre != null) {
            if (z) {
                if (this.gre.getView().getParent() == null) {
                    this.kno.setNextPage(this.gre);
                }
                this.gre.showLoadingViewWithoutEmptyView();
                this.gre.startLoadData();
                return;
            }
            this.gre.endLoadData();
            this.kno.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void LW(int i) {
        this.nBF.aj(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void LX(int i) {
        this.nBF.aj(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void LY(int i) {
        this.nBF.aj(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.nBG.dDF();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.nBG != null) {
            this.nBG.cFg();
        }
        com.baidu.tieba.video.cloudmusic.data.a.dUa().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.nBF != null && this.nBF.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.nBF.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
