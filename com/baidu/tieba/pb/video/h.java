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
    private BaseActivity bBW;
    private d goq;
    private e gor;
    private com.baidu.tieba.c.d gos;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.bBW = baseActivity;
    }

    public void a(bh bhVar, bb bbVar, int i) {
        aq(bbVar);
        b(bhVar, bbVar, i);
    }

    private void aq(bb bbVar) {
        if (bbVar != null) {
            if (this.goq == null) {
                this.goq = new d(LayoutInflater.from(this.bBW.getPageContext().getPageActivity()).inflate(e.h.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.goq.an(bbVar);
        }
    }

    public View boE() {
        if (this.goq == null) {
            return null;
        }
        return this.goq.mRootView;
    }

    private void b(bh bhVar, bb bbVar, int i) {
        if (bhVar != null && bbVar != null) {
            if (this.gor == null) {
                this.gor = new e(this.bBW, LayoutInflater.from(this.bBW.getPageContext().getPageActivity()).inflate(e.h.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bhVar.awC = i;
            this.gor.ao(bbVar);
            bbVar.a(bhVar);
        }
    }

    public View boF() {
        if (this.gor == null) {
            return null;
        }
        return this.gor.getRootView();
    }

    public void ar(bb bbVar) {
        if (this.gor != null && bbVar != null && bbVar.AW() != null && bbVar.AW().awC == 2) {
            if (this.gos == null) {
                this.gos = new com.baidu.tieba.c.d(this.bBW.getPageContext(), this.gor.boB());
                this.gos.lj(UIMsg.m_AppUI.MSG_APP_GPS);
            }
            this.gos.h(this.bBW.getResources().getString(e.j.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void n(long j, int i) {
        if (this.gor != null && j > 0) {
            this.gor.o(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.goq != null) {
                this.goq.KD();
            }
            if (this.gor != null) {
                this.gor.KD();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.goq != null) {
            bdTypeListView.removeHeaderView(this.goq.mRootView);
        }
        if (this.gor != null) {
            bdTypeListView.removeHeaderView(this.gor.getRootView());
        }
    }

    public void onDestroy() {
        boG();
    }

    public void boG() {
        if (this.gos != null) {
            this.gos.asz();
        }
    }
}
