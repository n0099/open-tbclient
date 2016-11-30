package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cn implements Runnable {
    final /* synthetic */ cm eww;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(cm cmVar) {
        this.eww = cmVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ck ckVar;
        ckVar = this.eww.ewv;
        ckVar.notifyDataSetChanged();
    }
}
