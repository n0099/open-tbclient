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
    private BaseActivity bcJ;
    private d fwf;
    private e fwg;
    private com.baidu.tieba.d.c fwh;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.bcJ = baseActivity;
    }

    public void a(bj bjVar, bd bdVar, int i) {
        ah(bdVar);
        b(bjVar, bdVar, i);
    }

    private void ah(bd bdVar) {
        if (bdVar != null) {
            if (this.fwf == null) {
                this.fwf = new d(LayoutInflater.from(this.bcJ.getPageContext().getPageActivity()).inflate(d.i.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.fwf.ae(bdVar);
        }
    }

    public View bcn() {
        if (this.fwf == null) {
            return null;
        }
        return this.fwf.mRootView;
    }

    private void b(bj bjVar, bd bdVar, int i) {
        if (bjVar != null && bdVar != null) {
            if (this.fwg == null) {
                this.fwg = new e(this.bcJ, LayoutInflater.from(this.bcJ.getPageContext().getPageActivity()).inflate(d.i.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bjVar.ach = i;
            this.fwg.af(bdVar);
            bdVar.a(bjVar);
        }
    }

    public View bco() {
        if (this.fwg == null) {
            return null;
        }
        return this.fwg.getRootView();
    }

    public void ai(bd bdVar) {
        if (this.fwg != null && bdVar != null && bdVar.sQ() != null && bdVar.sQ().ach == 2) {
            if (this.fwh == null) {
                this.fwh = new com.baidu.tieba.d.c(this.bcJ.getPageContext(), this.fwg.bck());
                this.fwh.je(5000);
            }
            this.fwh.h(this.bcJ.getResources().getString(d.k.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void z(long j, int i) {
        if (this.fwg != null && j > 0) {
            this.fwg.n(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fwf != null) {
                this.fwf.BR();
            }
            if (this.fwg != null) {
                this.fwg.BR();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.fwf != null) {
            bdTypeListView.removeHeaderView(this.fwf.mRootView);
        }
        if (this.fwg != null) {
            bdTypeListView.removeHeaderView(this.fwg.getRootView());
        }
    }

    public void onDestroy() {
        bcp();
    }

    public void bcp() {
        if (this.fwh != null) {
            this.fwh.ahf();
        }
    }
}
