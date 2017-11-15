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
    private PbListView bgN;
    private BdListView bor;
    private com.baidu.tieba.video.cloudmusic.a.a gDP;
    private e.a gDQ;
    private CloudMusicData.MusicTagList gDR;
    private f mNoDataView;
    private int gDS = 0;
    private int bXU = 1;
    private CustomMessageListener gDT = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && a.this.gDP != null) {
                a.this.gDP.notifyDataSetChanged();
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
        this.gDR = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.bor = (BdListView) inflate.findViewById(d.g.cloud_music_list_view);
        this.gDP = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.bor.setAdapter((ListAdapter) this.gDP);
        this.bor.setExOnSrollToBottomListener(this);
        this.bor.setDivider(null);
        this.gDP.a(this);
        this.bgN = new PbListView(getPageContext().getPageActivity());
        this.bgN.kX();
        this.bgN.dx(d.C0080d.cp_bg_line_d);
        this.bgN.dy(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), NoDataViewFactory.d.dp(d.j.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.gDR != null && this.gDQ != null && this.gDR.page != null) {
            this.gDS = this.gDR.tag_id;
            this.bXU = this.gDR.page.has_more;
            this.gDQ.c(this.gDR);
        }
        this.bor.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.hh()) {
                    a.this.gDQ.a(a.this.gDP.getItem(i), i);
                } else {
                    l.showToast(a.this.getPageContext().getPageActivity(), d.j.neterror);
                }
            }
        });
        registerListener(this.gDT);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.hh()) {
            l.showToast(getPageContext().getPageActivity(), d.j.neterror);
        } else if (this.gDQ != null && this.bXU != 0) {
            this.gDQ.uO(this.gDS);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.bgN.dy(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void a(e.a aVar) {
        this.gDQ = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.gDR = musicTagList;
        if (this.gDP != null) {
            this.gDP.dB(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void nc(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void byB() {
        if (this.bgN != null) {
            if (this.bgN.getView().getParent() == null) {
                this.bor.setNextPage(this.bgN);
            }
            this.bgN.setText(getPageContext().getResources().getString(d.j.cloud_music_from_baidu_music));
            this.bgN.wu();
        }
        this.bXU = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void nd(boolean z) {
        if (this.bgN != null) {
            if (z) {
                if (this.bgN.getView().getParent() == null) {
                    this.bor.setNextPage(this.bgN);
                }
                this.bgN.wy();
                this.bgN.wt();
                return;
            }
            this.bgN.wu();
            this.bor.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void uL(int i) {
        this.gDP.E(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void uM(int i) {
        this.gDP.E(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void uN(int i) {
        this.gDP.E(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), d.j.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.gDQ.biH();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gDQ != null) {
            this.gDQ.akY();
        }
        com.baidu.tieba.video.cloudmusic.data.a.byI().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void b(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.gDP != null && this.gDP.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.gDP.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
