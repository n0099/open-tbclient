package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class h {
    private BaseActivity cWT;
    private e idA;
    private com.baidu.tieba.c.d idB;
    private d idz;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.cWT = baseActivity;
    }

    public void a(bn bnVar, bh bhVar, int i) {
        aA(bhVar);
        b(bnVar, bhVar, i);
    }

    private void aA(bh bhVar) {
        if (bhVar != null) {
            if (this.idz == null) {
                this.idz = new d(LayoutInflater.from(this.cWT.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.idz.ax(bhVar);
        }
    }

    public View cab() {
        if (this.idz == null) {
            return null;
        }
        return this.idz.mRootView;
    }

    private void b(bn bnVar, bh bhVar, int i) {
        if (bnVar != null && bhVar != null) {
            if (this.idA == null) {
                this.idA = new e(this.cWT, LayoutInflater.from(this.cWT.getPageContext().getPageActivity()).inflate(R.layout.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bnVar.bML = i;
            this.idA.ay(bhVar);
            bhVar.a(bnVar);
        }
    }

    public View cac() {
        if (this.idA == null) {
            return null;
        }
        return this.idA.getRootView();
    }

    public void aB(bh bhVar) {
        if (this.idA != null && bhVar != null && bhVar.afI() != null && bhVar.afI().bML == 2) {
            if (this.idB == null) {
                this.idB = new com.baidu.tieba.c.d(this.cWT.getPageContext(), this.idA.bZY());
                this.idB.qd(UIMsg.m_AppUI.MSG_APP_GPS);
            }
            this.idB.u(this.cWT.getResources().getString(R.string.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void q(long j, int i) {
        if (this.idA != null && j > 0) {
            this.idA.w(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.idz != null) {
                this.idz.aqg();
            }
            if (this.idA != null) {
                this.idA.aqg();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.idz != null) {
            bdTypeListView.removeHeaderView(this.idz.mRootView);
        }
        if (this.idA != null) {
            bdTypeListView.removeHeaderView(this.idA.getRootView());
        }
    }

    public void onDestroy() {
        cad();
    }

    public void cad() {
        if (this.idB != null) {
            this.idB.bbB();
        }
    }
}
