package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class ce implements Runnable {
    final /* synthetic */ cd a;
    private final /* synthetic */ com.baidu.tieba.data.ao b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;
    private final /* synthetic */ String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(cd cdVar, com.baidu.tieba.data.ao aoVar, boolean z, String str, String str2) {
        this.a = cdVar;
        this.b = aoVar;
        this.c = z;
        this.d = str;
        this.e = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        bj bjVar;
        cp cpVar;
        bj bjVar2;
        bj bjVar3;
        com.baidu.tieba.pb.sub.m mVar;
        bj bjVar4;
        cp cpVar2;
        bjVar = this.a.a;
        cpVar = bjVar.aC;
        if (cpVar != null) {
            bjVar4 = this.a.a;
            cpVar2 = bjVar4.aC;
            cpVar2.a(this.b);
        }
        if (this.c) {
            bjVar3 = this.a.a;
            mVar = bjVar3.N;
            mVar.a(this.d, this.e);
        }
        bjVar2 = this.a.a;
        bjVar2.ak();
    }
}
