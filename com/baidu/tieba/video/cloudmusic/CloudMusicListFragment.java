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
/* loaded from: classes22.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView giV;
    private BdListView jZJ;
    private NoDataView mNoDataView;
    private com.baidu.tieba.video.cloudmusic.a.a nnC;
    private d.a nnD;
    private CloudMusicData.MusicTagList nnE;
    private int tagId = 0;
    private int jsm = 1;
    private CustomMessageListener nnF = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.nnC != null) {
                CloudMusicListFragment.this.nnC.notifyDataSetChanged();
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
        this.nnE = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.jZJ = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.nnC = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.jZJ.setAdapter((ListAdapter) this.nnC);
        this.jZJ.setExOnSrollToBottomListener(this);
        this.jZJ.setDivider(null);
        this.nnC.a(this);
        this.giV = new PbListView(getPageContext().getPageActivity());
        this.giV.createView();
        this.giV.setContainerBackgroundColorResId(R.color.CAM_X0201);
        this.giV.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.qo(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.nnE != null && this.nnD != null && this.nnE.page != null) {
            this.tagId = this.nnE.tag_id;
            this.jsm = this.nnE.page.has_more;
            this.nnD.c(this.nnE);
        }
        this.jZJ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.isNetWorkAvailable()) {
                    CloudMusicListFragment.this.nnD.a(CloudMusicListFragment.this.nnC.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), R.string.neterror);
                }
            }
        });
        registerListener(this.nnF);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void v(BdListView bdListView) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(getPageContext().getPageActivity(), R.string.neterror);
        } else if (this.nnD != null && this.jsm != 0) {
            this.nnD.Lh(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.giV.changeSkin(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.nnD = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.nnE = musicTagList;
        if (this.nnC != null) {
            this.nnC.fQ(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void xZ(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void dOB() {
        if (this.giV != null) {
            if (this.giV.getView().getParent() == null) {
                this.jZJ.setNextPage(this.giV);
            }
            this.giV.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.giV.endLoadData();
        }
        this.jsm = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void ya(boolean z) {
        if (this.giV != null) {
            if (z) {
                if (this.giV.getView().getParent() == null) {
                    this.jZJ.setNextPage(this.giV);
                }
                this.giV.showLoadingViewWithoutEmptyView();
                this.giV.startLoadData();
                return;
            }
            this.giV.endLoadData();
            this.jZJ.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Le(int i) {
        this.nnC.aj(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Lf(int i) {
        this.nnC.aj(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Lg(int i) {
        this.nnC.aj(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.nnD.dyo();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.nnD != null) {
            this.nnD.cAQ();
        }
        com.baidu.tieba.video.cloudmusic.data.a.dOI().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.nnC != null && this.nnC.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.nnC.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
