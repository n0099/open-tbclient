package com.baidu.tieba.pb.main;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class d implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PbActivity pbActivity) {
        this.bAS = pbActivity;
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
            bzVar = this.bAS.bAw;
            bzVar.Ze();
            bzVar2 = this.bAS.bAw;
            bzVar2.Yh();
            this.bAS.Xd();
            z = this.bAS.bAo;
            if (!z) {
                this.bAS.bAo = true;
                bzVar3 = this.bAS.bAw;
                bzVar3.Zl();
            }
        }
        hVar = this.bAS.bAp;
        if (hVar == null) {
            this.bAS.bAp = new com.baidu.tbadk.performanceLog.h();
            hVar5 = this.bAS.bAp;
            hVar5.dX(1001);
            hVar6 = this.bAS.bAp;
            hVar6.agH = this.bAS.aDw;
        }
        if (i == 0) {
            bzVar4 = this.bAS.bAw;
            if (bzVar4.Yt() != null) {
                bzVar5 = this.bAS.bAw;
                bzVar5.Yt().notifyDataSetChanged();
            }
            hVar4 = this.bAS.bAp;
            hVar4.yZ();
        } else if (i == 1) {
            hVar3 = this.bAS.bAp;
            hVar3.yZ();
        } else {
            hVar2 = this.bAS.bAp;
            hVar2.yZ();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
