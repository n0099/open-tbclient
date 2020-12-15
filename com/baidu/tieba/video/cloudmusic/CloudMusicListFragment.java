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
    private PbListView grg;
    private BdListView knq;
    private NoDataView mNoDataView;
    private com.baidu.tieba.video.cloudmusic.a.a nBH;
    private d.a nBI;
    private CloudMusicData.MusicTagList nBJ;
    private int tagId = 0;
    private int jFO = 1;
    private CustomMessageListener nBK = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.nBH != null) {
                CloudMusicListFragment.this.nBH.notifyDataSetChanged();
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
        this.nBJ = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.knq = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.nBH = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.knq.setAdapter((ListAdapter) this.nBH);
        this.knq.setExOnSrollToBottomListener(this);
        this.knq.setDivider(null);
        this.nBH.a(this);
        this.grg = new PbListView(getPageContext().getPageActivity());
        this.grg.createView();
        this.grg.setContainerBackgroundColorResId(R.color.CAM_X0201);
        this.grg.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.qP(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.nBJ != null && this.nBI != null && this.nBJ.page != null) {
            this.tagId = this.nBJ.tag_id;
            this.jFO = this.nBJ.page.has_more;
            this.nBI.c(this.nBJ);
        }
        this.knq.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.isNetWorkAvailable()) {
                    CloudMusicListFragment.this.nBI.a(CloudMusicListFragment.this.nBH.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), R.string.neterror);
                }
            }
        });
        registerListener(this.nBK);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void v(BdListView bdListView) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(getPageContext().getPageActivity(), R.string.neterror);
        } else if (this.nBI != null && this.jFO != 0) {
            this.nBI.LZ(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.grg.changeSkin(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.nBI = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.nBJ = musicTagList;
        if (this.nBH != null) {
            this.nBH.ge(musicTagList.music_list);
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
    public void dTU() {
        if (this.grg != null) {
            if (this.grg.getView().getParent() == null) {
                this.knq.setNextPage(this.grg);
            }
            this.grg.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.grg.endLoadData();
        }
        this.jFO = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void yF(boolean z) {
        if (this.grg != null) {
            if (z) {
                if (this.grg.getView().getParent() == null) {
                    this.knq.setNextPage(this.grg);
                }
                this.grg.showLoadingViewWithoutEmptyView();
                this.grg.startLoadData();
                return;
            }
            this.grg.endLoadData();
            this.knq.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void LW(int i) {
        this.nBH.aj(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void LX(int i) {
        this.nBH.aj(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void LY(int i) {
        this.nBH.aj(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.nBI.dDG();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.nBI != null) {
            this.nBI.cFh();
        }
        com.baidu.tieba.video.cloudmusic.data.a.dUb().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.nBH != null && this.nBH.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.nBH.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
