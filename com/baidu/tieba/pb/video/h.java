package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class h {
    private BaseActivity cVq;
    private d hWm;
    private e hWn;
    private com.baidu.tieba.c.d hWo;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.cVq = baseActivity;
    }

    public void a(bm bmVar, bg bgVar, int i) {
        az(bgVar);
        b(bmVar, bgVar, i);
    }

    private void az(bg bgVar) {
        if (bgVar != null) {
            if (this.hWm == null) {
                this.hWm = new d(LayoutInflater.from(this.cVq.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.hWm.aw(bgVar);
        }
    }

    public View bWV() {
        if (this.hWm == null) {
            return null;
        }
        return this.hWm.mRootView;
    }

    private void b(bm bmVar, bg bgVar, int i) {
        if (bmVar != null && bgVar != null) {
            if (this.hWn == null) {
                this.hWn = new e(this.cVq, LayoutInflater.from(this.cVq.getPageContext().getPageActivity()).inflate(R.layout.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bmVar.bLG = i;
            this.hWn.ax(bgVar);
            bgVar.a(bmVar);
        }
    }

    public View bWW() {
        if (this.hWn == null) {
            return null;
        }
        return this.hWn.getRootView();
    }

    public void aA(bg bgVar) {
        if (this.hWn != null && bgVar != null && bgVar.aeF() != null && bgVar.aeF().bLG == 2) {
            if (this.hWo == null) {
                this.hWo = new com.baidu.tieba.c.d(this.cVq.getPageContext(), this.hWn.bWS());
                this.hWo.pL(UIMsg.m_AppUI.MSG_APP_GPS);
            }
            this.hWo.u(this.cVq.getResources().getString(R.string.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void q(long j, int i) {
        if (this.hWn != null && j > 0) {
            this.hWn.w(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.hWm != null) {
                this.hWm.aoY();
            }
            if (this.hWn != null) {
                this.hWn.aoY();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.hWm != null) {
            bdTypeListView.removeHeaderView(this.hWm.mRootView);
        }
        if (this.hWn != null) {
            bdTypeListView.removeHeaderView(this.hWn.getRootView());
        }
    }

    public void onDestroy() {
        bWX();
    }

    public void bWX() {
        if (this.hWo != null) {
            this.hWo.aZA();
        }
    }
}
