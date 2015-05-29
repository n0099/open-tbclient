package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import com.baidu.location.BDLocationStatusCodes;
/* loaded from: classes.dex */
class e implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        ch chVar;
        ch chVar2;
        boolean z;
        ch chVar3;
        com.baidu.tbadk.performanceLog.h hVar;
        com.baidu.tbadk.performanceLog.h hVar2;
        com.baidu.tbadk.performanceLog.h hVar3;
        ch chVar4;
        com.baidu.tbadk.performanceLog.h hVar4;
        ch chVar5;
        com.baidu.tbadk.performanceLog.h hVar5;
        if (i == 2 || i == 1) {
            chVar = this.bKT.bKz;
            chVar.acw();
            chVar2 = this.bKT.bKz;
            chVar2.abT();
            this.bKT.aaN();
            z = this.bKT.bKs;
            if (!z) {
                this.bKT.bKs = true;
                chVar3 = this.bKT.bKz;
                chVar3.acz();
            }
        }
        hVar = this.bKT.bKt;
        if (hVar == null) {
            this.bKT.bKt = new com.baidu.tbadk.performanceLog.h();
            hVar5 = this.bKT.bKt;
            hVar5.el(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        }
        if (i == 0) {
            chVar4 = this.bKT.bKz;
            if (chVar4.aca() != null) {
                chVar5 = this.bKT.bKz;
                chVar5.aca().notifyDataSetChanged();
            }
            hVar4 = this.bKT.bKt;
            hVar4.De();
        } else if (i == 1) {
            hVar3 = this.bKT.bKt;
            hVar3.De();
        } else {
            hVar2 = this.bKT.bKt;
            hVar2.De();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
