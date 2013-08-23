package com.baidu.tieba.person;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
class ag implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ae f1602a;
    private final /* synthetic */ com.baidu.tieba.model.ba b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar, com.baidu.tieba.model.ba baVar) {
        this.f1602a = aeVar;
        this.b = baVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b.a() == 2) {
            NewPbActivity.a(this.f1602a.f1600a, this.b.g(), null, "");
        } else if (this.b.i()) {
            NewPbActivity.b(this.f1602a.f1600a, this.b.g(), this.b.h(), "");
        } else {
            NewPbActivity.a(this.f1602a.f1600a, this.b.g(), this.b.h(), "");
        }
        if (this.f1602a.b.a() != null && TiebaApplication.g().u()) {
            StatService.onEvent(this.f1602a.f1600a, "his_threads_item", "click", 1);
        }
    }
}
