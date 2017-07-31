package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class h {
    private BaseActivity bmv;
    private d eXA;
    private e eXB;
    private com.baidu.tieba.d.a eXC;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.bmv = baseActivity;
    }

    public void a(bq bqVar, bl blVar, int i) {
        Z(blVar);
        b(bqVar, blVar, i);
    }

    private void Z(bl blVar) {
        if (blVar != null) {
            if (this.eXA == null) {
                this.eXA = new d(LayoutInflater.from(this.bmv.getPageContext().getPageActivity()).inflate(d.j.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.eXA.W(blVar);
        }
    }

    public View aVV() {
        if (this.eXA == null) {
            return null;
        }
        return this.eXA.mRootView;
    }

    private void b(bq bqVar, bl blVar, int i) {
        if (bqVar != null && blVar != null) {
            if (this.eXB == null) {
                this.eXB = new e(this.bmv, LayoutInflater.from(this.bmv.getPageContext().getPageActivity()).inflate(d.j.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bqVar.abl = i;
            this.eXB.X(blVar);
            blVar.a(bqVar);
        }
    }

    public View aVW() {
        if (this.eXB == null) {
            return null;
        }
        return this.eXB.getRootView();
    }

    public void aa(bl blVar) {
        if (this.eXB != null && blVar != null && blVar.sJ() != null && blVar.sJ().abl == 2) {
            if (this.eXC == null) {
                this.eXC = new com.baidu.tieba.d.a(this.bmv.getPageContext(), this.eXB.aVS());
                this.eXC.hJ(5000);
            }
            this.eXC.f(this.bmv.getResources().getString(d.l.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void w(long j, int i) {
        if (this.eXB != null && j > 0) {
            this.eXB.j(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.eXA != null) {
                this.eXA.Bf();
            }
            if (this.eXB != null) {
                this.eXB.Bf();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.eXA != null) {
            bdTypeListView.removeHeaderView(this.eXA.mRootView);
        }
        if (this.eXB != null) {
            bdTypeListView.removeHeaderView(this.eXB.getRootView());
        }
    }

    public void onDestroy() {
        aVX();
    }

    public void aVX() {
        if (this.eXC != null) {
            this.eXC.Yi();
        }
    }
}
