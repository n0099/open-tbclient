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
    private PbListView fHm;
    private BdListView jrH;
    private com.baidu.tieba.video.cloudmusic.a.a mEl;
    private d.a mEm;
    private CloudMusicData.MusicTagList mEn;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int iKv = 1;
    private CustomMessageListener mEo = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.mEl != null) {
                CloudMusicListFragment.this.mEl.notifyDataSetChanged();
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
        this.mEn = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.jrH = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.mEl = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.jrH.setAdapter((ListAdapter) this.mEl);
        this.jrH.setExOnSrollToBottomListener(this);
        this.jrH.setDivider(null);
        this.mEl.a(this);
        this.fHm = new PbListView(getPageContext().getPageActivity());
        this.fHm.createView();
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.fHm.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.oW(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.mEn != null && this.mEm != null && this.mEn.page != null) {
            this.tagId = this.mEn.tag_id;
            this.iKv = this.mEn.page.has_more;
            this.mEm.c(this.mEn);
        }
        this.jrH.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.isNetWorkAvailable()) {
                    CloudMusicListFragment.this.mEm.a(CloudMusicListFragment.this.mEl.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), R.string.neterror);
                }
            }
        });
        registerListener(this.mEo);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void v(BdListView bdListView) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(getPageContext().getPageActivity(), R.string.neterror);
        } else if (this.mEm != null && this.iKv != 0) {
            this.mEm.Jt(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.fHm.changeSkin(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.mEm = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.mEn = musicTagList;
        if (this.mEl != null) {
            this.mEl.fw(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void wL(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void dFg() {
        if (this.fHm != null) {
            if (this.fHm.getView().getParent() == null) {
                this.jrH.setNextPage(this.fHm);
            }
            this.fHm.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.fHm.endLoadData();
        }
        this.iKv = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void wM(boolean z) {
        if (this.fHm != null) {
            if (z) {
                if (this.fHm.getView().getParent() == null) {
                    this.jrH.setNextPage(this.fHm);
                }
                this.fHm.showLoadingViewWithoutEmptyView();
                this.fHm.startLoadData();
                return;
            }
            this.fHm.endLoadData();
            this.jrH.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Jq(int i) {
        this.mEl.ah(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Jr(int i) {
        this.mEl.ah(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Js(int i) {
        this.mEl.ah(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mEm.dpu();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mEm != null) {
            this.mEm.csi();
        }
        com.baidu.tieba.video.cloudmusic.data.a.dFn().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.mEl != null && this.mEl.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.mEl.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
