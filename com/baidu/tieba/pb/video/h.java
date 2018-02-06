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
    private BaseActivity bSO;
    private d gbR;
    private e gbS;
    private com.baidu.tieba.d.c gbT;
    private int mSkinType = 3;

    public h(BaseActivity baseActivity) {
        this.bSO = baseActivity;
    }

    public void a(bj bjVar, bd bdVar, int i) {
        af(bdVar);
        b(bjVar, bdVar, i);
    }

    private void af(bd bdVar) {
        if (bdVar != null) {
            if (this.gbR == null) {
                this.gbR = new d(LayoutInflater.from(this.bSO.getPageContext().getPageActivity()).inflate(d.h.pb_header_video_abstract_layout, (ViewGroup) null));
            }
            this.gbR.ac(bdVar);
        }
    }

    public View bhn() {
        if (this.gbR == null) {
            return null;
        }
        return this.gbR.mRootView;
    }

    private void b(bj bjVar, bd bdVar, int i) {
        if (bjVar != null && bdVar != null) {
            if (this.gbS == null) {
                this.gbS = new e(this.bSO, LayoutInflater.from(this.bSO.getPageContext().getPageActivity()).inflate(d.h.video_pb_video_channel_info_layout, (ViewGroup) null));
            }
            bjVar.aQQ = i;
            this.gbS.ad(bdVar);
            bdVar.a(bjVar);
        }
    }

    public View bho() {
        if (this.gbS == null) {
            return null;
        }
        return this.gbS.getRootView();
    }

    public void ag(bd bdVar) {
        if (this.gbS != null && bdVar != null && bdVar.Ao() != null && bdVar.Ao().aQQ == 2) {
            if (this.gbT == null) {
                this.gbT = new com.baidu.tieba.d.c(this.bSO.getPageContext(), this.gbS.bhk());
                this.gbT.lT(5000);
            }
            this.gbT.g(this.bSO.getResources().getString(d.j.pb_order_channel_tip), "pb_show_order_channel_tip", true);
        }
    }

    public void y(long j, int i) {
        if (this.gbS != null && j > 0) {
            this.gbS.i(i, j);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gbR != null) {
                this.gbR.Jb();
            }
            if (this.gbS != null) {
                this.gbS.Jb();
            }
            this.mSkinType = i;
        }
    }

    public void b(BdTypeListView bdTypeListView) {
        if (this.gbR != null) {
            bdTypeListView.removeHeaderView(this.gbR.mRootView);
        }
        if (this.gbS != null) {
            bdTypeListView.removeHeaderView(this.gbS.getRootView());
        }
    }

    public void onDestroy() {
        bhp();
    }

    public void bhp() {
        if (this.gbT != null) {
            this.gbT.anh();
        }
    }
}
