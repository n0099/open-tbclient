package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ea implements com.baidu.tieba.editortool.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.editortool.h f2157a;
    final /* synthetic */ dy b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ea(dy dyVar, com.baidu.tieba.editortool.h hVar) {
        this.b = dyVar;
        this.f2157a = hVar;
    }

    @Override // com.baidu.tieba.editortool.h
    public void a(int i, Object obj) {
        if (i == 0) {
            this.f2157a.a(26, obj);
        } else if (i == 10) {
            this.f2157a.a(27, obj);
        } else if (i == 33) {
            this.b.I.e();
            this.f2157a.a(33, obj);
        } else if (i == 34) {
            this.b.q.setEnabled(true);
        } else {
            this.f2157a.a(i, obj);
        }
    }
}
