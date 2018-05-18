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
    private BaseActivity bcK;
    private d fxi;
    private e fxj;
    private com.baidu.tieba.d.c fxk;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.bcK = baseActivity;
    }

    public void a(bj bjVar, bd bdVar, int i) {
        ah(bdVar);
        b(bjVar, bdVar, i);
    }

    private void ah(bd bdVar) {
        if (bdVar != null) {
            if (this.fxi == null) {
                this.fxi = new d(LayoutInflater.from(this.bcK.getPageContext().getPageActivity()).inflate(d.i.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.fxi.ae(bdVar);
        }
    }

    public View bcn() {
        if (this.fxi == null) {
            return null;
        }
        return this.fxi.mRootView;
    }

    private void b(bj bjVar, bd bdVar, int i) {
        if (bjVar != null && bdVar != null) {
            if (this.fxj == null) {
                this.fxj = new e(this.bcK, LayoutInflater.from(this.bcK.getPageContext().getPageActivity()).inflate(d.i.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bjVar.aci = i;
            this.fxj.af(bdVar);
            bdVar.a(bjVar);
        }
    }

    public View bco() {
        if (this.fxj == null) {
            return null;
        }
        return this.fxj.getRootView();
    }

    public void ai(bd bdVar) {
        if (this.fxj != null && bdVar != null && bdVar.sP() != null && bdVar.sP().aci == 2) {
            if (this.fxk == null) {
                this.fxk = new com.baidu.tieba.d.c(this.bcK.getPageContext(), this.fxj.bck());
                this.fxk.jd(5000);
            }
            this.fxk.h(this.bcK.getResources().getString(d.k.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void y(long j, int i) {
        if (this.fxj != null && j > 0) {
            this.fxj.l(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fxi != null) {
                this.fxi.BP();
            }
            if (this.fxj != null) {
                this.fxj.BP();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.fxi != null) {
            bdTypeListView.removeHeaderView(this.fxi.mRootView);
        }
        if (this.fxj != null) {
            bdTypeListView.removeHeaderView(this.fxj.getRootView());
        }
    }

    public void onDestroy() {
        bcp();
    }

    public void bcp() {
        if (this.fxk != null) {
            this.fxk.ahf();
        }
    }
}
