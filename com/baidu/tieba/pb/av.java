package com.baidu.tieba.pb;
/* loaded from: classes.dex */
final class av implements com.baidu.adp.widget.ListView.r {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.r
    public final void b() {
        com.baidu.tieba.model.bb bbVar;
        cu cuVar;
        bbVar = this.a.w;
        if (bbVar.a(false)) {
            cuVar = this.a.C;
            cuVar.q();
            com.baidu.tieba.util.cb.a(this.a, "pb_more", "pbclick", 1, new Object[0]);
        }
    }
}
