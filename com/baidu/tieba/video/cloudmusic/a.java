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
    private PbListView blv;
    private BdListView bva;
    private com.baidu.tieba.video.cloudmusic.a.a gQf;
    private e.a gQg;
    private CloudMusicData.MusicTagList gQh;
    private g mNoDataView;
    private int gQi = 0;
    private int cgF = 1;
    private CustomMessageListener gQj = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && a.this.gQf != null) {
                a.this.gQf.notifyDataSetChanged();
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
        this.gQh = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.bva = (BdListView) inflate.findViewById(d.g.cloud_music_list_view);
        this.gQf = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.bva.setAdapter((ListAdapter) this.gQf);
        this.bva.setExOnSrollToBottomListener(this);
        this.bva.setDivider(null);
        this.gQf.a(this);
        this.blv = new PbListView(getPageContext().getPageActivity());
        this.blv.kX();
        this.blv.dy(d.C0096d.cp_bg_line_d);
        this.blv.dz(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), NoDataViewFactory.d.dq(d.j.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.gQh != null && this.gQg != null && this.gQh.page != null) {
            this.gQi = this.gQh.tag_id;
            this.cgF = this.gQh.page.has_more;
            this.gQg.c(this.gQh);
        }
        this.bva.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.hh()) {
                    a.this.gQg.a(a.this.gQf.getItem(i), i);
                } else {
                    l.showToast(a.this.getPageContext().getPageActivity(), d.j.neterror);
                }
            }
        });
        registerListener(this.gQj);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.hh()) {
            l.showToast(getPageContext().getPageActivity(), d.j.neterror);
        } else if (this.gQg != null && this.cgF != 0) {
            this.gQg.vr(this.gQi);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.blv.dz(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void a(e.a aVar) {
        this.gQg = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.gQh = musicTagList;
        if (this.gQf != null) {
            this.gQf.dM(musicTagList.music_list);
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
        if (this.blv != null) {
            if (this.blv.getView().getParent() == null) {
                this.bva.setNextPage(this.blv);
            }
            this.blv.setText(getPageContext().getResources().getString(d.j.cloud_music_from_baidu_music));
            this.blv.ww();
        }
        this.cgF = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void nE(boolean z) {
        if (this.blv != null) {
            if (z) {
                if (this.blv.getView().getParent() == null) {
                    this.bva.setNextPage(this.blv);
                }
                this.blv.wz();
                this.blv.wv();
                return;
            }
            this.blv.ww();
            this.bva.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void vo(int i) {
        this.gQf.D(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void vp(int i) {
        this.gQf.D(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void vq(int i) {
        this.gQf.D(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), d.j.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.gQg.bkP();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gQg != null) {
            this.gQg.and();
        }
        com.baidu.tieba.video.cloudmusic.data.a.bBs().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void b(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.gQf != null && this.gQf.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.gQf.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
