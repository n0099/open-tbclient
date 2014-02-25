package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
class au implements View.OnClickListener {
    final /* synthetic */ as a;
    private final /* synthetic */ com.baidu.tieba.model.ba b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar, com.baidu.tieba.model.ba baVar) {
        this.a = asVar;
        this.b = baVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b.a() == 2) {
            NewPbActivity.a(this.a.a, this.b.g(), (String) null, "");
        } else if (this.b.i()) {
            NewPbActivity.b(this.a.a, this.b.g(), this.b.h(), "");
        } else {
            NewPbActivity.a(this.a.a, this.b.g(), this.b.h(), "");
        }
        if (this.a.b.a() != null) {
            com.baidu.tieba.util.cb.a(this.a.a, "his_threads_item", "click", 1, new Object[0]);
        }
    }
}
