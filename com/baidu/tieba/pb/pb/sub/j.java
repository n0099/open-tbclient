package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ NewSubPbActivity doF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(NewSubPbActivity newSubPbActivity) {
        this.doF = newSubPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        x xVar;
        ap apVar;
        ap apVar2;
        xVar = this.doF.dow;
        apVar = this.doF.dou;
        String aAo = apVar.aAo();
        apVar2 = this.doF.dou;
        xVar.bt(aAo, apVar2.aAs());
    }
}
