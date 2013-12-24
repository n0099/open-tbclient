package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class ag implements View.OnClickListener {
    final /* synthetic */ com.baidu.tieba.model.bl a;
    final /* synthetic */ af b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar, com.baidu.tieba.model.bl blVar) {
        this.b = afVar;
        this.a = blVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a.f() != null) {
            FrsActivity.a(this.b.a, this.a.f(), (String) null);
        }
    }
}
