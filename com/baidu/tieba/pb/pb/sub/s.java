package com.baidu.tieba.pb.pb.sub;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ l bOf;
    private final /* synthetic */ String bOg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(l lVar, String str) {
        this.bOf = lVar;
        this.bOg = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bOf.hP(this.bOg);
    }
}
