package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class h {
    private BaseActivity cNa;
    private d hEv;
    private e hEw;
    private com.baidu.tieba.c.d hEx;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.cNa = baseActivity;
    }

    public void a(bm bmVar, bg bgVar, int i) {
        aC(bgVar);
        b(bmVar, bgVar, i);
    }

    private void aC(bg bgVar) {
        if (bgVar != null) {
            if (this.hEv == null) {
                this.hEv = new d(LayoutInflater.from(this.cNa.getPageContext().getPageActivity()).inflate(d.h.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.hEv.az(bgVar);
        }
    }

    public View bPb() {
        if (this.hEv == null) {
            return null;
        }
        return this.hEv.mRootView;
    }

    private void b(bm bmVar, bg bgVar, int i) {
        if (bmVar != null && bgVar != null) {
            if (this.hEw == null) {
                this.hEw = new e(this.cNa, LayoutInflater.from(this.cNa.getPageContext().getPageActivity()).inflate(d.h.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bmVar.bEi = i;
            this.hEw.aA(bgVar);
            bgVar.a(bmVar);
        }
    }

    public View bPc() {
        if (this.hEw == null) {
            return null;
        }
        return this.hEw.getRootView();
    }

    public void aD(bg bgVar) {
        if (this.hEw != null && bgVar != null && bgVar.aab() != null && bgVar.aab().bEi == 2) {
            if (this.hEx == null) {
                this.hEx = new com.baidu.tieba.c.d(this.cNa.getPageContext(), this.hEw.bOY());
                this.hEx.oL(UIMsg.m_AppUI.MSG_APP_GPS);
            }
            this.hEx.s(this.cNa.getResources().getString(d.j.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void s(long j, int i) {
        if (this.hEw != null && j > 0) {
            this.hEw.o(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.hEv != null) {
                this.hEv.aka();
            }
            if (this.hEw != null) {
                this.hEw.aka();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.hEv != null) {
            bdTypeListView.removeHeaderView(this.hEv.mRootView);
        }
        if (this.hEw != null) {
            bdTypeListView.removeHeaderView(this.hEw.getRootView());
        }
    }

    public void onDestroy() {
        bPd();
    }

    public void bPd() {
        if (this.hEx != null) {
            this.hEx.aSr();
        }
    }
}
