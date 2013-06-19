package com.baidu.tieba.pb;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ao implements com.baidu.adp.widget.ListView.b {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        com.baidu.tieba.c.ax axVar;
        axVar = this.a.j;
        if (axVar.b(true) && TiebaApplication.e().p()) {
            StatService.onEvent(this.a, "pb_pulldown", "pbclick", 1);
        }
    }
}
