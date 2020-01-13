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
/* loaded from: classes8.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView ehe;
    private BdListView htf;
    private com.baidu.tieba.video.cloudmusic.a.a kup;
    private d.a kuq;
    private CloudMusicData.MusicTagList kur;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int gRy = 1;
    private CustomMessageListener kus = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.kup != null) {
                CloudMusicListFragment.this.kup.notifyDataSetChanged();
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
        this.kur = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.htf = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.kup = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.htf.setAdapter((ListAdapter) this.kup);
        this.htf.setExOnSrollToBottomListener(this);
        this.htf.setDivider(null);
        this.kup.a(this);
        this.ehe = new PbListView(getPageContext().getPageActivity());
        this.ehe.createView();
        this.ehe.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.ehe.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.kQ(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.kur != null && this.kuq != null && this.kur.page != null) {
            this.tagId = this.kur.tag_id;
            this.gRy = this.kur.page.has_more;
            this.kuq.c(this.kur);
        }
        this.htf.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.isNetWorkAvailable()) {
                    CloudMusicListFragment.this.kuq.a(CloudMusicListFragment.this.kup.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), (int) R.string.neterror);
                }
            }
        });
        registerListener(this.kus);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void v(BdListView bdListView) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.neterror);
        } else if (this.kuq != null && this.gRy != 0) {
            this.kuq.Dq(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.ehe.changeSkin(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.kuq = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.kur = musicTagList;
        if (this.kup != null) {
            this.kup.es(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void ti(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void cNQ() {
        if (this.ehe != null) {
            if (this.ehe.getView().getParent() == null) {
                this.htf.setNextPage(this.ehe);
            }
            this.ehe.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.ehe.endLoadData();
        }
        this.gRy = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void tj(boolean z) {
        if (this.ehe != null) {
            if (z) {
                if (this.ehe.getView().getParent() == null) {
                    this.htf.setNextPage(this.ehe);
                }
                this.ehe.showLoadingViewWithoutEmptyView();
                this.ehe.startLoadData();
                return;
            }
            this.ehe.endLoadData();
            this.htf.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Dn(int i) {
        this.kup.T(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Do(int i) {
        this.kup.T(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Dp(int i) {
        this.kup.T(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.kuq.czp();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.kuq != null) {
            this.kuq.bER();
        }
        com.baidu.tieba.video.cloudmusic.data.a.cNX().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.kup != null && this.kup.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.kup.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
