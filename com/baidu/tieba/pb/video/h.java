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
    private BaseActivity cNc;
    private d hEh;
    private e hEi;
    private com.baidu.tieba.c.d hEj;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.cNc = baseActivity;
    }

    public void a(bm bmVar, bg bgVar, int i) {
        aB(bgVar);
        b(bmVar, bgVar, i);
    }

    private void aB(bg bgVar) {
        if (bgVar != null) {
            if (this.hEh == null) {
                this.hEh = new d(LayoutInflater.from(this.cNc.getPageContext().getPageActivity()).inflate(d.h.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.hEh.ay(bgVar);
        }
    }

    public View bOY() {
        if (this.hEh == null) {
            return null;
        }
        return this.hEh.mRootView;
    }

    private void b(bm bmVar, bg bgVar, int i) {
        if (bmVar != null && bgVar != null) {
            if (this.hEi == null) {
                this.hEi = new e(this.cNc, LayoutInflater.from(this.cNc.getPageContext().getPageActivity()).inflate(d.h.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bmVar.bEl = i;
            this.hEi.az(bgVar);
            bgVar.a(bmVar);
        }
    }

    public View bOZ() {
        if (this.hEi == null) {
            return null;
        }
        return this.hEi.getRootView();
    }

    public void aC(bg bgVar) {
        if (this.hEi != null && bgVar != null && bgVar.ZY() != null && bgVar.ZY().bEl == 2) {
            if (this.hEj == null) {
                this.hEj = new com.baidu.tieba.c.d(this.cNc.getPageContext(), this.hEi.bOV());
                this.hEj.oH(UIMsg.m_AppUI.MSG_APP_GPS);
            }
            this.hEj.s(this.cNc.getResources().getString(d.j.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void s(long j, int i) {
        if (this.hEi != null && j > 0) {
            this.hEi.o(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.hEh != null) {
                this.hEh.ajX();
            }
            if (this.hEi != null) {
                this.hEi.ajX();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.hEh != null) {
            bdTypeListView.removeHeaderView(this.hEh.mRootView);
        }
        if (this.hEi != null) {
            bdTypeListView.removeHeaderView(this.hEi.getRootView());
        }
    }

    public void onDestroy() {
        bPa();
    }

    public void bPa() {
        if (this.hEj != null) {
            this.hEj.aSp();
        }
    }
}
