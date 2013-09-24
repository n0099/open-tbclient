package com.baidu.tieba.pb;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class aq implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1536a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(NewPbActivity newPbActivity) {
        this.f1536a = newPbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        com.baidu.tieba.model.bd bdVar;
        br brVar;
        bdVar = this.f1536a.n;
        if (!bdVar.b(true)) {
            brVar = this.f1536a.t;
            brVar.B();
        } else if (TiebaApplication.g().s()) {
            StatService.onEvent(this.f1536a, "pb_pulldown", "pbclick", 1);
        }
    }
}
