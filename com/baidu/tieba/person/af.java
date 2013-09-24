package com.baidu.tieba.person;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
class af implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ad f1651a;
    private final /* synthetic */ com.baidu.tieba.model.bc b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ad adVar, com.baidu.tieba.model.bc bcVar) {
        this.f1651a = adVar;
        this.b = bcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b.a() == 2) {
            NewPbActivity.a(this.f1651a.f1649a, this.b.g(), null, "");
        } else if (this.b.i()) {
            NewPbActivity.b(this.f1651a.f1649a, this.b.g(), this.b.h(), "");
        } else {
            NewPbActivity.a(this.f1651a.f1649a, this.b.g(), this.b.h(), "");
        }
        if (this.f1651a.b.a() != null && TiebaApplication.g().s()) {
            StatService.onEvent(this.f1651a.f1649a, "his_threads_item", "click", 1);
        }
    }
}
