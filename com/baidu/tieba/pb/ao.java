package com.baidu.tieba.pb;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ao implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1206a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(NewPbActivity newPbActivity) {
        this.f1206a = newPbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        com.baidu.tieba.model.ax axVar;
        bk bkVar;
        axVar = this.f1206a.j;
        if (!axVar.b(true)) {
            bkVar = this.f1206a.p;
            bkVar.q();
        } else if (TiebaApplication.f().t()) {
            StatService.onEvent(this.f1206a, "pb_pulldown", "pbclick", 1);
        }
    }
}
