package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class cd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cc f1498a;
    private final /* synthetic */ com.baidu.tieba.data.bh b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(cc ccVar, com.baidu.tieba.data.bh bhVar, boolean z, String str) {
        this.f1498a = ccVar;
        this.b = bhVar;
        this.c = z;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        bn bnVar;
        ct ctVar;
        bn bnVar2;
        cu cuVar;
        bn bnVar3;
        ct ctVar2;
        bnVar = this.f1498a.f1497a;
        ctVar = bnVar.ao;
        if (ctVar != null) {
            bnVar3 = this.f1498a.f1497a;
            ctVar2 = bnVar3.ao;
            ctVar2.a(this.b);
        }
        if (this.c) {
            bnVar2 = this.f1498a.f1497a;
            cuVar = bnVar2.z;
            cuVar.b(this.d);
        }
    }
}
