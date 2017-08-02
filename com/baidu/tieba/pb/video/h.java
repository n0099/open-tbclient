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
    private BaseActivity bll;
    private d eWo;
    private e eWp;
    private com.baidu.tieba.d.b eWq;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.bll = baseActivity;
    }

    public void a(bq bqVar, bl blVar, int i) {
        Z(blVar);
        b(bqVar, blVar, i);
    }

    private void Z(bl blVar) {
        if (blVar != null) {
            if (this.eWo == null) {
                this.eWo = new d(LayoutInflater.from(this.bll.getPageContext().getPageActivity()).inflate(d.j.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.eWo.W(blVar);
        }
    }

    public View aVK() {
        if (this.eWo == null) {
            return null;
        }
        return this.eWo.mRootView;
    }

    private void b(bq bqVar, bl blVar, int i) {
        if (bqVar != null && blVar != null) {
            if (this.eWp == null) {
                this.eWp = new e(this.bll, LayoutInflater.from(this.bll.getPageContext().getPageActivity()).inflate(d.j.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bqVar.ZP = i;
            this.eWp.X(blVar);
            blVar.a(bqVar);
        }
    }

    public View aVL() {
        if (this.eWp == null) {
            return null;
        }
        return this.eWp.getRootView();
    }

    public void aa(bl blVar) {
        if (this.eWp != null && blVar != null && blVar.sz() != null && blVar.sz().ZP == 2) {
            if (this.eWq == null) {
                this.eWq = new com.baidu.tieba.d.b(this.bll.getPageContext(), this.eWp.aVH());
                this.eWq.hI(5000);
            }
            this.eWq.f(this.bll.getResources().getString(d.l.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void w(long j, int i) {
        if (this.eWp != null && j > 0) {
            this.eWp.j(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.eWo != null) {
                this.eWo.AX();
            }
            if (this.eWp != null) {
                this.eWp.AX();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.eWo != null) {
            bdTypeListView.removeHeaderView(this.eWo.mRootView);
        }
        if (this.eWp != null) {
            bdTypeListView.removeHeaderView(this.eWp.getRootView());
        }
    }

    public void onDestroy() {
        aVM();
    }

    public void aVM() {
        if (this.eWq != null) {
            this.eWq.Yd();
        }
    }
}
