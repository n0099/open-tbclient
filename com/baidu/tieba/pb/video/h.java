package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class h {
    private BaseActivity bnc;
    private d eYZ;
    private e eZa;
    private com.baidu.tieba.d.a eZb;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.bnc = baseActivity;
    }

    public void a(bo boVar, bj bjVar, int i) {
        af(bjVar);
        b(boVar, bjVar, i);
    }

    private void af(bj bjVar) {
        if (bjVar != null) {
            if (this.eYZ == null) {
                this.eYZ = new d(LayoutInflater.from(this.bnc.getPageContext().getPageActivity()).inflate(d.j.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.eYZ.ac(bjVar);
        }
    }

    public View aVW() {
        if (this.eYZ == null) {
            return null;
        }
        return this.eYZ.mRootView;
    }

    private void b(bo boVar, bj bjVar, int i) {
        if (boVar != null && bjVar != null) {
            if (this.eZa == null) {
                this.eZa = new e(this.bnc, LayoutInflater.from(this.bnc.getPageContext().getPageActivity()).inflate(d.j.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            boVar.aas = i;
            this.eZa.ad(bjVar);
            bjVar.a(boVar);
        }
    }

    public View aVX() {
        if (this.eZa == null) {
            return null;
        }
        return this.eZa.getRootView();
    }

    public void ag(bj bjVar) {
        if (this.eZa != null && bjVar != null && bjVar.sF() != null && bjVar.sF().aas == 2) {
            if (this.eZb == null) {
                this.eZb = new com.baidu.tieba.d.a(this.bnc.getPageContext(), this.eZa.aVT());
                this.eZb.hX(5000);
            }
            this.eZb.g(this.bnc.getResources().getString(d.l.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void w(long j, int i) {
        if (this.eZa != null && j > 0) {
            this.eZa.k(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.eYZ != null) {
                this.eYZ.Ba();
            }
            if (this.eZa != null) {
                this.eZa.Ba();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.eYZ != null) {
            bdTypeListView.removeHeaderView(this.eYZ.mRootView);
        }
        if (this.eZa != null) {
            bdTypeListView.removeHeaderView(this.eZa.getRootView());
        }
    }

    public void onDestroy() {
        aVY();
    }

    public void aVY() {
        if (this.eZb != null) {
            this.eZb.ZO();
        }
    }
}
