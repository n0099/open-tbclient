package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import com.baidu.location.BDLocationStatusCodes;
/* loaded from: classes.dex */
class c implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        cj cjVar;
        cj cjVar2;
        boolean z;
        cj cjVar3;
        com.baidu.tbadk.performanceLog.h hVar;
        com.baidu.tbadk.performanceLog.h hVar2;
        com.baidu.tbadk.performanceLog.h hVar3;
        cj cjVar4;
        com.baidu.tbadk.performanceLog.h hVar4;
        cj cjVar5;
        com.baidu.tbadk.performanceLog.h hVar5;
        com.baidu.tbadk.performanceLog.h hVar6;
        if (i == 2 || i == 1) {
            cjVar = this.bIJ.bIl;
            cjVar.abC();
            cjVar2 = this.bIJ.bIl;
            cjVar2.aaF();
            this.bIJ.Zw();
            z = this.bIJ.bId;
            if (!z) {
                this.bIJ.bId = true;
                cjVar3 = this.bIJ.bIl;
                cjVar3.abK();
            }
        }
        hVar = this.bIJ.bIe;
        if (hVar == null) {
            this.bIJ.bIe = new com.baidu.tbadk.performanceLog.h();
            hVar5 = this.bIJ.bIe;
            hVar5.eb(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            hVar6 = this.bIJ.bIe;
            hVar6.apt = this.bIJ.aJq;
        }
        if (i == 0) {
            cjVar4 = this.bIJ.bIl;
            if (cjVar4.aaR() != null) {
                cjVar5 = this.bIJ.bIl;
                cjVar5.aaR().notifyDataSetChanged();
            }
            hVar4 = this.bIJ.bIe;
            hVar4.Ct();
        } else if (i == 1) {
            hVar3 = this.bIJ.bIe;
            hVar3.Ct();
        } else {
            hVar2 = this.bIJ.bIe;
            hVar2.Ct();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
