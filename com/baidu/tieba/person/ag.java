package com.baidu.tieba.person;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
class ag implements View.OnClickListener {
    final /* synthetic */ ae a;
    private final /* synthetic */ com.baidu.tieba.model.as b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar, com.baidu.tieba.model.as asVar) {
        this.a = aeVar;
        this.b = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b.a() == 2) {
            NewPbActivity.a(this.a.a, this.b.g(), null, "");
        } else if (this.b.i()) {
            NewPbActivity.b(this.a.a, this.b.g(), this.b.h(), "");
        } else {
            NewPbActivity.a(this.a.a, this.b.g(), this.b.h(), "");
        }
        if (this.a.b.a() != null && TiebaApplication.f().t()) {
            StatService.onEvent(this.a.a, "his_threads_item", "click", 1);
        }
    }
}
