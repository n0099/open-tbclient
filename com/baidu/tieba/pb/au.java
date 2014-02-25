package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class au implements com.baidu.adp.widget.ListView.b {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        com.baidu.tieba.model.bb bbVar;
        cu cuVar;
        bbVar = this.a.w;
        if (!bbVar.b(true)) {
            cuVar = this.a.C;
            cuVar.u();
            return;
        }
        com.baidu.tieba.util.cb.a(this.a, "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
