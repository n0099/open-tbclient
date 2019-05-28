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
    private BaseActivity cVp;
    private d hWl;
    private e hWm;
    private com.baidu.tieba.c.d hWn;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.cVp = baseActivity;
    }

    public void a(bm bmVar, bg bgVar, int i) {
        az(bgVar);
        b(bmVar, bgVar, i);
    }

    private void az(bg bgVar) {
        if (bgVar != null) {
            if (this.hWl == null) {
                this.hWl = new d(LayoutInflater.from(this.cVp.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.hWl.aw(bgVar);
        }
    }

    public View bWU() {
        if (this.hWl == null) {
            return null;
        }
        return this.hWl.mRootView;
    }

    private void b(bm bmVar, bg bgVar, int i) {
        if (bmVar != null && bgVar != null) {
            if (this.hWm == null) {
                this.hWm = new e(this.cVp, LayoutInflater.from(this.cVp.getPageContext().getPageActivity()).inflate(R.layout.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bmVar.bLF = i;
            this.hWm.ax(bgVar);
            bgVar.a(bmVar);
        }
    }

    public View bWV() {
        if (this.hWm == null) {
            return null;
        }
        return this.hWm.getRootView();
    }

    public void aA(bg bgVar) {
        if (this.hWm != null && bgVar != null && bgVar.aeF() != null && bgVar.aeF().bLF == 2) {
            if (this.hWn == null) {
                this.hWn = new com.baidu.tieba.c.d(this.cVp.getPageContext(), this.hWm.bWR());
                this.hWn.pL(UIMsg.m_AppUI.MSG_APP_GPS);
            }
            this.hWn.u(this.cVp.getResources().getString(R.string.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void q(long j, int i) {
        if (this.hWm != null && j > 0) {
            this.hWm.w(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.hWl != null) {
                this.hWl.aoY();
            }
            if (this.hWm != null) {
                this.hWm.aoY();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.hWl != null) {
            bdTypeListView.removeHeaderView(this.hWl.mRootView);
        }
        if (this.hWm != null) {
            bdTypeListView.removeHeaderView(this.hWm.getRootView());
        }
    }

    public void onDestroy() {
        bWW();
    }

    public void bWW() {
        if (this.hWn != null) {
            this.hWn.aZA();
        }
    }
}
