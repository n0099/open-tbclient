package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ca implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bz f1245a;
    private final /* synthetic */ com.baidu.tieba.data.aw b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bz bzVar, com.baidu.tieba.data.aw awVar, boolean z, String str) {
        this.f1245a = bzVar;
        this.b = awVar;
        this.c = z;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        bk bkVar;
        cq cqVar;
        bk bkVar2;
        cr crVar;
        bk bkVar3;
        cq cqVar2;
        bkVar = this.f1245a.f1244a;
        cqVar = bkVar.ao;
        if (cqVar != null) {
            bkVar3 = this.f1245a.f1244a;
            cqVar2 = bkVar3.ao;
            cqVar2.a(this.b);
        }
        if (this.c) {
            bkVar2 = this.f1245a.f1244a;
            crVar = bkVar2.z;
            crVar.b(this.d);
        }
    }
}
