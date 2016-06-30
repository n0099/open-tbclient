package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class df implements Runnable {
    final /* synthetic */ dd dQL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(dd ddVar) {
        this.dQL = ddVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        dc dcVar;
        com.baidu.adp.lib.guide.d dVar;
        dc dcVar2;
        com.baidu.adp.lib.guide.d dVar2;
        dcVar = this.dQL.dQK;
        dVar = dcVar.dQH;
        if (dVar != null) {
            dcVar2 = this.dQL.dQK;
            dVar2 = dcVar2.dQH;
            dVar2.dismiss();
        }
    }
}
