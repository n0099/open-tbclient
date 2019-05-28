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
    private PbListView dlY;
    private BdListView gvs;
    private com.baidu.tieba.video.cloudmusic.a.a joa;
    private d.a job;
    private CloudMusicData.MusicTagList joc;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int eDJ = 1;
    private CustomMessageListener jod = new CustomMessageListener(2921307) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.joa != null) {
                CloudMusicListFragment.this.joa.notifyDataSetChanged();
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
        this.joc = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.gvs = (BdListView) inflate.findViewById(R.id.cloud_music_list_view);
        this.joa = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.gvs.setAdapter((ListAdapter) this.joa);
        this.gvs.setExOnSrollToBottomListener(this);
        this.gvs.setDivider(null);
        this.joa.a(this);
        this.dlY = new PbListView(getPageContext().getPageActivity());
        this.dlY.nG();
        this.dlY.iO(R.color.cp_bg_line_d);
        this.dlY.iP(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds200)), NoDataViewFactory.d.iH(R.string.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.joc != null && this.job != null && this.joc.page != null) {
            this.tagId = this.joc.tag_id;
            this.eDJ = this.joc.page.has_more;
            this.job.c(this.joc);
        }
        this.gvs.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.jS()) {
                    CloudMusicListFragment.this.job.a(CloudMusicListFragment.this.joa.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), (int) R.string.neterror);
                }
            }
        });
        registerListener(this.jod);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.jS()) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.neterror);
        } else if (this.job != null && this.eDJ != 0) {
            this.job.Bx(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.dlY.iP(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.job = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.joc = musicTagList;
        if (this.joa != null) {
            this.joa.el(musicTagList.music_list);
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
    public void cra() {
        if (this.dlY != null) {
            if (this.dlY.getView().getParent() == null) {
                this.gvs.setNextPage(this.dlY);
            }
            this.dlY.setText(getPageContext().getResources().getString(R.string.cloud_music_from_baidu_music));
            this.dlY.ajz();
        }
        this.eDJ = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void rp(boolean z) {
        if (this.dlY != null) {
            if (z) {
                if (this.dlY.getView().getParent() == null) {
                    this.gvs.setNextPage(this.dlY);
                }
                this.dlY.ajE();
                this.dlY.ajy();
                return;
            }
            this.dlY.ajz();
            this.gvs.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Bu(int i) {
        this.joa.Q(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Bv(int i) {
        this.joa.Q(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void Bw(int i) {
        this.joa.Q(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), (int) R.string.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.job.cdu();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.job != null) {
            this.job.bmr();
        }
        com.baidu.tieba.video.cloudmusic.data.a.crh().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.joa != null && this.joa.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.joa.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
