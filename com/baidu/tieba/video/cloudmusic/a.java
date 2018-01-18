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
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import com.baidu.tieba.video.cloudmusic.a.a;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.e;
/* loaded from: classes2.dex */
public class a extends BaseFragment implements BdListView.f, a.b, e.b {
    private PbListView bYR;
    private BdListView eue;
    private com.baidu.tieba.video.cloudmusic.a.a hmQ;
    private e.a hmR;
    private CloudMusicData.MusicTagList hmS;
    private h mNoDataView;
    private int tagId = 0;
    private int cZP = 1;
    private CustomMessageListener hmT = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && a.this.hmQ != null) {
                a.this.hmQ.notifyDataSetChanged();
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
        this.hmS = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.eue = (BdListView) inflate.findViewById(d.g.cloud_music_list_view);
        this.hmQ = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.eue.setAdapter((ListAdapter) this.hmQ);
        this.eue.setExOnSrollToBottomListener(this);
        this.eue.setDivider(null);
        this.hmQ.a(this);
        this.bYR = new PbListView(getPageContext().getPageActivity());
        this.bYR.su();
        this.bYR.gu(d.C0107d.cp_bg_line_d);
        this.bYR.gv(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds200)), NoDataViewFactory.d.gn(d.j.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.hmS != null && this.hmR != null && this.hmS.page != null) {
            this.tagId = this.hmS.tag_id;
            this.cZP = this.hmS.page.has_more;
            this.hmR.c(this.hmS);
        }
        this.eue.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.oI()) {
                    a.this.hmR.a(a.this.hmQ.getItem(i), i);
                } else {
                    l.showToast(a.this.getPageContext().getPageActivity(), d.j.neterror);
                }
            }
        });
        registerListener(this.hmT);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.oI()) {
            l.showToast(getPageContext().getPageActivity(), d.j.neterror);
        } else if (this.hmR != null && this.cZP != 0) {
            this.hmR.wJ(this.tagId);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.bYR.gv(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void a(e.a aVar) {
        this.hmR = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.hmS = musicTagList;
        if (this.hmQ != null) {
            this.hmQ.dB(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void mZ(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void bAf() {
        if (this.bYR != null) {
            if (this.bYR.getView().getParent() == null) {
                this.eue.setNextPage(this.bYR);
            }
            this.bYR.setText(getPageContext().getResources().getString(d.j.cloud_music_from_baidu_music));
            this.bYR.DL();
        }
        this.cZP = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void na(boolean z) {
        if (this.bYR != null) {
            if (z) {
                if (this.bYR.getView().getParent() == null) {
                    this.eue.setNextPage(this.bYR);
                }
                this.bYR.DO();
                this.bYR.DK();
                return;
            }
            this.bYR.DL();
            this.eue.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void wG(int i) {
        this.hmQ.O(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void wH(int i) {
        this.hmQ.O(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void wI(int i) {
        this.hmQ.O(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), d.j.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.hmR.blP();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.hmR != null) {
            this.hmR.avN();
        }
        com.baidu.tieba.video.cloudmusic.data.a.bAm().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void a(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.hmQ != null && this.hmQ.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.hmQ.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
