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
    private BaseActivity byB;
    private d fjN;
    private e fjO;
    private com.baidu.tieba.d.b fjP;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.byB = baseActivity;
    }

    public void a(bj bjVar, bd bdVar, int i) {
        ad(bdVar);
        b(bjVar, bdVar, i);
    }

    private void ad(bd bdVar) {
        if (bdVar != null) {
            if (this.fjN == null) {
                this.fjN = new d(LayoutInflater.from(this.byB.getPageContext().getPageActivity()).inflate(d.h.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.fjN.aa(bdVar);
        }
    }

    public View aYr() {
        if (this.fjN == null) {
            return null;
        }
        return this.fjN.mRootView;
    }

    private void b(bj bjVar, bd bdVar, int i) {
        if (bjVar != null && bdVar != null) {
            if (this.fjO == null) {
                this.fjO = new e(this.byB, LayoutInflater.from(this.byB.getPageContext().getPageActivity()).inflate(d.h.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bjVar.aaS = i;
            this.fjO.ab(bdVar);
            bdVar.a(bjVar);
        }
    }

    public View aYs() {
        if (this.fjO == null) {
            return null;
        }
        return this.fjO.getRootView();
    }

    public void ae(bd bdVar) {
        if (this.fjO != null && bdVar != null && bdVar.sA() != null && bdVar.sA().aaS == 2) {
            if (this.fjP == null) {
                this.fjP = new com.baidu.tieba.d.b(this.byB.getPageContext(), this.fjO.aYo());
                this.fjP.iV(5000);
            }
            this.fjP.g(this.byB.getResources().getString(d.j.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void y(long j, int i) {
        if (this.fjO != null && j > 0) {
            this.fjO.l(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fjN != null) {
                this.fjN.AY();
            }
            if (this.fjO != null) {
                this.fjO.AY();
            }
            this.mSkinType = i;
        }
    }

    public void f(BdTypeListView bdTypeListView) {
        if (this.fjN != null) {
            bdTypeListView.removeHeaderView(this.fjN.mRootView);
        }
        if (this.fjO != null) {
            bdTypeListView.removeHeaderView(this.fjO.getRootView());
        }
    }

    public void onDestroy() {
        aYt();
    }

    public void aYt() {
        if (this.fjP != null) {
            this.fjP.adJ();
        }
    }
}
