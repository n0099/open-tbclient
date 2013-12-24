package com.baidu.tieba.pb;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
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
        bmVar = this.a.r;
        if (bmVar.a(false)) {
            crVar = this.a.x;
            crVar.q();
            if (TiebaApplication.h().t()) {
                StatService.onEvent(this.a, "pb_more", "pbclick", 1);
            }
        }
    }
}
