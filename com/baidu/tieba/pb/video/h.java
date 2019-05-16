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
    private BaseActivity cVo;
    private d hWi;
    private e hWj;
    private com.baidu.tieba.c.d hWk;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.cVo = baseActivity;
    }

    public void a(bm bmVar, bg bgVar, int i) {
        az(bgVar);
        b(bmVar, bgVar, i);
    }

    private void az(bg bgVar) {
        if (bgVar != null) {
            if (this.hWi == null) {
                this.hWi = new d(LayoutInflater.from(this.cVo.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.hWi.aw(bgVar);
        }
    }

    public View bWR() {
        if (this.hWi == null) {
            return null;
        }
        return this.hWi.mRootView;
    }

    private void b(bm bmVar, bg bgVar, int i) {
        if (bmVar != null && bgVar != null) {
            if (this.hWj == null) {
                this.hWj = new e(this.cVo, LayoutInflater.from(this.cVo.getPageContext().getPageActivity()).inflate(R.layout.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bmVar.bLF = i;
            this.hWj.ax(bgVar);
            bgVar.a(bmVar);
        }
    }

    public View bWS() {
        if (this.hWj == null) {
            return null;
        }
        return this.hWj.getRootView();
    }

    public void aA(bg bgVar) {
        if (this.hWj != null && bgVar != null && bgVar.aeF() != null && bgVar.aeF().bLF == 2) {
            if (this.hWk == null) {
                this.hWk = new com.baidu.tieba.c.d(this.cVo.getPageContext(), this.hWj.bWO());
                this.hWk.pL(UIMsg.m_AppUI.MSG_APP_GPS);
            }
            this.hWk.u(this.cVo.getResources().getString(R.string.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void q(long j, int i) {
        if (this.hWj != null && j > 0) {
            this.hWj.w(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.hWi != null) {
                this.hWi.aoY();
            }
            if (this.hWj != null) {
                this.hWj.aoY();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.hWi != null) {
            bdTypeListView.removeHeaderView(this.hWi.mRootView);
        }
        if (this.hWj != null) {
            bdTypeListView.removeHeaderView(this.hWj.getRootView());
        }
    }

    public void onDestroy() {
        bWT();
    }

    public void bWT() {
        if (this.hWk != null) {
            this.hWk.aZx();
        }
    }
}
