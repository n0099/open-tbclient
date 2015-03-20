package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import com.baidu.location.BDLocationStatusCodes;
/* loaded from: classes.dex */
class c implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        ci ciVar;
        ci ciVar2;
        boolean z;
        ci ciVar3;
        com.baidu.tbadk.performanceLog.h hVar;
        com.baidu.tbadk.performanceLog.h hVar2;
        com.baidu.tbadk.performanceLog.h hVar3;
        ci ciVar4;
        com.baidu.tbadk.performanceLog.h hVar4;
        ci ciVar5;
        com.baidu.tbadk.performanceLog.h hVar5;
        com.baidu.tbadk.performanceLog.h hVar6;
        if (i == 2 || i == 1) {
            ciVar = this.bIv.bHY;
            ciVar.abo();
            ciVar2 = this.bIv.bHY;
            ciVar2.aas();
            this.bIv.Zj();
            z = this.bIv.bHQ;
            if (!z) {
                this.bIv.bHQ = true;
                ciVar3 = this.bIv.bHY;
                ciVar3.abv();
            }
        }
        hVar = this.bIv.bHR;
        if (hVar == null) {
            this.bIv.bHR = new com.baidu.tbadk.performanceLog.h();
            hVar5 = this.bIv.bHR;
            hVar5.eb(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
            hVar6 = this.bIv.bHR;
            hVar6.apk = this.bIv.aJi;
        }
        if (i == 0) {
            ciVar4 = this.bIv.bHY;
            if (ciVar4.aaE() != null) {
                ciVar5 = this.bIv.bHY;
                ciVar5.aaE().notifyDataSetChanged();
            }
            hVar4 = this.bIv.bHR;
            hVar4.Cn();
        } else if (i == 1) {
            hVar3 = this.bIv.bHR;
            hVar3.Cn();
        } else {
            hVar2 = this.bIv.bHR;
            hVar2.Cn();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
