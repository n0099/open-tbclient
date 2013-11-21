package com.baidu.tieba.pb;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ba implements com.baidu.adp.widget.ListView.r {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2068a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(NewPbActivity newPbActivity) {
        this.f2068a = newPbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.r
    public void a() {
        com.baidu.tieba.model.bm bmVar;
        cr crVar;
        bmVar = this.f2068a.s;
        if (bmVar.a(false)) {
            crVar = this.f2068a.y;
            crVar.q();
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this.f2068a, "pb_more", "pbclick", 1);
            }
        }
    }
}
