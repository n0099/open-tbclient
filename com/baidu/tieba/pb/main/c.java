package com.baidu.tieba.pb.main;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class c implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PbActivity pbActivity) {
        this.bzj = pbActivity;
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
            bzVar = this.bzj.byO;
            bzVar.YE();
            bzVar2 = this.bzj.byO;
            bzVar2.XH();
            this.bzj.WD();
            z = this.bzj.byG;
            if (!z) {
                this.bzj.byG = true;
                bzVar3 = this.bzj.byO;
                bzVar3.YL();
            }
        }
        hVar = this.bzj.byH;
        if (hVar == null) {
            this.bzj.byH = new com.baidu.tbadk.performanceLog.h();
            hVar5 = this.bzj.byH;
            hVar5.dR(1001);
            hVar6 = this.bzj.byH;
            hVar6.agm = this.bzj.aCy;
        }
        if (i == 0) {
            bzVar4 = this.bzj.byO;
            if (bzVar4.XT() != null) {
                bzVar5 = this.bzj.byO;
                bzVar5.XT().notifyDataSetChanged();
            }
            hVar4 = this.bzj.byH;
            hVar4.yO();
        } else if (i == 1) {
            hVar3 = this.bzj.byH;
            hVar3.yO();
        } else {
            hVar2 = this.bzj.byH;
            hVar2.yO();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
