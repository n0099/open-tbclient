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
/* loaded from: classes10.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView ePr;
    private BdListView igL;
    private com.baidu.tieba.video.cloudmusic.a.a lhC;
    private d.a lhD;
    private CloudMusicData.MusicTagList lhE;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int hEQ = 1;
    private CustomMessageListener lhF = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.lhC != null) {
                CloudMusicListFragment.this.lhC.notifyDataSetChanged();
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
        this.lhE = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.igL = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.lhC = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.igL.setAdapter((ListAdapter) this.lhC);
        this.igL.setExOnSrollToBottomListener(this);
        this.igL.setDivider(null);
        this.lhC.a(this);
        this.ePr = new PbListView(getPageContext().getPageActivity());
        this.ePr.createView();
        this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.ePr.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.lr(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.lhE != null && this.lhD != null && this.lhE.page != null) {
            this.tagId = this.lhE.tag_id;
            this.hEQ = this.lhE.page.has_more;
            this.lhD.c(this.lhE);
        }
        this.igL.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.isNetWorkAvailable()) {
                    CloudMusicListFragment.this.lhD.a(CloudMusicListFragment.this.lhC.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), (int) R.string.neterror);
                }
            }
        });
        registerListener(this.lhF);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void v(BdListView bdListView) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.neterror);
        } else if (this.lhD != null && this.hEQ != 0) {
            this.lhD.Ei(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.ePr.changeSkin(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.lhD = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.lhE = musicTagList;
        if (this.lhC != null) {
            this.lhC.eD(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void ut(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void daD() {
        if (this.ePr != null) {
            if (this.ePr.getView().getParent() == null) {
                this.igL.setNextPage(this.ePr);
            }
            this.ePr.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.ePr.endLoadData();
        }
        this.hEQ = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void uu(boolean z) {
        if (this.ePr != null) {
            if (z) {
                if (this.ePr.getView().getParent() == null) {
                    this.igL.setNextPage(this.ePr);
                }
                this.ePr.showLoadingViewWithoutEmptyView();
                this.ePr.startLoadData();
                return;
            }
            this.ePr.endLoadData();
            this.igL.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Ef(int i) {
        this.lhC.Y(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Eg(int i) {
        this.lhC.Y(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Eh(int i) {
        this.lhC.Y(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.lhD.cLR();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.lhD != null) {
            this.lhD.bRh();
        }
        com.baidu.tieba.video.cloudmusic.data.a.daK().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.lhC != null && this.lhC.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.lhC.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
