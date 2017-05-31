package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class k {
    private BaseActivity bfa;
    private d eAq;
    private e eAr;
    private com.baidu.tieba.d.a eAs;
    private int mSkinType = 3;

    public k(BaseActivity baseActivity) {
        this.bfa = baseActivity;
    }

    public void a(bs bsVar, bl blVar, int i) {
        S(blVar);
        b(bsVar, blVar, i);
    }

    private void S(bl blVar) {
        if (blVar != null) {
            if (this.eAq == null) {
                this.eAq = new d(LayoutInflater.from(this.bfa.getPageContext().getPageActivity()).inflate(w.j.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.eAq.P(blVar);
        }
    }

    public View aOO() {
        if (this.eAq == null) {
            return null;
        }
        return this.eAq.mRootView;
    }

    private void b(bs bsVar, bl blVar, int i) {
        if (bsVar != null && blVar != null) {
            if (this.eAr == null) {
                this.eAr = new e(this.bfa, LayoutInflater.from(this.bfa.getPageContext().getPageActivity()).inflate(w.j.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bsVar.Zs = i;
            this.eAr.Q(blVar);
            blVar.a(bsVar);
        }
    }

    public View aOP() {
        if (this.eAr == null) {
            return null;
        }
        return this.eAr.getRootView();
    }

    public void T(bl blVar) {
        if (this.eAr != null && blVar != null && blVar.sx() != null && blVar.sx().Zs == 2) {
            if (this.eAs == null) {
                this.eAs = new com.baidu.tieba.d.a(this.bfa.getPageContext(), this.eAr.aOL());
                this.eAs.hy(5000);
            }
            this.eAs.f(this.bfa.getResources().getString(w.l.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void v(long j, int i) {
        if (this.eAr != null && j > 0) {
            this.eAr.j(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.eAq != null) {
                this.eAq.Ar();
            }
            if (this.eAr != null) {
                this.eAr.Ar();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.eAq != null) {
            bdTypeListView.removeHeaderView(this.eAq.mRootView);
        }
        if (this.eAr != null) {
            bdTypeListView.removeHeaderView(this.eAr.getRootView());
        }
    }

    public void onDestroy() {
        aOQ();
    }

    public void aOQ() {
        if (this.eAs != null) {
            this.eAs.We();
        }
    }
}
