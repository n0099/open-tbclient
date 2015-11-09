package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ NewSubPbActivity cnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NewSubPbActivity newSubPbActivity) {
        this.cnS = newSubPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        v vVar;
        am amVar;
        am amVar2;
        vVar = this.cnS.cnJ;
        amVar = this.cnS.cnH;
        String ail = amVar.ail();
        amVar2 = this.cnS.cnH;
        vVar.aX(ail, amVar2.aip());
    }
}
