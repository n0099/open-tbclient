package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class by implements Runnable {
    final /* synthetic */ bx a;
    private final /* synthetic */ com.baidu.tieba.a.ax b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bx bxVar, com.baidu.tieba.a.ax axVar, boolean z, String str) {
        this.a = bxVar;
        this.b = axVar;
        this.c = z;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        bl blVar;
        cq cqVar;
        bl blVar2;
        cr crVar;
        bl blVar3;
        cq cqVar2;
        blVar = this.a.a;
        cqVar = blVar.ap;
        if (cqVar != null) {
            blVar3 = this.a.a;
            cqVar2 = blVar3.ap;
            cqVar2.a(this.b);
        }
        if (this.c) {
            blVar2 = this.a.a;
            crVar = blVar2.A;
            crVar.b(this.d);
        }
    }
}
