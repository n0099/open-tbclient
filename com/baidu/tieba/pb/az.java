package com.baidu.tieba.pb;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class az implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2083a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(NewPbActivity newPbActivity) {
        this.f2083a = newPbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        com.baidu.tieba.model.bm bmVar;
        cp cpVar;
        bmVar = this.f2083a.s;
        if (!bmVar.b(true)) {
            cpVar = this.f2083a.y;
            cpVar.s();
        } else if (TiebaApplication.g().s()) {
            StatService.onEvent(this.f2083a, "pb_pulldown", "pbclick", 1);
        }
    }
}
