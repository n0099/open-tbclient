package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import com.baidu.location.BDLocationStatusCodes;
/* loaded from: classes.dex */
class e implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PbActivity pbActivity) {
        this.bKU = pbActivity;
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
            chVar = this.bKU.bKA;
            chVar.acx();
            chVar2 = this.bKU.bKA;
            chVar2.abU();
            this.bKU.aaO();
            z = this.bKU.bKt;
            if (!z) {
                this.bKU.bKt = true;
                chVar3 = this.bKU.bKA;
                chVar3.acA();
            }
        }
        hVar = this.bKU.bKu;
        if (hVar == null) {
            this.bKU.bKu = new com.baidu.tbadk.performanceLog.h();
            hVar5 = this.bKU.bKu;
            hVar5.el(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        }
        if (i == 0) {
            chVar4 = this.bKU.bKA;
            if (chVar4.acb() != null) {
                chVar5 = this.bKU.bKA;
                chVar5.acb().notifyDataSetChanged();
            }
            hVar4 = this.bKU.bKu;
            hVar4.Df();
        } else if (i == 1) {
            hVar3 = this.bKU.bKu;
            hVar3.Df();
        } else {
            hVar2 = this.bKU.bKu;
            hVar2.Df();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
