package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class k {
    private BaseActivity bhX;
    private d eJO;
    private e eJP;
    private com.baidu.tieba.d.a eJQ;
    private int mSkinType = 3;

    public k(BaseActivity baseActivity) {
        this.bhX = baseActivity;
    }

    public void a(bt btVar, bm bmVar, int i) {
        T(bmVar);
        b(btVar, bmVar, i);
    }

    private void T(bm bmVar) {
        if (bmVar != null) {
            if (this.eJO == null) {
                this.eJO = new d(LayoutInflater.from(this.bhX.getPageContext().getPageActivity()).inflate(w.j.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.eJO.Q(bmVar);
        }
    }

    public View aSN() {
        if (this.eJO == null) {
            return null;
        }
        return this.eJO.mRootView;
    }

    private void b(bt btVar, bm bmVar, int i) {
        if (btVar != null && bmVar != null) {
            if (this.eJP == null) {
                this.eJP = new e(this.bhX, LayoutInflater.from(this.bhX.getPageContext().getPageActivity()).inflate(w.j.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            btVar.Zu = i;
            this.eJP.R(bmVar);
            bmVar.a(btVar);
        }
    }

    public View aSO() {
        if (this.eJP == null) {
            return null;
        }
        return this.eJP.getRootView();
    }

    public void U(bm bmVar) {
        if (this.eJP != null && bmVar != null && bmVar.sv() != null && bmVar.sv().Zu == 2) {
            if (this.eJQ == null) {
                this.eJQ = new com.baidu.tieba.d.a(this.bhX.getPageContext(), this.eJP.aSK());
                this.eJQ.hC(5000);
            }
            this.eJQ.f(this.bhX.getResources().getString(w.l.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void w(long j, int i) {
        if (this.eJP != null && j > 0) {
            this.eJP.j(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.eJO != null) {
                this.eJO.AM();
            }
            if (this.eJP != null) {
                this.eJP.AM();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.eJO != null) {
            bdTypeListView.removeHeaderView(this.eJO.mRootView);
        }
        if (this.eJP != null) {
            bdTypeListView.removeHeaderView(this.eJP.getRootView());
        }
    }

    public void onDestroy() {
        aSP();
    }

    public void aSP() {
        if (this.eJQ != null) {
            this.eJQ.Xv();
        }
    }
}
