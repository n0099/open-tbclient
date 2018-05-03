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
    private d fwc;
    private e fwd;
    private com.baidu.tieba.d.c fwe;
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
            if (this.fwc == null) {
                this.fwc = new d(LayoutInflater.from(this.bcJ.getPageContext().getPageActivity()).inflate(d.i.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.fwc.ae(bdVar);
        }
    }

    public View bcn() {
        if (this.fwc == null) {
            return null;
        }
        return this.fwc.mRootView;
    }

    private void b(bj bjVar, bd bdVar, int i) {
        if (bjVar != null && bdVar != null) {
            if (this.fwd == null) {
                this.fwd = new e(this.bcJ, LayoutInflater.from(this.bcJ.getPageContext().getPageActivity()).inflate(d.i.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bjVar.ach = i;
            this.fwd.af(bdVar);
            bdVar.a(bjVar);
        }
    }

    public View bco() {
        if (this.fwd == null) {
            return null;
        }
        return this.fwd.getRootView();
    }

    public void ai(bd bdVar) {
        if (this.fwd != null && bdVar != null && bdVar.sQ() != null && bdVar.sQ().ach == 2) {
            if (this.fwe == null) {
                this.fwe = new com.baidu.tieba.d.c(this.bcJ.getPageContext(), this.fwd.bck());
                this.fwe.je(5000);
            }
            this.fwe.h(this.bcJ.getResources().getString(d.k.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void z(long j, int i) {
        if (this.fwd != null && j > 0) {
            this.fwd.n(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fwc != null) {
                this.fwc.BR();
            }
            if (this.fwd != null) {
                this.fwd.BR();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.fwc != null) {
            bdTypeListView.removeHeaderView(this.fwc.mRootView);
        }
        if (this.fwd != null) {
            bdTypeListView.removeHeaderView(this.fwd.getRootView());
        }
    }

    public void onDestroy() {
        bcp();
    }

    public void bcp() {
        if (this.fwe != null) {
            this.fwe.ahf();
        }
    }
}
