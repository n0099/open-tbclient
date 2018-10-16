package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class h {
    private BaseActivity bwX;
    private d gcf;
    private e gcg;
    private com.baidu.tieba.c.d gch;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.bwX = baseActivity;
    }

    public void a(bh bhVar, bb bbVar, int i) {
        aq(bbVar);
        b(bhVar, bbVar, i);
    }

    private void aq(bb bbVar) {
        if (bbVar != null) {
            if (this.gcf == null) {
                this.gcf = new d(LayoutInflater.from(this.bwX.getPageContext().getPageActivity()).inflate(e.h.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.gcf.an(bbVar);
        }
    }

    public View blW() {
        if (this.gcf == null) {
            return null;
        }
        return this.gcf.mRootView;
    }

    private void b(bh bhVar, bb bbVar, int i) {
        if (bhVar != null && bbVar != null) {
            if (this.gcg == null) {
                this.gcg = new e(this.bwX, LayoutInflater.from(this.bwX.getPageContext().getPageActivity()).inflate(e.h.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bhVar.arL = i;
            this.gcg.ao(bbVar);
            bbVar.a(bhVar);
        }
    }

    public View blX() {
        if (this.gcg == null) {
            return null;
        }
        return this.gcg.getRootView();
    }

    public void ar(bb bbVar) {
        if (this.gcg != null && bbVar != null && bbVar.zy() != null && bbVar.zy().arL == 2) {
            if (this.gch == null) {
                this.gch = new com.baidu.tieba.c.d(this.bwX.getPageContext(), this.gcg.blT());
                this.gch.km(5000);
            }
            this.gch.h(this.bwX.getResources().getString(e.j.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void n(long j, int i) {
        if (this.gcg != null && j > 0) {
            this.gcg.l(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gcf != null) {
                this.gcf.IX();
            }
            if (this.gcg != null) {
                this.gcg.IX();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.gcf != null) {
            bdTypeListView.removeHeaderView(this.gcf.mRootView);
        }
        if (this.gcg != null) {
            bdTypeListView.removeHeaderView(this.gcg.getRootView());
        }
    }

    public void onDestroy() {
        blY();
    }

    public void blY() {
        if (this.gch != null) {
            this.gch.apY();
        }
    }
}
