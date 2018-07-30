package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class h {
    private BaseActivity bmZ;
    private d fMS;
    private e fMT;
    private com.baidu.tieba.c.d fMU;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.bmZ = baseActivity;
    }

    public void a(bh bhVar, bb bbVar, int i) {
        ap(bbVar);
        b(bhVar, bbVar, i);
    }

    private void ap(bb bbVar) {
        if (bbVar != null) {
            if (this.fMS == null) {
                this.fMS = new d(LayoutInflater.from(this.bmZ.getPageContext().getPageActivity()).inflate(d.h.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.fMS.am(bbVar);
        }
    }

    public View bgm() {
        if (this.fMS == null) {
            return null;
        }
        return this.fMS.mRootView;
    }

    private void b(bh bhVar, bb bbVar, int i) {
        if (bhVar != null && bbVar != null) {
            if (this.fMT == null) {
                this.fMT = new e(this.bmZ, LayoutInflater.from(this.bmZ.getPageContext().getPageActivity()).inflate(d.h.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bhVar.akk = i;
            this.fMT.an(bbVar);
            bbVar.a(bhVar);
        }
    }

    public View bgn() {
        if (this.fMT == null) {
            return null;
        }
        return this.fMT.getRootView();
    }

    public void aq(bb bbVar) {
        if (this.fMT != null && bbVar != null && bbVar.wl() != null && bbVar.wl().akk == 2) {
            if (this.fMU == null) {
                this.fMU = new com.baidu.tieba.c.d(this.bmZ.getPageContext(), this.fMT.bgj());
                this.fMU.jq(5000);
            }
            this.fMU.g(this.bmZ.getResources().getString(d.j.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void k(long j, int i) {
        if (this.fMT != null && j > 0) {
            this.fMT.l(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fMS != null) {
                this.fMS.FG();
            }
            if (this.fMT != null) {
                this.fMT.FG();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.fMS != null) {
            bdTypeListView.removeHeaderView(this.fMS.mRootView);
        }
        if (this.fMT != null) {
            bdTypeListView.removeHeaderView(this.fMT.getRootView());
        }
    }

    public void onDestroy() {
        bgo();
    }

    public void bgo() {
        if (this.fMU != null) {
            this.fMU.akM();
        }
    }
}
