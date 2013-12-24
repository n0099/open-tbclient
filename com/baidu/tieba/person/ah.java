package com.baidu.tieba.person;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {
    final /* synthetic */ com.baidu.tieba.model.bl a;
    final /* synthetic */ af b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar, com.baidu.tieba.model.bl blVar) {
        this.b = afVar;
        this.a = blVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a.a() == 2) {
            NewPbActivity.a(this.b.a, this.a.g(), null, "");
        } else if (this.a.i()) {
            NewPbActivity.b(this.b.a, this.a.g(), this.a.h(), "");
        } else {
            NewPbActivity.a(this.b.a, this.a.g(), this.a.h(), "");
        }
        if (this.b.b.a() != null && TiebaApplication.h().t()) {
            StatService.onEvent(this.b.a, "his_threads_item", "click", 1);
        }
    }
}
