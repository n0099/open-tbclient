package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ek implements com.baidu.tieba.editortool.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.editortool.h f2167a;
    final /* synthetic */ eb b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ek(eb ebVar, com.baidu.tieba.editortool.h hVar) {
        this.b = ebVar;
        this.f2167a = hVar;
    }

    @Override // com.baidu.tieba.editortool.h
    public void a(int i, Object obj) {
        if (i == 0) {
            this.f2167a.a(26, obj);
        } else if (i == 10) {
            this.f2167a.a(27, obj);
        } else if (i == 34) {
            this.b.q.setEnabled(true);
        } else if (i == 33) {
            this.b.q.setEnabled(false);
        } else {
            this.f2167a.a(i, obj);
        }
    }
}
