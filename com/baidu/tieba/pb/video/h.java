package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class h {
    private BaseActivity byz;
    private d fiP;
    private e fiQ;
    private com.baidu.tieba.d.b fiR;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.byz = baseActivity;
    }

    public void a(bj bjVar, bd bdVar, int i) {
        ab(bdVar);
        b(bjVar, bdVar, i);
    }

    private void ab(bd bdVar) {
        if (bdVar != null) {
            if (this.fiP == null) {
                this.fiP = new d(LayoutInflater.from(this.byz.getPageContext().getPageActivity()).inflate(d.h.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.fiP.Y(bdVar);
        }
    }

    public View aYj() {
        if (this.fiP == null) {
            return null;
        }
        return this.fiP.mRootView;
    }

    private void b(bj bjVar, bd bdVar, int i) {
        if (bjVar != null && bdVar != null) {
            if (this.fiQ == null) {
                this.fiQ = new e(this.byz, LayoutInflater.from(this.byz.getPageContext().getPageActivity()).inflate(d.h.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bjVar.aaY = i;
            this.fiQ.Z(bdVar);
            bdVar.a(bjVar);
        }
    }

    public View aYk() {
        if (this.fiQ == null) {
            return null;
        }
        return this.fiQ.getRootView();
    }

    public void ac(bd bdVar) {
        if (this.fiQ != null && bdVar != null && bdVar.sC() != null && bdVar.sC().aaY == 2) {
            if (this.fiR == null) {
                this.fiR = new com.baidu.tieba.d.b(this.byz.getPageContext(), this.fiQ.aYg());
                this.fiR.iT(5000);
            }
            this.fiR.g(this.byz.getResources().getString(d.j.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void y(long j, int i) {
        if (this.fiQ != null && j > 0) {
            this.fiQ.l(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fiP != null) {
                this.fiP.AX();
            }
            if (this.fiQ != null) {
                this.fiQ.AX();
            }
            this.mSkinType = i;
        }
    }

    public void f(BdTypeListView bdTypeListView) {
        if (this.fiP != null) {
            bdTypeListView.removeHeaderView(this.fiP.mRootView);
        }
        if (this.fiQ != null) {
            bdTypeListView.removeHeaderView(this.fiQ.getRootView());
        }
    }

    public void onDestroy() {
        aYl();
    }

    public void aYl() {
        if (this.fiR != null) {
            this.fiR.adz();
        }
    }
}
