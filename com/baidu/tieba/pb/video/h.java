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
    private BaseActivity bBf;
    private d gkv;
    private e gkw;
    private com.baidu.tieba.c.d gkx;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.bBf = baseActivity;
    }

    public void a(bh bhVar, bb bbVar, int i) {
        aq(bbVar);
        b(bhVar, bbVar, i);
    }

    private void aq(bb bbVar) {
        if (bbVar != null) {
            if (this.gkv == null) {
                this.gkv = new d(LayoutInflater.from(this.bBf.getPageContext().getPageActivity()).inflate(e.h.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.gkv.an(bbVar);
        }
    }

    public View bnl() {
        if (this.gkv == null) {
            return null;
        }
        return this.gkv.mRootView;
    }

    private void b(bh bhVar, bb bbVar, int i) {
        if (bhVar != null && bbVar != null) {
            if (this.gkw == null) {
                this.gkw = new e(this.bBf, LayoutInflater.from(this.bBf.getPageContext().getPageActivity()).inflate(e.h.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bhVar.avY = i;
            this.gkw.ao(bbVar);
            bbVar.a(bhVar);
        }
    }

    public View bnm() {
        if (this.gkw == null) {
            return null;
        }
        return this.gkw.getRootView();
    }

    public void ar(bb bbVar) {
        if (this.gkw != null && bbVar != null && bbVar.AJ() != null && bbVar.AJ().avY == 2) {
            if (this.gkx == null) {
                this.gkx = new com.baidu.tieba.c.d(this.bBf.getPageContext(), this.gkw.bni());
                this.gkx.kV(UIMsg.m_AppUI.MSG_APP_GPS);
            }
            this.gkx.h(this.bBf.getResources().getString(e.j.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void n(long j, int i) {
        if (this.gkw != null && j > 0) {
            this.gkw.o(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gkv != null) {
                this.gkv.Kn();
            }
            if (this.gkw != null) {
                this.gkw.Kn();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.gkv != null) {
            bdTypeListView.removeHeaderView(this.gkv.mRootView);
        }
        if (this.gkw != null) {
            bdTypeListView.removeHeaderView(this.gkw.getRootView());
        }
    }

    public void onDestroy() {
        bnn();
    }

    public void bnn() {
        if (this.gkx != null) {
            this.gkx.arm();
        }
    }
}
