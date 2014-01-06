package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements Runnable {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        cs csVar;
        cs csVar2;
        cs csVar3;
        csVar = this.a.z;
        if (!csVar.y()) {
            csVar3 = this.a.z;
            csVar3.b(false);
            return;
        }
        csVar2 = this.a.z;
        csVar2.b(true);
    }
}
