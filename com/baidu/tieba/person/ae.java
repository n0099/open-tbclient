package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    final /* synthetic */ ad a;
    private final /* synthetic */ com.baidu.tieba.b.l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar, com.baidu.tieba.b.l lVar) {
        this.a = adVar;
        this.b = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b.f() != null) {
            FrsActivity.a(this.a.a, this.b.f(), (String) null);
        }
    }
}
