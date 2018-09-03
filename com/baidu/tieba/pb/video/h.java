package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class h {
    private BaseActivity bnc;
    private d fML;
    private e fMM;
    private com.baidu.tieba.c.d fMN;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.bnc = baseActivity;
    }

    public void a(bh bhVar, bb bbVar, int i) {
        ap(bbVar);
        b(bhVar, bbVar, i);
    }

    private void ap(bb bbVar) {
        if (bbVar != null) {
            if (this.fML == null) {
                this.fML = new d(LayoutInflater.from(this.bnc.getPageContext().getPageActivity()).inflate(f.h.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.fML.am(bbVar);
        }
    }

    public View bgh() {
        if (this.fML == null) {
            return null;
        }
        return this.fML.mRootView;
    }

    private void b(bh bhVar, bb bbVar, int i) {
        if (bhVar != null && bbVar != null) {
            if (this.fMM == null) {
                this.fMM = new e(this.bnc, LayoutInflater.from(this.bnc.getPageContext().getPageActivity()).inflate(f.h.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bhVar.akk = i;
            this.fMM.an(bbVar);
            bbVar.a(bhVar);
        }
    }

    public View bgi() {
        if (this.fMM == null) {
            return null;
        }
        return this.fMM.getRootView();
    }

    public void aq(bb bbVar) {
        if (this.fMM != null && bbVar != null && bbVar.wk() != null && bbVar.wk().akk == 2) {
            if (this.fMN == null) {
                this.fMN = new com.baidu.tieba.c.d(this.bnc.getPageContext(), this.fMM.bge());
                this.fMN.jp(5000);
            }
            this.fMN.g(this.bnc.getResources().getString(f.j.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void k(long j, int i) {
        if (this.fMM != null && j > 0) {
            this.fMM.l(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fML != null) {
                this.fML.FG();
            }
            if (this.fMM != null) {
                this.fMM.FG();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.fML != null) {
            bdTypeListView.removeHeaderView(this.fML.mRootView);
        }
        if (this.fMM != null) {
            bdTypeListView.removeHeaderView(this.fMM.getRootView());
        }
    }

    public void onDestroy() {
        bgj();
    }

    public void bgj() {
        if (this.fMN != null) {
            this.fMN.akO();
        }
    }
}
