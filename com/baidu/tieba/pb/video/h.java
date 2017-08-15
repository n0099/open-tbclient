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
    private BaseActivity bmE;
    private d eZt;
    private e eZu;
    private com.baidu.tieba.d.b eZv;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.bmE = baseActivity;
    }

    public void a(bq bqVar, bl blVar, int i) {
        Z(blVar);
        b(bqVar, blVar, i);
    }

    private void Z(bl blVar) {
        if (blVar != null) {
            if (this.eZt == null) {
                this.eZt = new d(LayoutInflater.from(this.bmE.getPageContext().getPageActivity()).inflate(d.j.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.eZt.W(blVar);
        }
    }

    public View aWC() {
        if (this.eZt == null) {
            return null;
        }
        return this.eZt.mRootView;
    }

    private void b(bq bqVar, bl blVar, int i) {
        if (bqVar != null && blVar != null) {
            if (this.eZu == null) {
                this.eZu = new e(this.bmE, LayoutInflater.from(this.bmE.getPageContext().getPageActivity()).inflate(d.j.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bqVar.abn = i;
            this.eZu.X(blVar);
            blVar.a(bqVar);
        }
    }

    public View aWD() {
        if (this.eZu == null) {
            return null;
        }
        return this.eZu.getRootView();
    }

    public void aa(bl blVar) {
        if (this.eZu != null && blVar != null && blVar.sJ() != null && blVar.sJ().abn == 2) {
            if (this.eZv == null) {
                this.eZv = new com.baidu.tieba.d.b(this.bmE.getPageContext(), this.eZu.aWz());
                this.eZv.hK(5000);
            }
            this.eZv.f(this.bmE.getResources().getString(d.l.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void w(long j, int i) {
        if (this.eZu != null && j > 0) {
            this.eZu.j(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.eZt != null) {
                this.eZt.Bf();
            }
            if (this.eZu != null) {
                this.eZu.Bf();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.eZt != null) {
            bdTypeListView.removeHeaderView(this.eZt.mRootView);
        }
        if (this.eZu != null) {
            bdTypeListView.removeHeaderView(this.eZu.getRootView());
        }
    }

    public void onDestroy() {
        aWE();
    }

    public void aWE() {
        if (this.eZv != null) {
            this.eZv.YD();
        }
    }
}
