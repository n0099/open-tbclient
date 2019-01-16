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
import com.baidu.tieba.e;
import com.baidu.tieba.video.cloudmusic.a.a;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView bPm;
    private BdListView eOm;
    private com.baidu.tieba.video.cloudmusic.a.a hEM;
    private d.a hEN;
    private CloudMusicData.MusicTagList hEO;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int dep = 1;
    private CustomMessageListener hEP = new CustomMessageListener(2921307) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.hEM != null) {
                CloudMusicListFragment.this.hEM.notifyDataSetChanged();
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
        View inflate = layoutInflater.inflate(e.h.fragment_cloud_music_list, viewGroup, false);
        this.hEO = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.eOm = (BdListView) inflate.findViewById(e.g.cloud_music_list_view);
        this.hEM = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.eOm.setAdapter((ListAdapter) this.hEM);
        this.eOm.setExOnSrollToBottomListener(this);
        this.eOm.setDivider(null);
        this.hEM.a(this);
        this.bPm = new PbListView(getPageContext().getPageActivity());
        this.bPm.oH();
        this.bPm.ex(e.d.cp_bg_line_d);
        this.bPm.ey(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(e.C0210e.ds200)), NoDataViewFactory.d.eq(e.j.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.hEO != null && this.hEN != null && this.hEO.page != null) {
            this.tagId = this.hEO.tag_id;
            this.dep = this.hEO.page.has_more;
            this.hEN.c(this.hEO);
        }
        this.eOm.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.kV()) {
                    CloudMusicListFragment.this.hEN.a(CloudMusicListFragment.this.hEM.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), e.j.neterror);
                }
            }
        });
        registerListener(this.hEP);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.kV()) {
            l.showToast(getPageContext().getPageActivity(), e.j.neterror);
        } else if (this.hEN != null && this.dep != 0) {
            this.hEN.wH(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.bPm.ey(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.hEN = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.hEO = musicTagList;
        if (this.hEM != null) {
            this.hEM.dY(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void nZ(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void bJx() {
        if (this.bPm != null) {
            if (this.bPm.getView().getParent() == null) {
                this.eOm.setNextPage(this.bPm);
            }
            this.bPm.setText(getPageContext().getResources().getString(e.j.cloud_music_from_baidu_music));
            this.bPm.Fq();
        }
        this.dep = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void oa(boolean z) {
        if (this.bPm != null) {
            if (z) {
                if (this.bPm.getView().getParent() == null) {
                    this.eOm.setNextPage(this.bPm);
                }
                this.bPm.Fu();
                this.bPm.Fp();
                return;
            }
            this.bPm.Fq();
            this.eOm.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void wE(int i) {
        this.hEM.F(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void wF(int i) {
        this.hEM.F(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void wG(int i) {
        this.hEM.F(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), e.j.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.hEN.buF();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hEN != null) {
            this.hEN.aEp();
        }
        com.baidu.tieba.video.cloudmusic.data.a.bJE().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.hEM != null && this.hEM.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.hEM.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
