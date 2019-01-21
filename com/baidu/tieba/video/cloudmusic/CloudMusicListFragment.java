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
    private PbListView bPn;
    private BdListView eOn;
    private com.baidu.tieba.video.cloudmusic.a.a hEN;
    private d.a hEO;
    private CloudMusicData.MusicTagList hEP;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int deq = 1;
    private CustomMessageListener hEQ = new CustomMessageListener(2921307) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.hEN != null) {
                CloudMusicListFragment.this.hEN.notifyDataSetChanged();
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
        this.hEP = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.eOn = (BdListView) inflate.findViewById(e.g.cloud_music_list_view);
        this.hEN = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.eOn.setAdapter((ListAdapter) this.hEN);
        this.eOn.setExOnSrollToBottomListener(this);
        this.eOn.setDivider(null);
        this.hEN.a(this);
        this.bPn = new PbListView(getPageContext().getPageActivity());
        this.bPn.oH();
        this.bPn.ex(e.d.cp_bg_line_d);
        this.bPn.ey(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(e.C0210e.ds200)), NoDataViewFactory.d.eq(e.j.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.hEP != null && this.hEO != null && this.hEP.page != null) {
            this.tagId = this.hEP.tag_id;
            this.deq = this.hEP.page.has_more;
            this.hEO.c(this.hEP);
        }
        this.eOn.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.kV()) {
                    CloudMusicListFragment.this.hEO.a(CloudMusicListFragment.this.hEN.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), e.j.neterror);
                }
            }
        });
        registerListener(this.hEQ);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.kV()) {
            l.showToast(getPageContext().getPageActivity(), e.j.neterror);
        } else if (this.hEO != null && this.deq != 0) {
            this.hEO.wH(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.bPn.ey(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.hEO = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.hEP = musicTagList;
        if (this.hEN != null) {
            this.hEN.dY(musicTagList.music_list);
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
        if (this.bPn != null) {
            if (this.bPn.getView().getParent() == null) {
                this.eOn.setNextPage(this.bPn);
            }
            this.bPn.setText(getPageContext().getResources().getString(e.j.cloud_music_from_baidu_music));
            this.bPn.Fq();
        }
        this.deq = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void oa(boolean z) {
        if (this.bPn != null) {
            if (z) {
                if (this.bPn.getView().getParent() == null) {
                    this.eOn.setNextPage(this.bPn);
                }
                this.bPn.Fu();
                this.bPn.Fp();
                return;
            }
            this.bPn.Fq();
            this.eOn.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void wE(int i) {
        this.hEN.F(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void wF(int i) {
        this.hEN.F(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void wG(int i) {
        this.hEN.F(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), e.j.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.hEO.buF();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hEO != null) {
            this.hEO.aEp();
        }
        com.baidu.tieba.video.cloudmusic.data.a.bJE().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.hEN != null && this.hEN.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.hEN.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
