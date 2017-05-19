package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct implements Runnable {
    final /* synthetic */ cs eix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cs csVar) {
        this.eix = csVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        cq cqVar;
        cqVar = this.eix.eiw;
        cqVar.notifyDataSetChanged();
    }
}
