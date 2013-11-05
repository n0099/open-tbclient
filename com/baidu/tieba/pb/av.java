package com.baidu.tieba.pb;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class av implements com.baidu.adp.widget.ListView.r {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2058a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(NewPbActivity newPbActivity) {
        this.f2058a = newPbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.r
    public void a() {
        com.baidu.tieba.model.bl blVar;
        bt btVar;
        blVar = this.f2058a.o;
        if (blVar.a(false)) {
            btVar = this.f2058a.u;
            btVar.z();
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this.f2058a, "pb_more", "pbclick", 1);
            }
        }
    }
}
