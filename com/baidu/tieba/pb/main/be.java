package com.baidu.tieba.pb.main;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class be implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(PbActivity pbActivity) {
        this.bvu = pbActivity;
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
            bvVar = this.bvu.buZ;
            bvVar.Yg();
            bvVar2 = this.bvu.buZ;
            bvVar2.Xk();
            this.bvu.Wg();
            z = this.bvu.buQ;
            if (!z) {
                this.bvu.buQ = true;
                bvVar3 = this.bvu.buZ;
                bvVar3.Yn();
            }
        }
        aVar = this.bvu.buR;
        if (aVar == null) {
            this.bvu.buR = new com.baidu.tbadk.performanceLog.a();
            aVar5 = this.bvu.buR;
            aVar5.dm(1001);
            aVar6 = this.bvu.buR;
            aVar6.YX = this.bvu.buS;
        }
        if (i == 0) {
            aVar4 = this.bvu.buR;
            aVar4.uv();
        } else if (i == 1) {
            aVar3 = this.bvu.buR;
            aVar3.uv();
        } else {
            aVar2 = this.bvu.buR;
            aVar2.uv();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
