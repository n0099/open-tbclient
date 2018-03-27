package com.baidu.tieba.pb.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class h {
    private BaseActivity bSF;
    private d gbW;
    private e gbX;
    private com.baidu.tieba.d.c gbY;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.bSF = baseActivity;
    }

    public void a(bj bjVar, bd bdVar, int i) {
        af(bdVar);
        b(bjVar, bdVar, i);
    }

    private void af(bd bdVar) {
        if (bdVar != null) {
            if (this.gbW == null) {
                this.gbW = new d(LayoutInflater.from(this.bSF.getPageContext().getPageActivity()).inflate(d.h.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.gbW.ac(bdVar);
        }
    }

    public View bhn() {
        if (this.gbW == null) {
            return null;
        }
        return this.gbW.mRootView;
    }

    private void b(bj bjVar, bd bdVar, int i) {
        if (bjVar != null && bdVar != null) {
            if (this.gbX == null) {
                this.gbX = new e(this.bSF, LayoutInflater.from(this.bSF.getPageContext().getPageActivity()).inflate(d.h.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bjVar.aQH = i;
            this.gbX.ad(bdVar);
            bdVar.a(bjVar);
        }
    }

    public View bho() {
        if (this.gbX == null) {
            return null;
        }
        return this.gbX.getRootView();
    }

    public void ag(bd bdVar) {
        if (this.gbX != null && bdVar != null && bdVar.Ao() != null && bdVar.Ao().aQH == 2) {
            if (this.gbY == null) {
                this.gbY = new com.baidu.tieba.d.c(this.bSF.getPageContext(), this.gbX.bhk());
                this.gbY.lT(5000);
            }
            this.gbY.g(this.bSF.getResources().getString(d.j.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void y(long j, int i) {
        if (this.gbX != null && j > 0) {
            this.gbX.i(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gbW != null) {
                this.gbW.Jb();
            }
            if (this.gbX != null) {
                this.gbX.Jb();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.gbW != null) {
            bdTypeListView.removeHeaderView(this.gbW.mRootView);
        }
        if (this.gbX != null) {
            bdTypeListView.removeHeaderView(this.gbX.getRootView());
        }
    }

    public void onDestroy() {
        bhp();
    }

    public void bhp() {
        if (this.gbY != null) {
            this.gbY.anh();
        }
    }
}
