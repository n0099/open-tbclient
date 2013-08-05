package com.baidu.tieba.pb;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ao implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1456a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(NewPbActivity newPbActivity) {
        this.f1456a = newPbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        com.baidu.tieba.model.bc bcVar;
        bn bnVar;
        bcVar = this.f1456a.j;
        if (!bcVar.b(true)) {
            bnVar = this.f1456a.p;
            bnVar.q();
        } else if (TiebaApplication.f().t()) {
            StatService.onEvent(this.f1456a, "pb_pulldown", "pbclick", 1);
        }
    }
}
