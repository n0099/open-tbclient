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
    private BaseActivity brT;
    private d fbV;
    private e fbW;
    private com.baidu.tieba.d.a fbX;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.brT = baseActivity;
    }

    public void a(bm bmVar, bh bhVar, int i) {
        aa(bhVar);
        b(bmVar, bhVar, i);
    }

    private void aa(bh bhVar) {
        if (bhVar != null) {
            if (this.fbV == null) {
                this.fbV = new d(LayoutInflater.from(this.brT.getPageContext().getPageActivity()).inflate(d.h.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.fbV.X(bhVar);
        }
    }

    public View aXk() {
        if (this.fbV == null) {
            return null;
        }
        return this.fbV.mRootView;
    }

    private void b(bm bmVar, bh bhVar, int i) {
        if (bmVar != null && bhVar != null) {
            if (this.fbW == null) {
                this.fbW = new e(this.brT, LayoutInflater.from(this.brT.getPageContext().getPageActivity()).inflate(d.h.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bmVar.aaD = i;
            this.fbW.Y(bhVar);
            bhVar.a(bmVar);
        }
    }

    public View aXl() {
        if (this.fbW == null) {
            return null;
        }
        return this.fbW.getRootView();
    }

    public void ab(bh bhVar) {
        if (this.fbW != null && bhVar != null && bhVar.sz() != null && bhVar.sz().aaD == 2) {
            if (this.fbX == null) {
                this.fbX = new com.baidu.tieba.d.a(this.brT.getPageContext(), this.fbW.aXh());
                this.fbX.iv(5000);
            }
            this.fbX.g(this.brT.getResources().getString(d.j.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void y(long j, int i) {
        if (this.fbW != null && j > 0) {
            this.fbW.l(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fbV != null) {
                this.fbV.AN();
            }
            if (this.fbW != null) {
                this.fbW.AN();
            }
            this.mSkinType = i;
        }
    }

    public void f(BdTypeListView bdTypeListView) {
        if (this.fbV != null) {
            bdTypeListView.removeHeaderView(this.fbV.mRootView);
        }
        if (this.fbW != null) {
            bdTypeListView.removeHeaderView(this.fbW.getRootView());
        }
    }

    public void onDestroy() {
        aXm();
    }

    public void aXm() {
        if (this.fbX != null) {
            this.fbX.abQ();
        }
    }
}
