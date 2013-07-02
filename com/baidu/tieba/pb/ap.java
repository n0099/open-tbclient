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
        com.baidu.tieba.model.ax axVar;
        bk bkVar;
        axVar = this.a.j;
        if (axVar.a(false)) {
            bkVar = this.a.p;
            bkVar.o();
            if (TiebaApplication.f().t()) {
                StatService.onEvent(this.a, "pb_more", "pbclick", 1);
            }
        }
    }
}
