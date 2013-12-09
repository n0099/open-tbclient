package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ec implements com.baidu.tieba.editortool.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.editortool.h f2250a;
    final /* synthetic */ ea b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ec(ea eaVar, com.baidu.tieba.editortool.h hVar) {
        this.b = eaVar;
        this.f2250a = hVar;
    }

    @Override // com.baidu.tieba.editortool.h
    public void a(int i, Object obj) {
        if (i == 0) {
            this.f2250a.a(26, obj);
        } else if (i == 10) {
            this.f2250a.a(27, obj);
        } else if (i == 33) {
            this.b.I.e();
            this.f2250a.a(33, obj);
        } else if (i == 34) {
            this.b.q.setEnabled(true);
        } else {
            this.f2250a.a(i, obj);
        }
    }
}
