package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class h {
    private BaseActivity bsQ;
    private d fUF;
    private e fUG;
    private com.baidu.tieba.c.d fUH;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.bsQ = baseActivity;
    }

    public void a(bh bhVar, bb bbVar, int i) {
        aq(bbVar);
        b(bhVar, bbVar, i);
    }

    private void aq(bb bbVar) {
        if (bbVar != null) {
            if (this.fUF == null) {
                this.fUF = new d(LayoutInflater.from(this.bsQ.getPageContext().getPageActivity()).inflate(e.h.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.fUF.an(bbVar);
        }
    }

    public View biK() {
        if (this.fUF == null) {
            return null;
        }
        return this.fUF.mRootView;
    }

    private void b(bh bhVar, bb bbVar, int i) {
        if (bhVar != null && bbVar != null) {
            if (this.fUG == null) {
                this.fUG = new e(this.bsQ, LayoutInflater.from(this.bsQ.getPageContext().getPageActivity()).inflate(e.h.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bhVar.amQ = i;
            this.fUG.ao(bbVar);
            bbVar.a(bhVar);
        }
    }

    public View biL() {
        if (this.fUG == null) {
            return null;
        }
        return this.fUG.getRootView();
    }

    public void ar(bb bbVar) {
        if (this.fUG != null && bbVar != null && bbVar.xp() != null && bbVar.xp().amQ == 2) {
            if (this.fUH == null) {
                this.fUH = new com.baidu.tieba.c.d(this.bsQ.getPageContext(), this.fUG.biH());
                this.fUH.jO(5000);
            }
            this.fUH.g(this.bsQ.getResources().getString(e.j.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void n(long j, int i) {
        if (this.fUG != null && j > 0) {
            this.fUG.l(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fUF != null) {
                this.fUF.GW();
            }
            if (this.fUG != null) {
                this.fUG.GW();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.fUF != null) {
            bdTypeListView.removeHeaderView(this.fUF.mRootView);
        }
        if (this.fUG != null) {
            bdTypeListView.removeHeaderView(this.fUG.getRootView());
        }
    }

    public void onDestroy() {
        biM();
    }

    public void biM() {
        if (this.fUH != null) {
            this.fUH.amz();
        }
    }
}
