package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class az implements com.baidu.adp.widget.ListView.b {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        com.baidu.tieba.model.bm bmVar;
        cr crVar;
        bmVar = this.a.u;
        if (!bmVar.b(true)) {
            crVar = this.a.A;
            crVar.t();
            return;
        }
        com.baidu.tieba.util.by.a(this.a, "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
