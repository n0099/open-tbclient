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
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.d;
import com.baidu.tieba.video.cloudmusic.a.a;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.e;
/* loaded from: classes2.dex */
public class a extends BaseFragment implements BdListView.f, a.b, e.b {
    private PbListView blu;
    private BdListView buZ;
    private com.baidu.tieba.video.cloudmusic.a.a gNx;
    private e.a gNy;
    private CloudMusicData.MusicTagList gNz;
    private f mNoDataView;
    private int gNA = 0;
    private int cgr = 1;
    private CustomMessageListener gNB = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && a.this.gNx != null) {
                a.this.gNx.notifyDataSetChanged();
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
        this.gNz = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.buZ = (BdListView) inflate.findViewById(d.g.cloud_music_list_view);
        this.gNx = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.buZ.setAdapter((ListAdapter) this.gNx);
        this.buZ.setExOnSrollToBottomListener(this);
        this.buZ.setDivider(null);
        this.gNx.a(this);
        this.blu = new PbListView(getPageContext().getPageActivity());
        this.blu.kX();
        this.blu.dy(d.C0082d.cp_bg_line_d);
        this.blu.dz(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), NoDataViewFactory.d.dq(d.j.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.gNz != null && this.gNy != null && this.gNz.page != null) {
            this.gNA = this.gNz.tag_id;
            this.cgr = this.gNz.page.has_more;
            this.gNy.c(this.gNz);
        }
        this.buZ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.hh()) {
                    a.this.gNy.a(a.this.gNx.getItem(i), i);
                } else {
                    l.showToast(a.this.getPageContext().getPageActivity(), d.j.neterror);
                }
            }
        });
        registerListener(this.gNB);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.hh()) {
            l.showToast(getPageContext().getPageActivity(), d.j.neterror);
        } else if (this.gNy != null && this.cgr != 0) {
            this.gNy.vg(this.gNA);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.blu.dz(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void a(e.a aVar) {
        this.gNy = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.gNz = musicTagList;
        if (this.gNx != null) {
            this.gNx.dN(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void nB(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void bAE() {
        if (this.blu != null) {
            if (this.blu.getView().getParent() == null) {
                this.buZ.setNextPage(this.blu);
            }
            this.blu.setText(getPageContext().getResources().getString(d.j.cloud_music_from_baidu_music));
            this.blu.wy();
        }
        this.cgr = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void nC(boolean z) {
        if (this.blu != null) {
            if (z) {
                if (this.blu.getView().getParent() == null) {
                    this.buZ.setNextPage(this.blu);
                }
                this.blu.wB();
                this.blu.wx();
                return;
            }
            this.blu.wy();
            this.buZ.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void vd(int i) {
        this.gNx.D(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void ve(int i) {
        this.gNx.D(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void vf(int i) {
        this.gNx.D(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), d.j.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.gNy.bkH();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gNy != null) {
            this.gNy.amU();
        }
        com.baidu.tieba.video.cloudmusic.data.a.bAL().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void b(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.gNx != null && this.gNx.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.gNx.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
