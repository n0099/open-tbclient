package com.baidu.tieba.pb.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ l eLV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar) {
        this.eLV = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        t tVar;
        t tVar2;
        t tVar3;
        tVar = this.eLV.eLL;
        if (tVar != null) {
            tVar2 = this.eLV.eLL;
            if (tVar2.getVisibility() == 0) {
                tVar3 = this.eLV.eLL;
                tVar3.setVisibility(8);
            }
        }
    }
}
