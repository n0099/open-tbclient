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
    private PbListView ePm;
    private BdListView igF;
    private CloudMusicData.MusicTagList lhA;
    private com.baidu.tieba.video.cloudmusic.a.a lhy;
    private d.a lhz;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int hEK = 1;
    private CustomMessageListener lhB = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.lhy != null) {
                CloudMusicListFragment.this.lhy.notifyDataSetChanged();
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
        this.lhA = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.igF = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.lhy = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.igF.setAdapter((ListAdapter) this.lhy);
        this.igF.setExOnSrollToBottomListener(this);
        this.igF.setDivider(null);
        this.lhy.a(this);
        this.ePm = new PbListView(getPageContext().getPageActivity());
        this.ePm.createView();
        this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.ePm.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.lr(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.lhA != null && this.lhz != null && this.lhA.page != null) {
            this.tagId = this.lhA.tag_id;
            this.hEK = this.lhA.page.has_more;
            this.lhz.c(this.lhA);
        }
        this.igF.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.isNetWorkAvailable()) {
                    CloudMusicListFragment.this.lhz.a(CloudMusicListFragment.this.lhy.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), (int) R.string.neterror);
                }
            }
        });
        registerListener(this.lhB);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void v(BdListView bdListView) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.neterror);
        } else if (this.lhz != null && this.hEK != 0) {
            this.lhz.Ei(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.ePm.changeSkin(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.lhz = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.lhA = musicTagList;
        if (this.lhy != null) {
            this.lhy.eD(musicTagList.music_list);
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
    public void daG() {
        if (this.ePm != null) {
            if (this.ePm.getView().getParent() == null) {
                this.igF.setNextPage(this.ePm);
            }
            this.ePm.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.ePm.endLoadData();
        }
        this.hEK = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void uu(boolean z) {
        if (this.ePm != null) {
            if (z) {
                if (this.ePm.getView().getParent() == null) {
                    this.igF.setNextPage(this.ePm);
                }
                this.ePm.showLoadingViewWithoutEmptyView();
                this.ePm.startLoadData();
                return;
            }
            this.ePm.endLoadData();
            this.igF.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Ef(int i) {
        this.lhy.Y(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Eg(int i) {
        this.lhy.Y(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Eh(int i) {
        this.lhy.Y(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.lhz.cLU();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.lhz != null) {
            this.lhz.bRj();
        }
        com.baidu.tieba.video.cloudmusic.data.a.daN().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.lhy != null && this.lhy.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.lhy.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
