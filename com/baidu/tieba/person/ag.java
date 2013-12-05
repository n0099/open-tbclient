package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class ag implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.model.bl f2305a;
    final /* synthetic */ af b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar, com.baidu.tieba.model.bl blVar) {
        this.b = afVar;
        this.f2305a = blVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f2305a.f() != null) {
            FrsActivity.a(this.b.f2304a, this.f2305a.f(), (String) null);
        }
    }
}
