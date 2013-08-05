package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class af implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ae f1565a;
    private final /* synthetic */ com.baidu.tieba.model.bb b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar, com.baidu.tieba.model.bb bbVar) {
        this.f1565a = aeVar;
        this.b = bbVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b.f() != null) {
            FrsActivity.a(this.f1565a.f1564a, this.b.f(), (String) null);
        }
    }
}
