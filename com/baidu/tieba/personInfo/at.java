package com.baidu.tieba.personInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements Runnable {
    final /* synthetic */ d cWV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(d dVar) {
        this.cWV = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bb bbVar;
        bbVar = this.cWV.cRx;
        bbVar.aqu();
    }
}
