package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class h {
    private BaseActivity bSC;
    private d gbG;
    private e gbH;
    private com.baidu.tieba.d.c gbI;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.bSC = baseActivity;
    }

    public void a(bj bjVar, bd bdVar, int i) {
        af(bdVar);
        b(bjVar, bdVar, i);
    }

    private void af(bd bdVar) {
        if (bdVar != null) {
            if (this.gbG == null) {
                this.gbG = new d(LayoutInflater.from(this.bSC.getPageContext().getPageActivity()).inflate(d.h.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.gbG.ac(bdVar);
        }
    }

    public View bhm() {
        if (this.gbG == null) {
            return null;
        }
        return this.gbG.mRootView;
    }

    private void b(bj bjVar, bd bdVar, int i) {
        if (bjVar != null && bdVar != null) {
            if (this.gbH == null) {
                this.gbH = new e(this.bSC, LayoutInflater.from(this.bSC.getPageContext().getPageActivity()).inflate(d.h.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bjVar.aQF = i;
            this.gbH.ad(bdVar);
            bdVar.a(bjVar);
        }
    }

    public View bhn() {
        if (this.gbH == null) {
            return null;
        }
        return this.gbH.getRootView();
    }

    public void ag(bd bdVar) {
        if (this.gbH != null && bdVar != null && bdVar.Ao() != null && bdVar.Ao().aQF == 2) {
            if (this.gbI == null) {
                this.gbI = new com.baidu.tieba.d.c(this.bSC.getPageContext(), this.gbH.bhj());
                this.gbI.lT(5000);
            }
            this.gbI.g(this.bSC.getResources().getString(d.j.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void y(long j, int i) {
        if (this.gbH != null && j > 0) {
            this.gbH.i(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gbG != null) {
                this.gbG.Ja();
            }
            if (this.gbH != null) {
                this.gbH.Ja();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.gbG != null) {
            bdTypeListView.removeHeaderView(this.gbG.mRootView);
        }
        if (this.gbH != null) {
            bdTypeListView.removeHeaderView(this.gbH.getRootView());
        }
    }

    public void onDestroy() {
        bho();
    }

    public void bho() {
        if (this.gbI != null) {
            this.gbI.ang();
        }
    }
}
