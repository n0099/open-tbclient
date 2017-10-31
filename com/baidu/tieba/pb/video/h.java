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
    private BaseActivity brJ;
    private d fbA;
    private e fbB;
    private com.baidu.tieba.d.a fbC;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.brJ = baseActivity;
    }

    public void a(bm bmVar, bh bhVar, int i) {
        aa(bhVar);
        b(bmVar, bhVar, i);
    }

    private void aa(bh bhVar) {
        if (bhVar != null) {
            if (this.fbA == null) {
                this.fbA = new d(LayoutInflater.from(this.brJ.getPageContext().getPageActivity()).inflate(d.h.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.fbA.X(bhVar);
        }
    }

    public View aXc() {
        if (this.fbA == null) {
            return null;
        }
        return this.fbA.mRootView;
    }

    private void b(bm bmVar, bh bhVar, int i) {
        if (bmVar != null && bhVar != null) {
            if (this.fbB == null) {
                this.fbB = new e(this.brJ, LayoutInflater.from(this.brJ.getPageContext().getPageActivity()).inflate(d.h.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bmVar.aaD = i;
            this.fbB.Y(bhVar);
            bhVar.a(bmVar);
        }
    }

    public View aXd() {
        if (this.fbB == null) {
            return null;
        }
        return this.fbB.getRootView();
    }

    public void ab(bh bhVar) {
        if (this.fbB != null && bhVar != null && bhVar.sz() != null && bhVar.sz().aaD == 2) {
            if (this.fbC == null) {
                this.fbC = new com.baidu.tieba.d.a(this.brJ.getPageContext(), this.fbB.aWZ());
                this.fbC.ix(5000);
            }
            this.fbC.g(this.brJ.getResources().getString(d.j.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void y(long j, int i) {
        if (this.fbB != null && j > 0) {
            this.fbB.l(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fbA != null) {
                this.fbA.AB();
            }
            if (this.fbB != null) {
                this.fbB.AB();
            }
            this.mSkinType = i;
        }
    }

    public void f(BdTypeListView bdTypeListView) {
        if (this.fbA != null) {
            bdTypeListView.removeHeaderView(this.fbA.mRootView);
        }
        if (this.fbB != null) {
            bdTypeListView.removeHeaderView(this.fbB.getRootView());
        }
    }

    public void onDestroy() {
        aXe();
    }

    public void aXe() {
        if (this.fbC != null) {
            this.fbC.abE();
        }
    }
}
