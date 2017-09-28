package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class h {
    private BaseActivity boM;
    private d eTi;
    private e eTj;
    private com.baidu.tieba.d.a eTk;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.boM = baseActivity;
    }

    public void a(bm bmVar, bh bhVar, int i) {
        aa(bhVar);
        b(bmVar, bhVar, i);
    }

    private void aa(bh bhVar) {
        if (bhVar != null) {
            if (this.eTi == null) {
                this.eTi = new d(LayoutInflater.from(this.boM.getPageContext().getPageActivity()).inflate(d.j.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.eTi.X(bhVar);
        }
    }

    public View aUf() {
        if (this.eTi == null) {
            return null;
        }
        return this.eTi.mRootView;
    }

    private void b(bm bmVar, bh bhVar, int i) {
        if (bmVar != null && bhVar != null) {
            if (this.eTj == null) {
                this.eTj = new e(this.boM, LayoutInflater.from(this.boM.getPageContext().getPageActivity()).inflate(d.j.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bmVar.aas = i;
            this.eTj.Y(bhVar);
            bhVar.a(bmVar);
        }
    }

    public View aUg() {
        if (this.eTj == null) {
            return null;
        }
        return this.eTj.getRootView();
    }

    public void ab(bh bhVar) {
        if (this.eTj != null && bhVar != null && bhVar.sz() != null && bhVar.sz().aas == 2) {
            if (this.eTk == null) {
                this.eTk = new com.baidu.tieba.d.a(this.boM.getPageContext(), this.eTj.aUc());
                this.eTk.m11if(5000);
            }
            this.eTk.g(this.boM.getResources().getString(d.l.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void w(long j, int i) {
        if (this.eTj != null && j > 0) {
            this.eTj.k(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.eTi != null) {
                this.eTi.Ay();
            }
            if (this.eTj != null) {
                this.eTj.Ay();
            }
            this.mSkinType = i;
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        if (this.eTi != null) {
            bdTypeListView.removeHeaderView(this.eTi.mRootView);
        }
        if (this.eTj != null) {
            bdTypeListView.removeHeaderView(this.eTj.getRootView());
        }
    }

    public void onDestroy() {
        aUh();
    }

    public void aUh() {
        if (this.eTk != null) {
            this.eTk.Zz();
        }
    }
}
