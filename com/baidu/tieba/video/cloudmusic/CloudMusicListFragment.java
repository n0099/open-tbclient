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
    private PbListView fTv;
    private BdListView jGE;
    private NoDataView mNoDataView;
    private com.baidu.tieba.video.cloudmusic.a.a mTY;
    private d.a mTZ;
    private CloudMusicData.MusicTagList mUa;
    private int tagId = 0;
    private int iZn = 1;
    private CustomMessageListener mUb = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.mTY != null) {
                CloudMusicListFragment.this.mTY.notifyDataSetChanged();
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
        this.mUa = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.jGE = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.mTY = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.jGE.setAdapter((ListAdapter) this.mTY);
        this.jGE.setExOnSrollToBottomListener(this);
        this.jGE.setDivider(null);
        this.mTY.a(this);
        this.fTv = new PbListView(getPageContext().getPageActivity());
        this.fTv.createView();
        this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.fTv.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.pv(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.mUa != null && this.mTZ != null && this.mUa.page != null) {
            this.tagId = this.mUa.tag_id;
            this.iZn = this.mUa.page.has_more;
            this.mTZ.c(this.mUa);
        }
        this.jGE.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.isNetWorkAvailable()) {
                    CloudMusicListFragment.this.mTZ.a(CloudMusicListFragment.this.mTY.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), R.string.neterror);
                }
            }
        });
        registerListener(this.mUb);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void v(BdListView bdListView) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(getPageContext().getPageActivity(), R.string.neterror);
        } else if (this.mTZ != null && this.iZn != 0) {
            this.mTZ.JZ(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.fTv.changeSkin(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.mTZ = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.mUa = musicTagList;
        if (this.mTY != null) {
            this.mTY.fz(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void xs(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void dIS() {
        if (this.fTv != null) {
            if (this.fTv.getView().getParent() == null) {
                this.jGE.setNextPage(this.fTv);
            }
            this.fTv.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.fTv.endLoadData();
        }
        this.iZn = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void xt(boolean z) {
        if (this.fTv != null) {
            if (z) {
                if (this.fTv.getView().getParent() == null) {
                    this.jGE.setNextPage(this.fTv);
                }
                this.fTv.showLoadingViewWithoutEmptyView();
                this.fTv.startLoadData();
                return;
            }
            this.fTv.endLoadData();
            this.jGE.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void JW(int i) {
        this.mTY.aj(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void JX(int i) {
        this.mTY.aj(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void JY(int i) {
        this.mTY.aj(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mTZ.dtf();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mTZ != null) {
            this.mTZ.cvF();
        }
        com.baidu.tieba.video.cloudmusic.data.a.dIZ().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.mTY != null && this.mTY.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.mTY.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
