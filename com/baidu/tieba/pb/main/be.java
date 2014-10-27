package com.baidu.tieba.pb.main;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class be implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        bv bvVar;
        bv bvVar2;
        boolean z;
        bv bvVar3;
        com.baidu.tbadk.performanceLog.a aVar;
        com.baidu.tbadk.performanceLog.a aVar2;
        com.baidu.tbadk.performanceLog.a aVar3;
        com.baidu.tbadk.performanceLog.a aVar4;
        com.baidu.tbadk.performanceLog.a aVar5;
        com.baidu.tbadk.performanceLog.a aVar6;
        if (i == 2 || i == 1) {
            bvVar = this.bvg.buL;
            bvVar.Yd();
            bvVar2 = this.bvg.buL;
            bvVar2.Xh();
            this.bvg.Wd();
            z = this.bvg.buC;
            if (!z) {
                this.bvg.buC = true;
                bvVar3 = this.bvg.buL;
                bvVar3.Yk();
            }
        }
        aVar = this.bvg.buD;
        if (aVar == null) {
            this.bvg.buD = new com.baidu.tbadk.performanceLog.a();
            aVar5 = this.bvg.buD;
            aVar5.dm(1001);
            aVar6 = this.bvg.buD;
            aVar6.YT = this.bvg.buE;
        }
        if (i == 0) {
            aVar4 = this.bvg.buD;
            aVar4.ut();
        } else if (i == 1) {
            aVar3 = this.bvg.buD;
            aVar3.ut();
        } else {
            aVar2 = this.bvg.buD;
            aVar2.ut();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
