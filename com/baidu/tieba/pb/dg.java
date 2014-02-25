package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dg implements com.baidu.tieba.editortool.z {
    final /* synthetic */ cu a;
    private final /* synthetic */ com.baidu.tieba.editortool.z b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dg(cu cuVar, com.baidu.tieba.editortool.z zVar) {
        this.a = cuVar;
        this.b = zVar;
    }

    @Override // com.baidu.tieba.editortool.z
    public void a(int i, Object obj) {
        NewPbActivity newPbActivity;
        if (i == 35 && !this.a.f.h() && !this.a.f.j()) {
            newPbActivity = this.a.h;
            com.baidu.tieba.util.cb.a(newPbActivity, "pb_reply", "pbclick", 1, new Object[0]);
        }
        this.b.a(i, obj);
    }
}
