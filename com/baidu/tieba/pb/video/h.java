package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class h {
    private BaseActivity cmR;
    private d fYp;
    private e fYq;
    private com.baidu.tieba.d.b fYr;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.cmR = baseActivity;
    }

    public void a(bj bjVar, bd bdVar, int i) {
        ac(bdVar);
        b(bjVar, bdVar, i);
    }

    private void ac(bd bdVar) {
        if (bdVar != null) {
            if (this.fYp == null) {
                this.fYp = new d(LayoutInflater.from(this.cmR.getPageContext().getPageActivity()).inflate(d.h.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.fYp.Z(bdVar);
        }
    }

    public View bfI() {
        if (this.fYp == null) {
            return null;
        }
        return this.fYp.mRootView;
    }

    private void b(bj bjVar, bd bdVar, int i) {
        if (bjVar != null && bdVar != null) {
            if (this.fYq == null) {
                this.fYq = new e(this.cmR, LayoutInflater.from(this.cmR.getPageContext().getPageActivity()).inflate(d.h.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bjVar.aPq = i;
            this.fYq.aa(bdVar);
            bdVar.a(bjVar);
        }
    }

    public View bfJ() {
        if (this.fYq == null) {
            return null;
        }
        return this.fYq.getRootView();
    }

    public void ad(bd bdVar) {
        if (this.fYq != null && bdVar != null && bdVar.zU() != null && bdVar.zU().aPq == 2) {
            if (this.fYr == null) {
                this.fYr = new com.baidu.tieba.d.b(this.cmR.getPageContext(), this.fYq.bfF());
                this.fYr.lW(5000);
            }
            this.fYr.g(this.cmR.getResources().getString(d.j.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void y(long j, int i) {
        if (this.fYq != null && j > 0) {
            this.fYq.j(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fYp != null) {
                this.fYp.It();
            }
            if (this.fYq != null) {
                this.fYq.It();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.fYp != null) {
            bdTypeListView.removeHeaderView(this.fYp.mRootView);
        }
        if (this.fYq != null) {
            bdTypeListView.removeHeaderView(this.fYq.getRootView());
        }
    }

    public void onDestroy() {
        bfK();
    }

    public void bfK() {
        if (this.fYr != null) {
            this.fYr.amr();
        }
    }
}
