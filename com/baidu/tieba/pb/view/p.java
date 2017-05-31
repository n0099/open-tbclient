package com.baidu.tieba.pb.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ l eCy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar) {
        this.eCy = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        t tVar;
        t tVar2;
        t tVar3;
        tVar = this.eCy.eCo;
        if (tVar != null) {
            tVar2 = this.eCy.eCo;
            if (tVar2.getVisibility() == 0) {
                tVar3 = this.eCy.eCo;
                tVar3.setVisibility(8);
            }
        }
    }
}
