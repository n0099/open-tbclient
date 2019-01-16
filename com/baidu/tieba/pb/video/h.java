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
    private BaseActivity bBV;
    private d gop;
    private e goq;
    private com.baidu.tieba.c.d gor;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.bBV = baseActivity;
    }

    public void a(bh bhVar, bb bbVar, int i) {
        aq(bbVar);
        b(bhVar, bbVar, i);
    }

    private void aq(bb bbVar) {
        if (bbVar != null) {
            if (this.gop == null) {
                this.gop = new d(LayoutInflater.from(this.bBV.getPageContext().getPageActivity()).inflate(e.h.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.gop.an(bbVar);
        }
    }

    public View boE() {
        if (this.gop == null) {
            return null;
        }
        return this.gop.mRootView;
    }

    private void b(bh bhVar, bb bbVar, int i) {
        if (bhVar != null && bbVar != null) {
            if (this.goq == null) {
                this.goq = new e(this.bBV, LayoutInflater.from(this.bBV.getPageContext().getPageActivity()).inflate(e.h.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bhVar.awB = i;
            this.goq.ao(bbVar);
            bbVar.a(bhVar);
        }
    }

    public View boF() {
        if (this.goq == null) {
            return null;
        }
        return this.goq.getRootView();
    }

    public void ar(bb bbVar) {
        if (this.goq != null && bbVar != null && bbVar.AW() != null && bbVar.AW().awB == 2) {
            if (this.gor == null) {
                this.gor = new com.baidu.tieba.c.d(this.bBV.getPageContext(), this.goq.boB());
                this.gor.lj(UIMsg.m_AppUI.MSG_APP_GPS);
            }
            this.gor.h(this.bBV.getResources().getString(e.j.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void n(long j, int i) {
        if (this.goq != null && j > 0) {
            this.goq.o(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gop != null) {
                this.gop.KD();
            }
            if (this.goq != null) {
                this.goq.KD();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.gop != null) {
            bdTypeListView.removeHeaderView(this.gop.mRootView);
        }
        if (this.goq != null) {
            bdTypeListView.removeHeaderView(this.goq.getRootView());
        }
    }

    public void onDestroy() {
        boG();
    }

    public void boG() {
        if (this.gor != null) {
            this.gor.asz();
        }
    }
}
