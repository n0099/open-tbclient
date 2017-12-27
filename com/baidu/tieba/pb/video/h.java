package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class h {
    private BaseActivity cmI;
    private d fWO;
    private e fWP;
    private com.baidu.tieba.d.b fWQ;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.cmI = baseActivity;
    }

    public void a(bk bkVar, be beVar, int i) {
        ac(beVar);
        b(bkVar, beVar, i);
    }

    private void ac(be beVar) {
        if (beVar != null) {
            if (this.fWO == null) {
                this.fWO = new d(LayoutInflater.from(this.cmI.getPageContext().getPageActivity()).inflate(d.h.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.fWO.Z(beVar);
        }
    }

    public View bfH() {
        if (this.fWO == null) {
            return null;
        }
        return this.fWO.mRootView;
    }

    private void b(bk bkVar, be beVar, int i) {
        if (bkVar != null && beVar != null) {
            if (this.fWP == null) {
                this.fWP = new e(this.cmI, LayoutInflater.from(this.cmI.getPageContext().getPageActivity()).inflate(d.h.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bkVar.aPr = i;
            this.fWP.aa(beVar);
            beVar.a(bkVar);
        }
    }

    public View bfI() {
        if (this.fWP == null) {
            return null;
        }
        return this.fWP.getRootView();
    }

    public void ad(be beVar) {
        if (this.fWP != null && beVar != null && beVar.Ac() != null && beVar.Ac().aPr == 2) {
            if (this.fWQ == null) {
                this.fWQ = new com.baidu.tieba.d.b(this.cmI.getPageContext(), this.fWP.bfE());
                this.fWQ.lT(5000);
            }
            this.fWQ.g(this.cmI.getResources().getString(d.j.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void y(long j, int i) {
        if (this.fWP != null && j > 0) {
            this.fWP.l(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fWO != null) {
                this.fWO.IA();
            }
            if (this.fWP != null) {
                this.fWP.IA();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.fWO != null) {
            bdTypeListView.removeHeaderView(this.fWO.mRootView);
        }
        if (this.fWP != null) {
            bdTypeListView.removeHeaderView(this.fWP.getRootView());
        }
    }

    public void onDestroy() {
        bfJ();
    }

    public void bfJ() {
        if (this.fWQ != null) {
            this.fWQ.alo();
        }
    }
}
