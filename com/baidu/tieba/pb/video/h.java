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
    private BaseActivity cNd;
    private d hEi;
    private e hEj;
    private com.baidu.tieba.c.d hEk;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.cNd = baseActivity;
    }

    public void a(bm bmVar, bg bgVar, int i) {
        aB(bgVar);
        b(bmVar, bgVar, i);
    }

    private void aB(bg bgVar) {
        if (bgVar != null) {
            if (this.hEi == null) {
                this.hEi = new d(LayoutInflater.from(this.cNd.getPageContext().getPageActivity()).inflate(d.h.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.hEi.ay(bgVar);
        }
    }

    public View bOY() {
        if (this.hEi == null) {
            return null;
        }
        return this.hEi.mRootView;
    }

    private void b(bm bmVar, bg bgVar, int i) {
        if (bmVar != null && bgVar != null) {
            if (this.hEj == null) {
                this.hEj = new e(this.cNd, LayoutInflater.from(this.cNd.getPageContext().getPageActivity()).inflate(d.h.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bmVar.bEm = i;
            this.hEj.az(bgVar);
            bgVar.a(bmVar);
        }
    }

    public View bOZ() {
        if (this.hEj == null) {
            return null;
        }
        return this.hEj.getRootView();
    }

    public void aC(bg bgVar) {
        if (this.hEj != null && bgVar != null && bgVar.ZY() != null && bgVar.ZY().bEm == 2) {
            if (this.hEk == null) {
                this.hEk = new com.baidu.tieba.c.d(this.cNd.getPageContext(), this.hEj.bOV());
                this.hEk.oH(UIMsg.m_AppUI.MSG_APP_GPS);
            }
            this.hEk.s(this.cNd.getResources().getString(d.j.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void s(long j, int i) {
        if (this.hEj != null && j > 0) {
            this.hEj.o(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.hEi != null) {
                this.hEi.ajX();
            }
            if (this.hEj != null) {
                this.hEj.ajX();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.hEi != null) {
            bdTypeListView.removeHeaderView(this.hEi.mRootView);
        }
        if (this.hEj != null) {
            bdTypeListView.removeHeaderView(this.hEj.getRootView());
        }
    }

    public void onDestroy() {
        bPa();
    }

    public void bPa() {
        if (this.hEk != null) {
            this.hEk.aSp();
        }
    }
}
