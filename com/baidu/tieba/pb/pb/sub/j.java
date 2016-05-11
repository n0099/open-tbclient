package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ NewSubPbActivity dqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(NewSubPbActivity newSubPbActivity) {
        this.dqn = newSubPbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        y yVar;
        ap apVar;
        ap apVar2;
        yVar = this.dqn.dqe;
        apVar = this.dqn.dqc;
        String aAw = apVar.aAw();
        apVar2 = this.dqn.dqc;
        yVar.by(aAw, apVar2.aAA());
    }
}
