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
    private BaseActivity bmG;
    private d eZv;
    private e eZw;
    private com.baidu.tieba.d.b eZx;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.bmG = baseActivity;
    }

    public void a(bq bqVar, bl blVar, int i) {
        Z(blVar);
        b(bqVar, blVar, i);
    }

    private void Z(bl blVar) {
        if (blVar != null) {
            if (this.eZv == null) {
                this.eZv = new d(LayoutInflater.from(this.bmG.getPageContext().getPageActivity()).inflate(d.j.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.eZv.W(blVar);
        }
    }

    public View aWx() {
        if (this.eZv == null) {
            return null;
        }
        return this.eZv.mRootView;
    }

    private void b(bq bqVar, bl blVar, int i) {
        if (bqVar != null && blVar != null) {
            if (this.eZw == null) {
                this.eZw = new e(this.bmG, LayoutInflater.from(this.bmG.getPageContext().getPageActivity()).inflate(d.j.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bqVar.abn = i;
            this.eZw.X(blVar);
            blVar.a(bqVar);
        }
    }

    public View aWy() {
        if (this.eZw == null) {
            return null;
        }
        return this.eZw.getRootView();
    }

    public void aa(bl blVar) {
        if (this.eZw != null && blVar != null && blVar.sK() != null && blVar.sK().abn == 2) {
            if (this.eZx == null) {
                this.eZx = new com.baidu.tieba.d.b(this.bmG.getPageContext(), this.eZw.aWu());
                this.eZx.hK(5000);
            }
            this.eZx.f(this.bmG.getResources().getString(d.l.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void w(long j, int i) {
        if (this.eZw != null && j > 0) {
            this.eZw.j(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.eZv != null) {
                this.eZv.Bf();
            }
            if (this.eZw != null) {
                this.eZw.Bf();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.eZv != null) {
            bdTypeListView.removeHeaderView(this.eZv.mRootView);
        }
        if (this.eZw != null) {
            bdTypeListView.removeHeaderView(this.eZw.getRootView());
        }
    }

    public void onDestroy() {
        aWz();
    }

    public void aWz() {
        if (this.eZx != null) {
            this.eZx.YA();
        }
    }
}
