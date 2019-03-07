package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class h {
    private BaseActivity cNd;
    private d hEA;
    private e hEB;
    private com.baidu.tieba.c.d hEC;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.cNd = baseActivity;
    }

    public void a(bm bmVar, bg bgVar, int i) {
        aC(bgVar);
        b(bmVar, bgVar, i);
    }

    private void aC(bg bgVar) {
        if (bgVar != null) {
            if (this.hEA == null) {
                this.hEA = new d(LayoutInflater.from(this.cNd.getPageContext().getPageActivity()).inflate(d.h.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.hEA.az(bgVar);
        }
    }

    public View bPa() {
        if (this.hEA == null) {
            return null;
        }
        return this.hEA.mRootView;
    }

    private void b(bm bmVar, bg bgVar, int i) {
        if (bmVar != null && bgVar != null) {
            if (this.hEB == null) {
                this.hEB = new e(this.cNd, LayoutInflater.from(this.cNd.getPageContext().getPageActivity()).inflate(d.h.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bmVar.bEg = i;
            this.hEB.aA(bgVar);
            bgVar.a(bmVar);
        }
    }

    public View bPb() {
        if (this.hEB == null) {
            return null;
        }
        return this.hEB.getRootView();
    }

    public void aD(bg bgVar) {
        if (this.hEB != null && bgVar != null && bgVar.aab() != null && bgVar.aab().bEg == 2) {
            if (this.hEC == null) {
                this.hEC = new com.baidu.tieba.c.d(this.cNd.getPageContext(), this.hEB.bOX());
                this.hEC.oL(5000);
            }
            this.hEC.s(this.cNd.getResources().getString(d.j.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void s(long j, int i) {
        if (this.hEB != null && j > 0) {
            this.hEB.o(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.hEA != null) {
                this.hEA.akb();
            }
            if (this.hEB != null) {
                this.hEB.akb();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.hEA != null) {
            bdTypeListView.removeHeaderView(this.hEA.mRootView);
        }
        if (this.hEB != null) {
            bdTypeListView.removeHeaderView(this.hEB.getRootView());
        }
    }

    public void onDestroy() {
        bPc();
    }

    public void bPc() {
        if (this.hEC != null) {
            this.hEC.aSr();
        }
    }
}
