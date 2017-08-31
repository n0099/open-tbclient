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
    private BaseActivity bnd;
    private d eYf;
    private e eYg;
    private com.baidu.tieba.d.a eYh;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.bnd = baseActivity;
    }

    public void a(bo boVar, bj bjVar, int i) {
        af(bjVar);
        b(boVar, bjVar, i);
    }

    private void af(bj bjVar) {
        if (bjVar != null) {
            if (this.eYf == null) {
                this.eYf = new d(LayoutInflater.from(this.bnd.getPageContext().getPageActivity()).inflate(d.j.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.eYf.ac(bjVar);
        }
    }

    public View aVL() {
        if (this.eYf == null) {
            return null;
        }
        return this.eYf.mRootView;
    }

    private void b(bo boVar, bj bjVar, int i) {
        if (boVar != null && bjVar != null) {
            if (this.eYg == null) {
                this.eYg = new e(this.bnd, LayoutInflater.from(this.bnd.getPageContext().getPageActivity()).inflate(d.j.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            boVar.aas = i;
            this.eYg.ad(bjVar);
            bjVar.a(boVar);
        }
    }

    public View aVM() {
        if (this.eYg == null) {
            return null;
        }
        return this.eYg.getRootView();
    }

    public void ag(bj bjVar) {
        if (this.eYg != null && bjVar != null && bjVar.sF() != null && bjVar.sF().aas == 2) {
            if (this.eYh == null) {
                this.eYh = new com.baidu.tieba.d.a(this.bnd.getPageContext(), this.eYg.aVI());
                this.eYh.hV(5000);
            }
            this.eYh.g(this.bnd.getResources().getString(d.l.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void w(long j, int i) {
        if (this.eYg != null && j > 0) {
            this.eYg.k(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.eYf != null) {
                this.eYf.Ba();
            }
            if (this.eYg != null) {
                this.eYg.Ba();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.eYf != null) {
            bdTypeListView.removeHeaderView(this.eYf.mRootView);
        }
        if (this.eYg != null) {
            bdTypeListView.removeHeaderView(this.eYg.getRootView());
        }
    }

    public void onDestroy() {
        aVN();
    }

    public void aVN() {
        if (this.eYh != null) {
            this.eYh.ZD();
        }
    }
}
