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
import com.baidu.tieba.d;
import com.baidu.tieba.video.cloudmusic.a.a;
import com.baidu.tieba.video.cloudmusic.d;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes2.dex */
public class CloudMusicListFragment extends BaseFragment implements BdListView.f, a.b, d.b {
    private PbListView buU;
    private BdListView ejE;
    private com.baidu.tieba.video.cloudmusic.a.a hbc;
    private d.a hbd;
    private CloudMusicData.MusicTagList hbe;
    private NoDataView mNoDataView;
    private int tagId = 0;
    private int cCk = 1;
    private CustomMessageListener hbf = new CustomMessageListener(2921307) { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && CloudMusicListFragment.this.hbc != null) {
                CloudMusicListFragment.this.hbc.notifyDataSetChanged();
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
        View inflate = layoutInflater.inflate(d.i.fragment_cloud_music_list, viewGroup, false);
        this.hbe = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.ejE = (BdListView) inflate.findViewById(d.g.cloud_music_list_view);
        this.hbc = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.ejE.setAdapter((ListAdapter) this.hbc);
        this.ejE.setExOnSrollToBottomListener(this);
        this.ejE.setDivider(null);
        this.hbc.a(this);
        this.buU = new PbListView(getPageContext().getPageActivity());
        this.buU.nn();
        this.buU.dy(d.C0142d.cp_bg_line_d);
        this.buU.dz(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), NoDataViewFactory.d.ds(d.k.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.hbe != null && this.hbd != null && this.hbe.page != null) {
            this.tagId = this.hbe.tag_id;
            this.cCk = this.hbe.page.has_more;
            this.hbd.c(this.hbe);
        }
        this.ejE.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.CloudMusicListFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.jD()) {
                    CloudMusicListFragment.this.hbd.a(CloudMusicListFragment.this.hbc.getItem(i), i);
                } else {
                    l.showToast(CloudMusicListFragment.this.getPageContext().getPageActivity(), d.k.neterror);
                }
            }
        });
        registerListener(this.hbf);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.jD()) {
            l.showToast(getPageContext().getPageActivity(), d.k.neterror);
        } else if (this.hbd != null && this.cCk != 0) {
            this.hbd.uF(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.buU.dz(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void a(d.a aVar) {
        this.hbd = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.hbe = musicTagList;
        if (this.hbc != null) {
            this.hbc.dJ(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void nf(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void bBF() {
        if (this.buU != null) {
            if (this.buU.getView().getParent() == null) {
                this.ejE.setNextPage(this.buU);
            }
            this.buU.setText(getPageContext().getResources().getString(d.k.cloud_music_from_baidu_music));
            this.buU.AI();
        }
        this.cCk = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void ng(boolean z) {
        if (this.buU != null) {
            if (z) {
                if (this.buU.getView().getParent() == null) {
                    this.ejE.setNextPage(this.buU);
                }
                this.buU.AN();
                this.buU.AH();
                return;
            }
            this.buU.AI();
            this.ejE.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void uC(int i) {
        this.hbc.F(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void uD(int i) {
        this.hbc.F(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.d.b
    public void uE(int i) {
        this.hbc.F(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), d.k.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.hbd.bnL();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hbd != null) {
            this.hbd.avN();
        }
        com.baidu.tieba.video.cloudmusic.data.a.bBM().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.hbc != null && this.hbc.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.hbc.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
