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
    private PbListView bfN;
    private BdListView bmz;
    private com.baidu.tieba.video.cloudmusic.a.a gtP;
    private e.a gtQ;
    private CloudMusicData.MusicTagList gtR;
    private f mNoDataView;
    private int gtS = 0;
    private int bQc = 1;
    private CustomMessageListener gtT = new CustomMessageListener(CmdConfigCustom.CMD_ON_CLOUD_MUSIC_PLAY) { // from class: com.baidu.tieba.video.cloudmusic.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921307 && a.this.gtP != null) {
                a.this.gtP.notifyDataSetChanged();
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
        View inflate = layoutInflater.inflate(d.j.fragment_cloud_music_list, viewGroup, false);
        this.gtR = (CloudMusicData.MusicTagList) getArguments().getSerializable("music_list_key");
        this.bmz = (BdListView) inflate.findViewById(d.h.cloud_music_list_view);
        this.gtP = new com.baidu.tieba.video.cloudmusic.a.a(getPageContext());
        this.bmz.setAdapter((ListAdapter) this.gtP);
        this.bmz.setExOnSrollToBottomListener(this);
        this.bmz.setDivider(null);
        this.gtP.a(this);
        this.bfN = new PbListView(getPageContext().getPageActivity());
        this.bfN.ld();
        this.bfN.dx(d.e.cp_bg_line_d);
        this.bfN.dy(TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.f.ds200)), NoDataViewFactory.d.dp(d.l.no_data_text), null);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        if (this.gtR != null && this.gtQ != null && this.gtR.page != null) {
            this.gtS = this.gtR.tag_id;
            this.bQc = this.gtR.page.has_more;
            this.gtQ.c(this.gtR);
        }
        this.bmz.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.video.cloudmusic.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (j.hh()) {
                    a.this.gtQ.a(a.this.gtP.getItem(i), i);
                } else {
                    l.showToast(a.this.getPageContext().getPageActivity(), d.l.neterror);
                }
            }
        });
        registerListener(this.gtT);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void a(BdListView bdListView) {
        if (!j.hh()) {
            l.showToast(getPageContext().getPageActivity(), d.l.neterror);
        } else if (this.gtQ != null && this.bQc != 0) {
            this.gtQ.ut(this.gtS);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mSkinType = i;
        this.bfN.dy(i);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void a(e.a aVar) {
        this.gtQ = aVar;
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void b(CloudMusicData.MusicTagList musicTagList) {
        this.gtR = musicTagList;
        if (this.gtP != null) {
            this.gtP.dy(musicTagList.music_list);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void mY(boolean z) {
        if (z) {
            this.mNoDataView.setVisibility(0);
        } else {
            this.mNoDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void bvm() {
        if (this.bfN != null) {
            if (this.bfN.getView().getParent() == null) {
                this.bmz.setNextPage(this.bfN);
            }
            this.bfN.setText(getPageContext().getResources().getString(d.l.cloud_music_from_baidu_music));
            this.bfN.wn();
        }
        this.bQc = 0;
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void mZ(boolean z) {
        if (this.bfN != null) {
            if (z) {
                if (this.bfN.getView().getParent() == null) {
                    this.bmz.setNextPage(this.bfN);
                }
                this.bfN.wr();
                this.bfN.wm();
                return;
            }
            this.bfN.wn();
            this.bmz.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void uq(int i) {
        this.gtP.C(i, true);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void ur(int i) {
        this.gtP.C(i, false);
    }

    @Override // com.baidu.tieba.video.cloudmusic.e.b
    public void us(int i) {
        this.gtP.C(i, false);
        if (getPageContext() != null || getPageContext().getPageActivity() != null) {
            l.showToast(getPageContext().getPageActivity(), d.l.download_error);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.gtQ.bfk();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gtQ != null) {
            this.gtQ.aiy();
        }
        com.baidu.tieba.video.cloudmusic.data.a.bvt().onDestroy();
    }

    @Override // com.baidu.tieba.video.cloudmusic.a.a.b
    public void b(View view, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("music_resource", str);
        if (this.gtP != null && this.gtP.getItem(i) != null) {
            intent.putExtra("music_id", StringUtils.string(Integer.valueOf(this.gtP.getItem(i).music_id)));
        }
        getPageContext().getPageActivity().setResult(-1, intent);
        getPageContext().getPageActivity().finish();
    }
}
