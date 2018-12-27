package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class h {
    private BaseActivity bBi;
    private d gnm;
    private e gnn;
    private com.baidu.tieba.c.d gno;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.bBi = baseActivity;
    }

    public void a(bh bhVar, bb bbVar, int i) {
        aq(bbVar);
        b(bhVar, bbVar, i);
    }

    private void aq(bb bbVar) {
        if (bbVar != null) {
            if (this.gnm == null) {
                this.gnm = new d(LayoutInflater.from(this.bBi.getPageContext().getPageActivity()).inflate(e.h.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.gnm.an(bbVar);
        }
    }

    public View bnW() {
        if (this.gnm == null) {
            return null;
        }
        return this.gnm.mRootView;
    }

    private void b(bh bhVar, bb bbVar, int i) {
        if (bhVar != null && bbVar != null) {
            if (this.gnn == null) {
                this.gnn = new e(this.bBi, LayoutInflater.from(this.bBi.getPageContext().getPageActivity()).inflate(e.h.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bhVar.avZ = i;
            this.gnn.ao(bbVar);
            bbVar.a(bhVar);
        }
    }

    public View bnX() {
        if (this.gnn == null) {
            return null;
        }
        return this.gnn.getRootView();
    }

    public void ar(bb bbVar) {
        if (this.gnn != null && bbVar != null && bbVar.AJ() != null && bbVar.AJ().avZ == 2) {
            if (this.gno == null) {
                this.gno = new com.baidu.tieba.c.d(this.bBi.getPageContext(), this.gnn.bnT());
                this.gno.li(UIMsg.m_AppUI.MSG_APP_GPS);
            }
            this.gno.h(this.bBi.getResources().getString(e.j.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void n(long j, int i) {
        if (this.gnn != null && j > 0) {
            this.gnn.o(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gnm != null) {
                this.gnm.Ko();
            }
            if (this.gnn != null) {
                this.gnn.Ko();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.gnm != null) {
            bdTypeListView.removeHeaderView(this.gnm.mRootView);
        }
        if (this.gnn != null) {
            bdTypeListView.removeHeaderView(this.gnn.getRootView());
        }
    }

    public void onDestroy() {
        bnY();
    }

    public void bnY() {
        if (this.gno != null) {
            this.gno.asb();
        }
    }
}
