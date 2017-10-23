package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class h {
    private BaseActivity boA;
    private d eSU;
    private e eSV;
    private com.baidu.tieba.d.a eSW;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.boA = baseActivity;
    }

    public void a(bm bmVar, bh bhVar, int i) {
        aa(bhVar);
        b(bmVar, bhVar, i);
    }

    private void aa(bh bhVar) {
        if (bhVar != null) {
            if (this.eSU == null) {
                this.eSU = new d(LayoutInflater.from(this.boA.getPageContext().getPageActivity()).inflate(d.j.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.eSU.X(bhVar);
        }
    }

    public View aUa() {
        if (this.eSU == null) {
            return null;
        }
        return this.eSU.mRootView;
    }

    private void b(bm bmVar, bh bhVar, int i) {
        if (bmVar != null && bhVar != null) {
            if (this.eSV == null) {
                this.eSV = new e(this.boA, LayoutInflater.from(this.boA.getPageContext().getPageActivity()).inflate(d.j.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bmVar.aag = i;
            this.eSV.Y(bhVar);
            bhVar.a(bmVar);
        }
    }

    public View aUb() {
        if (this.eSV == null) {
            return null;
        }
        return this.eSV.getRootView();
    }

    public void ab(bh bhVar) {
        if (this.eSV != null && bhVar != null && bhVar.ss() != null && bhVar.ss().aag == 2) {
            if (this.eSW == null) {
                this.eSW = new com.baidu.tieba.d.a(this.boA.getPageContext(), this.eSV.aTX());
                this.eSW.ie(5000);
            }
            this.eSW.g(this.boA.getResources().getString(d.l.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void w(long j, int i) {
        if (this.eSV != null && j > 0) {
            this.eSV.k(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.eSU != null) {
                this.eSU.As();
            }
            if (this.eSV != null) {
                this.eSV.As();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.eSU != null) {
            bdTypeListView.removeHeaderView(this.eSU.mRootView);
        }
        if (this.eSV != null) {
            bdTypeListView.removeHeaderView(this.eSV.getRootView());
        }
    }

    public void onDestroy() {
        aUc();
    }

    public void aUc() {
        if (this.eSW != null) {
            this.eSW.Zv();
        }
    }
}
