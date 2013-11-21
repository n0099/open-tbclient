package com.baidu.tieba.pb;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class az implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2066a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(NewPbActivity newPbActivity) {
        this.f2066a = newPbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        com.baidu.tieba.model.bm bmVar;
        cr crVar;
        bmVar = this.f2066a.s;
        if (!bmVar.b(true)) {
            crVar = this.f2066a.y;
            crVar.s();
        } else if (TiebaApplication.g().s()) {
            StatService.onEvent(this.f2066a, "pb_pulldown", "pbclick", 1);
        }
    }
}
