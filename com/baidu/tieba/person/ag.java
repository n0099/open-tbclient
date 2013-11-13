package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class ag implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.model.bl f2212a;
    final /* synthetic */ af b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar, com.baidu.tieba.model.bl blVar) {
        this.b = afVar;
        this.f2212a = blVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f2212a.f() != null) {
            FrsActivity.a(this.b.f2211a, this.f2212a.f(), (String) null);
        }
    }
}
