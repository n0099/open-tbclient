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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.cloudmusic.a.a;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView dlX;
    private BdListView gvr;
    private com.baidu.tieba.video.cloudmusic.a.a jnZ;
    private d.a joa;
    private CloudMusicData.MusicTagList job;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int eDI = 1;
    private CustomMessageListener joc = new CustomMessageListener(2921307) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.jnZ != null) {
                CloudMusicListFragment.this.jnZ.notifyDataSetChanged();
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

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_cloud_music_list, viewGroup, false);
        this.job = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.gvr = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.jnZ = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.gvr.setAdapter((ListAdapter) this.jnZ);
        this.gvr.setExOnSrollToBottomListener(this);
        this.gvr.setDivider(null);
        this.jnZ.a(this);
        this.dlX = new PbListView(getPageContext().getPageActivity());
        this.dlX.nG();
        this.dlX.iO(R.color.cp_bg_line_d);
        this.dlX.iP(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.iH(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.job != null && this.joa != null && this.job.page != null) {
            this.tagId = this.job.tag_id;
            this.eDI = this.job.page.has_more;
            this.joa.c(this.job);
        }
        this.gvr.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.jS()) {
                    CloudMusicListFragment.this.joa.a(CloudMusicListFragment.this.jnZ.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), (int) R.string.neterror);
                }
            }
        });
        registerListener(this.joc);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.jS()) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.neterror);
        } else if (this.joa != null && this.eDI != 0) {
            this.joa.Bx(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.dlX.iP(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.joa = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.job = musicTagList;
        if (this.jnZ != null) {
            this.jnZ.el(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void ro(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void cqY() {
        if (this.dlX != null) {
            if (this.dlX.getView().getParent() == null) {
                this.gvr.setNextPage(this.dlX);
            }
            this.dlX.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.dlX.ajz();
        }
        this.eDI = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void rp(boolean z) {
        if (this.dlX != null) {
            if (z) {
                if (this.dlX.getView().getParent() == null) {
                    this.gvr.setNextPage(this.dlX);
                }
                this.dlX.ajE();
                this.dlX.ajy();
                return;
            }
            this.dlX.ajz();
            this.gvr.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Bu(int i) {
        this.jnZ.Q(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Bv(int i) {
        this.jnZ.Q(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Bw(int i) {
        this.jnZ.Q(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.joa.cdr();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.joa != null) {
            this.joa.bmo();
        }
        com.baidu.tieba.video.cloudmusic.data.a.crf().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.jnZ != null && this.jnZ.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.jnZ.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
