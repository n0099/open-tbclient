package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class cj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ci f1581a;
    private final /* synthetic */ com.baidu.tieba.data.bd b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(ci ciVar, com.baidu.tieba.data.bd bdVar, boolean z, String str) {
        this.f1581a = ciVar;
        this.b = bdVar;
        this.c = z;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        br brVar;
        cz czVar;
        br brVar2;
        db dbVar;
        br brVar3;
        cz czVar2;
        brVar = this.f1581a.f1580a;
        czVar = brVar.au;
        if (czVar != null) {
            brVar3 = this.f1581a.f1580a;
            czVar2 = brVar3.au;
            czVar2.a(this.b);
        }
        if (this.c) {
            brVar2 = this.f1581a.f1580a;
            dbVar = brVar2.E;
            dbVar.b(this.d);
        }
    }
}
