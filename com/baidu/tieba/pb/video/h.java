package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class h {
    private BaseActivity bmt;
    private d fME;
    private e fMF;
    private com.baidu.tieba.c.d fMG;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.bmt = baseActivity;
    }

    public void a(bi biVar, bc bcVar, int i) {
        ao(bcVar);
        b(biVar, bcVar, i);
    }

    private void ao(bc bcVar) {
        if (bcVar != null) {
            if (this.fME == null) {
                this.fME = new d(LayoutInflater.from(this.bmt.getPageContext().getPageActivity()).inflate(d.i.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.fME.al(bcVar);
        }
    }

    public View bhT() {
        if (this.fME == null) {
            return null;
        }
        return this.fME.mRootView;
    }

    private void b(bi biVar, bc bcVar, int i) {
        if (biVar != null && bcVar != null) {
            if (this.fMF == null) {
                this.fMF = new e(this.bmt, LayoutInflater.from(this.bmt.getPageContext().getPageActivity()).inflate(d.i.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            biVar.akL = i;
            this.fMF.am(bcVar);
            bcVar.a(biVar);
        }
    }

    public View bhU() {
        if (this.fMF == null) {
            return null;
        }
        return this.fMF.getRootView();
    }

    public void ap(bc bcVar) {
        if (this.fMF != null && bcVar != null && bcVar.ww() != null && bcVar.ww().akL == 2) {
            if (this.fMG == null) {
                this.fMG = new com.baidu.tieba.c.d(this.bmt.getPageContext(), this.fMF.bhQ());
                this.fMG.je(5000);
            }
            this.fMG.h(this.bmt.getResources().getString(d.k.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void y(long j, int i) {
        if (this.fMF != null && j > 0) {
            this.fMF.l(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fME != null) {
                this.fME.FK();
            }
            if (this.fMF != null) {
                this.fMF.FK();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.fME != null) {
            bdTypeListView.removeHeaderView(this.fME.mRootView);
        }
        if (this.fMF != null) {
            bdTypeListView.removeHeaderView(this.fMF.getRootView());
        }
    }

    public void onDestroy() {
        bhV();
    }

    public void bhV() {
        if (this.fMG != null) {
            this.fMG.akn();
        }
    }
}
