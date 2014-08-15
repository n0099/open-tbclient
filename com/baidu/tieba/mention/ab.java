package com.baidu.tieba.mention;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {
    final /* synthetic */ aa a;
    private final /* synthetic */ com.baidu.tieba.model.al b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar, com.baidu.tieba.model.al alVar) {
        this.a = aaVar;
        this.b = alVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        v vVar;
        vVar = this.a.a;
        vVar.a(this.b, true);
    }
}
