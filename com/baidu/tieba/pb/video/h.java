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
    private d gcg;
    private e gch;
    private com.baidu.tieba.c.d gci;
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
            if (this.gcg == null) {
                this.gcg = new d(LayoutInflater.from(this.bwX.getPageContext().getPageActivity()).inflate(e.h.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.gcg.an(bbVar);
        }
    }

    public View blW() {
        if (this.gcg == null) {
            return null;
        }
        return this.gcg.mRootView;
    }

    private void b(bh bhVar, bb bbVar, int i) {
        if (bhVar != null && bbVar != null) {
            if (this.gch == null) {
                this.gch = new e(this.bwX, LayoutInflater.from(this.bwX.getPageContext().getPageActivity()).inflate(e.h.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bhVar.arL = i;
            this.gch.ao(bbVar);
            bbVar.a(bhVar);
        }
    }

    public View blX() {
        if (this.gch == null) {
            return null;
        }
        return this.gch.getRootView();
    }

    public void ar(bb bbVar) {
        if (this.gch != null && bbVar != null && bbVar.zy() != null && bbVar.zy().arL == 2) {
            if (this.gci == null) {
                this.gci = new com.baidu.tieba.c.d(this.bwX.getPageContext(), this.gch.blT());
                this.gci.km(5000);
            }
            this.gci.h(this.bwX.getResources().getString(e.j.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void n(long j, int i) {
        if (this.gch != null && j > 0) {
            this.gch.l(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gcg != null) {
                this.gcg.IX();
            }
            if (this.gch != null) {
                this.gch.IX();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.gcg != null) {
            bdTypeListView.removeHeaderView(this.gcg.mRootView);
        }
        if (this.gch != null) {
            bdTypeListView.removeHeaderView(this.gch.getRootView());
        }
    }

    public void onDestroy() {
        blY();
    }

    public void blY() {
        if (this.gci != null) {
            this.gci.apZ();
        }
    }
}
