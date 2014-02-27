package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class dg implements com.baidu.tieba.editortool.aa {
    final /* synthetic */ cu a;
    private final /* synthetic */ com.baidu.tieba.editortool.aa b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dg(cu cuVar, com.baidu.tieba.editortool.aa aaVar) {
        this.a = cuVar;
        this.b = aaVar;
    }

    @Override // com.baidu.tieba.editortool.aa
    public final void a(int i, Object obj) {
        NewPbActivity newPbActivity;
        if (i == 35 && !this.a.f.h() && !this.a.f.i()) {
            newPbActivity = this.a.h;
            com.baidu.tieba.util.cb.a(newPbActivity, "pb_reply", "pbclick", 1, new Object[0]);
        }
        this.b.a(i, obj);
    }
}
