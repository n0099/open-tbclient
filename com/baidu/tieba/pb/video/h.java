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
    private BaseActivity byF;
    private d fjS;
    private e fjT;
    private com.baidu.tieba.d.b fjU;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.byF = baseActivity;
    }

    public void a(bj bjVar, bd bdVar, int i) {
        ad(bdVar);
        b(bjVar, bdVar, i);
    }

    private void ad(bd bdVar) {
        if (bdVar != null) {
            if (this.fjS == null) {
                this.fjS = new d(LayoutInflater.from(this.byF.getPageContext().getPageActivity()).inflate(d.h.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.fjS.aa(bdVar);
        }
    }

    public View aYr() {
        if (this.fjS == null) {
            return null;
        }
        return this.fjS.mRootView;
    }

    private void b(bj bjVar, bd bdVar, int i) {
        if (bjVar != null && bdVar != null) {
            if (this.fjT == null) {
                this.fjT = new e(this.byF, LayoutInflater.from(this.byF.getPageContext().getPageActivity()).inflate(d.h.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bjVar.aaV = i;
            this.fjT.ab(bdVar);
            bdVar.a(bjVar);
        }
    }

    public View aYs() {
        if (this.fjT == null) {
            return null;
        }
        return this.fjT.getRootView();
    }

    public void ae(bd bdVar) {
        if (this.fjT != null && bdVar != null && bdVar.sA() != null && bdVar.sA().aaV == 2) {
            if (this.fjU == null) {
                this.fjU = new com.baidu.tieba.d.b(this.byF.getPageContext(), this.fjT.aYo());
                this.fjU.iV(5000);
            }
            this.fjU.g(this.byF.getResources().getString(d.j.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void y(long j, int i) {
        if (this.fjT != null && j > 0) {
            this.fjT.l(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fjS != null) {
                this.fjS.AY();
            }
            if (this.fjT != null) {
                this.fjT.AY();
            }
            this.mSkinType = i;
        }
    }

    public void f(BdTypeListView bdTypeListView) {
        if (this.fjS != null) {
            bdTypeListView.removeHeaderView(this.fjS.mRootView);
        }
        if (this.fjT != null) {
            bdTypeListView.removeHeaderView(this.fjT.getRootView());
        }
    }

    public void onDestroy() {
        aYt();
    }

    public void aYt() {
        if (this.fjU != null) {
            this.fjU.adI();
        }
    }
}
