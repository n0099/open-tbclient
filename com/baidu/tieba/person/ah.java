package com.baidu.tieba.person;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.model.bl f2213a;
    final /* synthetic */ af b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar, com.baidu.tieba.model.bl blVar) {
        this.b = afVar;
        this.f2213a = blVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f2213a.a() == 2) {
            NewPbActivity.a(this.b.f2211a, this.f2213a.g(), null, "");
        } else if (this.f2213a.i()) {
            NewPbActivity.b(this.b.f2211a, this.f2213a.g(), this.f2213a.h(), "");
        } else {
            NewPbActivity.a(this.b.f2211a, this.f2213a.g(), this.f2213a.h(), "");
        }
        if (this.b.b.a() != null && TiebaApplication.g().s()) {
            StatService.onEvent(this.b.f2211a, "his_threads_item", "click", 1);
        }
    }
}
