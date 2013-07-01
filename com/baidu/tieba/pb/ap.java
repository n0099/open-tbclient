package com.baidu.tieba.pb;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ap implements com.baidu.adp.widget.ListView.r {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1207a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(NewPbActivity newPbActivity) {
        this.f1207a = newPbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.r
    public void a() {
        com.baidu.tieba.model.ax axVar;
        bk bkVar;
        axVar = this.f1207a.j;
        if (axVar.a(false)) {
            bkVar = this.f1207a.p;
            bkVar.o();
            if (TiebaApplication.f().t()) {
                StatService.onEvent(this.f1207a, "pb_more", "pbclick", 1);
            }
        }
    }
}
