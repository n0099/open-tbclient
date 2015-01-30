package com.baidu.tieba.pb.main;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class d implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PbActivity pbActivity) {
        this.bAT = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        bz bzVar;
        bz bzVar2;
        boolean z;
        bz bzVar3;
        com.baidu.tbadk.performanceLog.h hVar;
        com.baidu.tbadk.performanceLog.h hVar2;
        com.baidu.tbadk.performanceLog.h hVar3;
        bz bzVar4;
        com.baidu.tbadk.performanceLog.h hVar4;
        bz bzVar5;
        com.baidu.tbadk.performanceLog.h hVar5;
        com.baidu.tbadk.performanceLog.h hVar6;
        if (i == 2 || i == 1) {
            bzVar = this.bAT.bAx;
            bzVar.Zj();
            bzVar2 = this.bAT.bAx;
            bzVar2.Ym();
            this.bAT.Xi();
            z = this.bAT.bAp;
            if (!z) {
                this.bAT.bAp = true;
                bzVar3 = this.bAT.bAx;
                bzVar3.Zq();
            }
        }
        hVar = this.bAT.bAq;
        if (hVar == null) {
            this.bAT.bAq = new com.baidu.tbadk.performanceLog.h();
            hVar5 = this.bAT.bAq;
            hVar5.dX(1001);
            hVar6 = this.bAT.bAq;
            hVar6.agK = this.bAT.aDz;
        }
        if (i == 0) {
            bzVar4 = this.bAT.bAx;
            if (bzVar4.Yy() != null) {
                bzVar5 = this.bAT.bAx;
                bzVar5.Yy().notifyDataSetChanged();
            }
            hVar4 = this.bAT.bAq;
            hVar4.zf();
        } else if (i == 1) {
            hVar3 = this.bAT.bAq;
            hVar3.zf();
        } else {
            hVar2 = this.bAT.bAq;
            hVar2.zf();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
