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
    private BaseActivity cWM;
    private e icA;
    private com.baidu.tieba.c.d icB;
    private d icz;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.cWM = baseActivity;
    }

    public void a(bm bmVar, bg bgVar, int i) {
        az(bgVar);
        b(bmVar, bgVar, i);
    }

    private void az(bg bgVar) {
        if (bgVar != null) {
            if (this.icz == null) {
                this.icz = new d(LayoutInflater.from(this.cWM.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.icz.aw(bgVar);
        }
    }

    public View bZK() {
        if (this.icz == null) {
            return null;
        }
        return this.icz.mRootView;
    }

    private void b(bm bmVar, bg bgVar, int i) {
        if (bmVar != null && bgVar != null) {
            if (this.icA == null) {
                this.icA = new e(this.cWM, LayoutInflater.from(this.cWM.getPageContext().getPageActivity()).inflate(R.layout.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bmVar.bMG = i;
            this.icA.ax(bgVar);
            bgVar.a(bmVar);
        }
    }

    public View bZL() {
        if (this.icA == null) {
            return null;
        }
        return this.icA.getRootView();
    }

    public void aA(bg bgVar) {
        if (this.icA != null && bgVar != null && bgVar.afH() != null && bgVar.afH().bMG == 2) {
            if (this.icB == null) {
                this.icB = new com.baidu.tieba.c.d(this.cWM.getPageContext(), this.icA.bZH());
                this.icB.qc(UIMsg.m_AppUI.MSG_APP_GPS);
            }
            this.icB.u(this.cWM.getResources().getString(R.string.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void q(long j, int i) {
        if (this.icA != null && j > 0) {
            this.icA.w(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.icz != null) {
                this.icz.aqe();
            }
            if (this.icA != null) {
                this.icA.aqe();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.icz != null) {
            bdTypeListView.removeHeaderView(this.icz.mRootView);
        }
        if (this.icA != null) {
            bdTypeListView.removeHeaderView(this.icA.getRootView());
        }
    }

    public void onDestroy() {
        bZM();
    }

    public void bZM() {
        if (this.icB != null) {
            this.icB.bbz();
        }
    }
}
