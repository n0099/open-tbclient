package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ce implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cd f1534a;
    private final /* synthetic */ com.baidu.tieba.data.bd b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(cd cdVar, com.baidu.tieba.data.bd bdVar, boolean z, String str) {
        this.f1534a = cdVar;
        this.b = bdVar;
        this.c = z;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        bo boVar;
        cu cuVar;
        bo boVar2;
        cv cvVar;
        bo boVar3;
        cu cuVar2;
        boVar = this.f1534a.f1533a;
        cuVar = boVar.aq;
        if (cuVar != null) {
            boVar3 = this.f1534a.f1533a;
            cuVar2 = boVar3.aq;
            cuVar2.a(this.b);
        }
        if (this.c) {
            boVar2 = this.f1534a.f1533a;
            cvVar = boVar2.A;
            cvVar.b(this.d);
        }
    }
}
