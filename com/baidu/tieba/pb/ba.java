package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ba implements com.baidu.adp.widget.ListView.r {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.r
    public void a() {
        com.baidu.tieba.model.bm bmVar;
        cr crVar;
        bmVar = this.a.u;
        if (bmVar.a(false)) {
            crVar = this.a.A;
            crVar.r();
            com.baidu.tieba.util.by.a(this.a, "pb_more", "pbclick", 1, new Object[0]);
        }
    }
}
