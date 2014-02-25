package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class at implements View.OnClickListener {
    final /* synthetic */ as a;
    private final /* synthetic */ com.baidu.tieba.model.ba b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar, com.baidu.tieba.model.ba baVar) {
        this.a = asVar;
        this.b = baVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b.f() != null) {
            FrsActivity.a(this.a.a, this.b.f(), null);
        }
    }
}
