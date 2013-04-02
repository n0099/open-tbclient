package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class aj implements View.OnClickListener {
    final /* synthetic */ ai a;
    private final /* synthetic */ com.baidu.tieba.b.m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar, com.baidu.tieba.b.m mVar) {
        this.a = aiVar;
        this.b = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b.f() != null) {
            FrsActivity.a(this.a.a, this.b.f(), (String) null);
        }
    }
}
