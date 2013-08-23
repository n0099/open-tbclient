package com.baidu.tieba.pb;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ap implements com.baidu.adp.widget.ListView.r {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1492a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(NewPbActivity newPbActivity) {
        this.f1492a = newPbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.r
    public void a() {
        com.baidu.tieba.model.bb bbVar;
        bo boVar;
        bbVar = this.f1492a.k;
        if (bbVar.a(false)) {
            boVar = this.f1492a.q;
            boVar.p();
            if (TiebaApplication.g().u()) {
                StatService.onEvent(this.f1492a, "pb_more", "pbclick", 1);
            }
        }
    }
}
