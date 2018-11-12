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
    private BaseActivity bxI;
    private d gdD;
    private e gdE;
    private com.baidu.tieba.c.d gdF;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.bxI = baseActivity;
    }

    public void a(bh bhVar, bb bbVar, int i) {
        aq(bbVar);
        b(bhVar, bbVar, i);
    }

    private void aq(bb bbVar) {
        if (bbVar != null) {
            if (this.gdD == null) {
                this.gdD = new d(LayoutInflater.from(this.bxI.getPageContext().getPageActivity()).inflate(e.h.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.gdD.an(bbVar);
        }
    }

    public View bls() {
        if (this.gdD == null) {
            return null;
        }
        return this.gdD.mRootView;
    }

    private void b(bh bhVar, bb bbVar, int i) {
        if (bhVar != null && bbVar != null) {
            if (this.gdE == null) {
                this.gdE = new e(this.bxI, LayoutInflater.from(this.bxI.getPageContext().getPageActivity()).inflate(e.h.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bhVar.asy = i;
            this.gdE.ao(bbVar);
            bbVar.a(bhVar);
        }
    }

    public View blt() {
        if (this.gdE == null) {
            return null;
        }
        return this.gdE.getRootView();
    }

    public void ar(bb bbVar) {
        if (this.gdE != null && bbVar != null && bbVar.zF() != null && bbVar.zF().asy == 2) {
            if (this.gdF == null) {
                this.gdF = new com.baidu.tieba.c.d(this.bxI.getPageContext(), this.gdE.blp());
                this.gdF.kF(UIMsg.m_AppUI.MSG_APP_GPS);
            }
            this.gdF.h(this.bxI.getResources().getString(e.j.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void n(long j, int i) {
        if (this.gdE != null && j > 0) {
            this.gdE.l(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gdD != null) {
                this.gdD.Jj();
            }
            if (this.gdE != null) {
                this.gdE.Jj();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.gdD != null) {
            bdTypeListView.removeHeaderView(this.gdD.mRootView);
        }
        if (this.gdE != null) {
            bdTypeListView.removeHeaderView(this.gdE.getRootView());
        }
    }

    public void onDestroy() {
        blu();
    }

    public void blu() {
        if (this.gdF != null) {
            this.gdF.apA();
        }
    }
}
