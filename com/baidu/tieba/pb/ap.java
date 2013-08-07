package com.baidu.tieba.pb;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ap implements com.baidu.adp.widget.ListView.r {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1455a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(NewPbActivity newPbActivity) {
        this.f1455a = newPbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.r
    public void a() {
        com.baidu.tieba.model.bc bcVar;
        bn bnVar;
        bcVar = this.f1455a.j;
        if (bcVar.a(false)) {
            bnVar = this.f1455a.p;
            bnVar.o();
            if (TiebaApplication.f().t()) {
                StatService.onEvent(this.f1455a, "pb_more", "pbclick", 1);
            }
        }
    }
}
