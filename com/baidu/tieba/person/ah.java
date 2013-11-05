package com.baidu.tieba.person;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.model.bk f2171a;
    final /* synthetic */ af b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar, com.baidu.tieba.model.bk bkVar) {
        this.b = afVar;
        this.f2171a = bkVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f2171a.a() == 2) {
            NewPbActivity.a(this.b.f2169a, this.f2171a.g(), null, "");
        } else if (this.f2171a.i()) {
            NewPbActivity.b(this.b.f2169a, this.f2171a.g(), this.f2171a.h(), "");
        } else {
            NewPbActivity.a(this.b.f2169a, this.f2171a.g(), this.f2171a.h(), "");
        }
        if (this.b.b.a() != null && TiebaApplication.g().s()) {
            StatService.onEvent(this.b.f2169a, "his_threads_item", "click", 1);
        }
    }
}
