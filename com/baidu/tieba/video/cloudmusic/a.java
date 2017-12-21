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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.d;
import com.baidu.tieba.video.cloudmusic.a.a;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.e;
/* loaded from: classes2.dex */
public class a extends BaseFragment implements BdListView.f, a.b, e.b {
    private PbListView blz;
    private BdListView bve;
    private com.baidu.tieba.video.cloudmusic.a.a gQk;
    private e.a gQl;
    private CloudMusicData.MusicTagList gQm;
    private g mNoDataView;
    private int gQn = 0;
    private int cgJ = 1;
    private CustomMessageListener gQo = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && a.this.gQk != null) {
                a.this.gQk.notifyDataSetChanged();
            }
        }
    };

    public static a a(CloudMusicData.MusicTagList musicTagList) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("music_list_key", musicTagList);
        a aVar = new a();
        aVar.setArguments(bundle);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.fragment_cloud_music_list, viewGroup, false);
        this.gQm = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.bve = (BdListView) inflate.findViewById(d.g.cloud_music_list_view);
        this.gQk = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.bve.setAdapter((ListAdapter) this.gQk);
        this.bve.setExOnSrollToBottomListener(this);
        this.bve.setDivider(null);
        this.gQk.a(this);
        this.blz = new PbListView(getPageContext().getPageActivity());
        this.blz.kX();
        this.blz.dy(d.C0095d.cp_bg_line_d);
        this.blz.dz(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), NoDataViewFactory.d.dq(d.j.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.gQm != null && this.gQl != null && this.gQm.page != null) {
            this.gQn = this.gQm.tag_id;
            this.cgJ = this.gQm.page.has_more;
            this.gQl.c(this.gQm);
        }
        this.bve.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.hh()) {
                    a.this.gQl.a(a.this.gQk.getItem(i), i);
                } else {
                    l.showToast(a.this.getPageContext().getPageActivity(), d.j.neterror);
                }
            }
        });
        registerListener(this.gQo);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.hh()) {
            l.showToast(getPageContext().getPageActivity(), d.j.neterror);
        } else if (this.gQl != null && this.cgJ != 0) {
            this.gQl.vr(this.gQn);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.blz.dz(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void a(e.a aVar) {
        this.gQl = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.gQm = musicTagList;
        if (this.gQk != null) {
            this.gQk.dM(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void nD(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void bBl() {
        if (this.blz != null) {
            if (this.blz.getView().getParent() == null) {
                this.bve.setNextPage(this.blz);
            }
            this.blz.setText(getPageContext().getResources().getString(d.j.cloud_music_from_baidu_music));
            this.blz.ww();
        }
        this.cgJ = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void nE(boolean z) {
        if (this.blz != null) {
            if (z) {
                if (this.blz.getView().getParent() == null) {
                    this.bve.setNextPage(this.blz);
                }
                this.blz.wz();
                this.blz.wv();
                return;
            }
            this.blz.ww();
            this.bve.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void vo(int i) {
        this.gQk.D(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void vp(int i) {
        this.gQk.D(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void vq(int i) {
        this.gQk.D(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), d.j.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.gQl.bkP();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gQl != null) {
            this.gQl.and();
        }
        com.baidu.tieba.video.cloudmusic.data.a.bBs().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void b(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.gQk != null && this.gQk.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.gQk.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
