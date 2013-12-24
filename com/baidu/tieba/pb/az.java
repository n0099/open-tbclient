package com.baidu.tieba.pb;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
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
        bmVar = this.a.r;
        if (!bmVar.b(true)) {
            crVar = this.a.x;
            crVar.s();
        } else if (TiebaApplication.h().t()) {
            StatService.onEvent(this.a, "pb_pulldown", "pbclick", 1);
        }
    }
}
