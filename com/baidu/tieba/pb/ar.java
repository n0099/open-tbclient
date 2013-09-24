package com.baidu.tieba.pb;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ar implements com.baidu.adp.widget.ListView.r {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1537a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(NewPbActivity newPbActivity) {
        this.f1537a = newPbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.r
    public void a() {
        com.baidu.tieba.model.bd bdVar;
        br brVar;
        bdVar = this.f1537a.n;
        if (bdVar.a(false)) {
            brVar = this.f1537a.t;
            brVar.z();
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this.f1537a, "pb_more", "pbclick", 1);
            }
        }
    }
}
