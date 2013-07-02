package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class af implements View.OnClickListener {
    final /* synthetic */ ae a;
    private final /* synthetic */ com.baidu.tieba.model.as b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar, com.baidu.tieba.model.as asVar) {
        this.a = aeVar;
        this.b = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b.f() != null) {
            FrsActivity.a(this.a.a, this.b.f(), (String) null);
        }
    }
}
