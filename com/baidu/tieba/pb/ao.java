package com.baidu.tieba.pb;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ao implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1491a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(NewPbActivity newPbActivity) {
        this.f1491a = newPbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        com.baidu.tieba.model.bb bbVar;
        bo boVar;
        bbVar = this.f1491a.k;
        if (!bbVar.b(true)) {
            boVar = this.f1491a.q;
            boVar.r();
        } else if (TiebaApplication.g().u()) {
            StatService.onEvent(this.f1491a, "pb_pulldown", "pbclick", 1);
        }
    }
}
