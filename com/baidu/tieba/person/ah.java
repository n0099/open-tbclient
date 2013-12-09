package com.baidu.tieba.person;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.model.bl f2307a;
    final /* synthetic */ af b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar, com.baidu.tieba.model.bl blVar) {
        this.b = afVar;
        this.f2307a = blVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f2307a.a() == 2) {
            NewPbActivity.a(this.b.f2305a, this.f2307a.g(), null, "");
        } else if (this.f2307a.i()) {
            NewPbActivity.b(this.b.f2305a, this.f2307a.g(), this.f2307a.h(), "");
        } else {
            NewPbActivity.a(this.b.f2305a, this.f2307a.g(), this.f2307a.h(), "");
        }
        if (this.b.b.a() != null && TiebaApplication.h().t()) {
            StatService.onEvent(this.b.f2305a, "his_threads_item", "click", 1);
        }
    }
}
