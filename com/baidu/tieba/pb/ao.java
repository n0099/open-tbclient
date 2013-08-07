package com.baidu.tieba.pb;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ao implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1454a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(NewPbActivity newPbActivity) {
        this.f1454a = newPbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        com.baidu.tieba.model.bc bcVar;
        bn bnVar;
        bcVar = this.f1454a.j;
        if (!bcVar.b(true)) {
            bnVar = this.f1454a.p;
            bnVar.q();
        } else if (TiebaApplication.f().t()) {
            StatService.onEvent(this.f1454a, "pb_pulldown", "pbclick", 1);
        }
    }
}
