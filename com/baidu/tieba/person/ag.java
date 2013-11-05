package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class ag implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.model.bk f2170a;
    final /* synthetic */ af b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar, com.baidu.tieba.model.bk bkVar) {
        this.b = afVar;
        this.f2170a = bkVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f2170a.f() != null) {
            FrsActivity.a(this.b.f2169a, this.f2170a.f(), (String) null);
        }
    }
}
