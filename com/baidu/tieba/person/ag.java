package com.baidu.tieba.person;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
class ag implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ae f1564a;
    private final /* synthetic */ com.baidu.tieba.model.bb b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar, com.baidu.tieba.model.bb bbVar) {
        this.f1564a = aeVar;
        this.b = bbVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b.a() == 2) {
            NewPbActivity.a(this.f1564a.f1562a, this.b.g(), null, "");
        } else if (this.b.i()) {
            NewPbActivity.b(this.f1564a.f1562a, this.b.g(), this.b.h(), "");
        } else {
            NewPbActivity.a(this.f1564a.f1562a, this.b.g(), this.b.h(), "");
        }
        if (this.f1564a.b.a() != null && TiebaApplication.f().t()) {
            StatService.onEvent(this.f1564a.f1562a, "his_threads_item", "click", 1);
        }
    }
}
