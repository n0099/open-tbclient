package com.baidu.tieba.pb;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ap implements com.baidu.adp.widget.ListView.r {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.r
    public void a() {
        com.baidu.tieba.c.au auVar;
        bl blVar;
        auVar = this.a.i;
        if (auVar.a(false)) {
            blVar = this.a.o;
            blVar.p();
            if (TiebaApplication.d().n()) {
                StatService.onEvent(this.a, "pb_more", "pbclick", 1);
            }
        }
    }
}
