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
    private PbListView bgE;
    private BdListView boi;
    private com.baidu.tieba.video.cloudmusic.a.a gCH;
    private e.a gCI;
    private CloudMusicData.MusicTagList gCJ;
    private f mNoDataView;
    private int gCK = 0;
    private int bXH = 1;
    private CustomMessageListener gCL = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && a.this.gCH != null) {
                a.this.gCH.notifyDataSetChanged();
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
        this.gCJ = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.boi = (BdListView) inflate.findViewById(d.g.cloud_music_list_view);
        this.gCH = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.boi.setAdapter((ListAdapter) this.gCH);
        this.boi.setExOnSrollToBottomListener(this);
        this.boi.setDivider(null);
        this.gCH.a(this);
        this.bgE = new PbListView(getPageContext().getPageActivity());
        this.bgE.kX();
        this.bgE.dy(d.C0080d.cp_bg_line_d);
        this.bgE.dz(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), NoDataViewFactory.d.dq(d.j.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.gCJ != null && this.gCI != null && this.gCJ.page != null) {
            this.gCK = this.gCJ.tag_id;
            this.bXH = this.gCJ.page.has_more;
            this.gCI.c(this.gCJ);
        }
        this.boi.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.hh()) {
                    a.this.gCI.a(a.this.gCH.getItem(i), i);
                } else {
                    l.showToast(a.this.getPageContext().getPageActivity(), d.j.neterror);
                }
            }
        });
        registerListener(this.gCL);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.hh()) {
            l.showToast(getPageContext().getPageActivity(), d.j.neterror);
        } else if (this.gCI != null && this.bXH != 0) {
            this.gCI.uK(this.gCK);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.bgE.dz(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void a(e.a aVar) {
        this.gCI = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.gCJ = musicTagList;
        if (this.gCH != null) {
            this.gCH.dA(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void mU(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void byp() {
        if (this.bgE != null) {
            if (this.bgE.getView().getParent() == null) {
                this.boi.setNextPage(this.bgE);
            }
            this.bgE.setText(getPageContext().getResources().getString(d.j.cloud_music_from_baidu_music));
            this.bgE.wu();
        }
        this.bXH = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void mV(boolean z) {
        if (this.bgE != null) {
            if (z) {
                if (this.bgE.getView().getParent() == null) {
                    this.boi.setNextPage(this.bgE);
                }
                this.bgE.wy();
                this.bgE.wt();
                return;
            }
            this.bgE.wu();
            this.boi.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void uH(int i) {
        this.gCH.D(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void uI(int i) {
        this.gCH.D(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void uJ(int i) {
        this.gCH.D(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), d.j.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.gCI.biw();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gCI != null) {
            this.gCI.akK();
        }
        com.baidu.tieba.video.cloudmusic.data.a.byw().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void b(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.gCH != null && this.gCH.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.gCH.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
