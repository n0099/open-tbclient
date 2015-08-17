package com.baidu.tieba.pb.pb.main;

import android.widget.AbsListView;
import com.baidu.location.BDLocationStatusCodes;
/* loaded from: classes.dex */
class k implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity cbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PbActivity pbActivity) {
        this.cbo = pbActivity;
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
            cbVar = this.cbo.caQ;
            cbVar.aeA();
            dVar = this.cbo.caX;
            if (dVar != null) {
                cbVar4 = this.cbo.caQ;
                dVar3 = this.cbo.caX;
                cbVar4.eA(dVar3.Br());
            }
            cbVar2 = this.cbo.caQ;
            cbVar2.aec();
            dVar2 = this.cbo.caX;
            dVar2.Bu();
            z = this.cbo.caJ;
            if (!z) {
                this.cbo.caJ = true;
                cbVar3 = this.cbo.caQ;
                cbVar3.aeD();
            }
        }
        eVar = this.cbo.caK;
        if (eVar == null) {
            this.cbo.caK = new com.baidu.tbadk.performanceLog.e();
            eVar5 = this.cbo.caK;
            eVar5.eq(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        }
        if (i == 0) {
            cbVar5 = this.cbo.caQ;
            if (cbVar5.aeg() != null) {
                cbVar6 = this.cbo.caQ;
                cbVar6.aeg().notifyDataSetChanged();
            }
            eVar4 = this.cbo.caK;
            eVar4.DH();
        } else if (i == 1) {
            eVar3 = this.cbo.caK;
            eVar3.DH();
        } else {
            eVar2 = this.cbo.caK;
            eVar2.DH();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
