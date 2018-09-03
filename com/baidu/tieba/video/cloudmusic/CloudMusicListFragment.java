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
import com.baidu.tieba.f;
import com.baidu.tieba.video.cloudmusic.a.a;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView bvC;
    private BdListView ens;
    private com.baidu.tieba.video.cloudmusic.a.a hcq;
    private d.a hcr;
    private CloudMusicData.MusicTagList hcs;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int cEM = 1;
    private CustomMessageListener hct = new CustomMessageListener(2921307) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.hcq != null) {
                CloudMusicListFragment.this.hcq.notifyDataSetChanged();
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
        View inflate = layoutInflater.inflate(f.h.fragment_cloud_music_list, viewGroup, false);
        this.hcs = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.ens = (BdListView) inflate.findViewById(f.g.cloud_music_list_view);
        this.hcq = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.ens.setAdapter((ListAdapter) this.hcq);
        this.ens.setExOnSrollToBottomListener(this);
        this.ens.setDivider(null);
        this.hcq.a(this);
        this.bvC = new PbListView(getPageContext().getPageActivity());
        this.bvC.np();
        this.bvC.dA(f.d.cp_bg_line_d);
        this.bvC.dB(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(f.e.ds200)), NoDataViewFactory.d.dt(f.j.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.hcs != null && this.hcr != null && this.hcs.page != null) {
            this.tagId = this.hcs.tag_id;
            this.cEM = this.hcs.page.has_more;
            this.hcr.c(this.hcs);
        }
        this.ens.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.jE()) {
                    CloudMusicListFragment.this.hcr.a(CloudMusicListFragment.this.hcq.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), f.j.neterror);
                }
            }
        });
        registerListener(this.hct);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.jE()) {
            l.showToast(getPageContext().getPageActivity(), f.j.neterror);
        } else if (this.hcr != null && this.cEM != 0) {
            this.hcr.uE(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.bvC.dB(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.hcr = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.hcs = musicTagList;
        if (this.hcq != null) {
            this.hcq.dF(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void mR(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void bAs() {
        if (this.bvC != null) {
            if (this.bvC.getView().getParent() == null) {
                this.ens.setNextPage(this.bvC);
            }
            this.bvC.setText(getPageContext().getResources().getString(f.j.cloud_music_from_baidu_music));
            this.bvC.Aw();
        }
        this.cEM = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void mS(boolean z) {
        if (this.bvC != null) {
            if (z) {
                if (this.bvC.getView().getParent() == null) {
                    this.ens.setNextPage(this.bvC);
                }
                this.bvC.AA();
                this.bvC.Av();
                return;
            }
            this.bvC.Aw();
            this.ens.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void uB(int i) {
        this.hcq.E(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void uC(int i) {
        this.hcq.E(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void uD(int i) {
        this.hcq.E(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), f.j.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.hcr.bmb();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hcr != null) {
            this.hcr.awr();
        }
        com.baidu.tieba.video.cloudmusic.data.a.bAz().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.hcq != null && this.hcq.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.hcq.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
