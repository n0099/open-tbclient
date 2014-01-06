package com.baidu.tieba.person;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
class ao implements View.OnClickListener {
    final /* synthetic */ com.baidu.tieba.model.bl a;
    final /* synthetic */ am b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(am amVar, com.baidu.tieba.model.bl blVar) {
        this.b = amVar;
        this.a = blVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a.a() == 2) {
            NewPbActivity.a(this.b.a, this.a.g(), (String) null, "");
        } else if (this.a.i()) {
            NewPbActivity.b(this.b.a, this.a.g(), this.a.h(), "");
        } else {
            NewPbActivity.a(this.b.a, this.a.g(), this.a.h(), "");
        }
        if (this.b.b.a() != null && TiebaApplication.g().s()) {
            StatService.onEvent(this.b.a, "his_threads_item", "click", 1);
        }
    }
}
