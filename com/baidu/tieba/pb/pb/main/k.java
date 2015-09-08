package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import com.baidu.location.BDLocationStatusCodes;
/* loaded from: classes.dex */
class k implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PbActivity pbActivity) {
        this.ccj = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        cb cbVar;
        com.baidu.tbadk.editortools.c.d dVar;
        cb cbVar2;
        com.baidu.tbadk.editortools.c.d dVar2;
        boolean z;
        cb cbVar3;
        cb cbVar4;
        com.baidu.tbadk.editortools.c.d dVar3;
        com.baidu.tbadk.performanceLog.e eVar;
        com.baidu.tbadk.performanceLog.e eVar2;
        com.baidu.tbadk.performanceLog.e eVar3;
        cb cbVar5;
        com.baidu.tbadk.performanceLog.e eVar4;
        cb cbVar6;
        com.baidu.tbadk.performanceLog.e eVar5;
        if (i == 2 || i == 1) {
            cbVar = this.ccj.cbL;
            cbVar.aeO();
            dVar = this.ccj.cbS;
            if (dVar != null) {
                cbVar4 = this.ccj.cbL;
                dVar3 = this.ccj.cbS;
                cbVar4.eI(dVar3.BE());
            }
            cbVar2 = this.ccj.cbL;
            cbVar2.aeq();
            dVar2 = this.ccj.cbS;
            dVar2.BH();
            z = this.ccj.cbE;
            if (!z) {
                this.ccj.cbE = true;
                cbVar3 = this.ccj.cbL;
                cbVar3.aeR();
            }
        }
        eVar = this.ccj.cbF;
        if (eVar == null) {
            this.ccj.cbF = new com.baidu.tbadk.performanceLog.e();
            eVar5 = this.ccj.cbF;
            eVar5.ey(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        }
        if (i == 0) {
            cbVar5 = this.ccj.cbL;
            if (cbVar5.aeu() != null) {
                cbVar6 = this.ccj.cbL;
                cbVar6.aeu().notifyDataSetChanged();
            }
            eVar4 = this.ccj.cbF;
            eVar4.DR();
        } else if (i == 1) {
            eVar3 = this.ccj.cbF;
            eVar3.DR();
        } else {
            eVar2 = this.ccj.cbF;
            eVar2.DR();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
