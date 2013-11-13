package com.baidu.tieba.pb;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ba implements com.baidu.adp.widget.ListView.r {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2085a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(NewPbActivity newPbActivity) {
        this.f2085a = newPbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.r
    public void a() {
        com.baidu.tieba.model.bm bmVar;
        cp cpVar;
        bmVar = this.f2085a.s;
        if (bmVar.a(false)) {
            cpVar = this.f2085a.y;
            cpVar.q();
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this.f2085a, "pb_more", "pbclick", 1);
            }
        }
    }
}
