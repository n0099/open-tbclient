package com.baidu.tieba.pb;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class au implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2057a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(NewPbActivity newPbActivity) {
        this.f2057a = newPbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        com.baidu.tieba.model.bl blVar;
        bt btVar;
        blVar = this.f2057a.o;
        if (!blVar.b(true)) {
            btVar = this.f2057a.u;
            btVar.B();
        } else if (TiebaApplication.g().s()) {
            StatService.onEvent(this.f2057a, "pb_pulldown", "pbclick", 1);
        }
    }
}
