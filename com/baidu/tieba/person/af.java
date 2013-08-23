package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class af implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ae f1601a;
    private final /* synthetic */ com.baidu.tieba.model.ba b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar, com.baidu.tieba.model.ba baVar) {
        this.f1601a = aeVar;
        this.b = baVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b.f() != null) {
            FrsActivity.a(this.f1601a.f1600a, this.b.f(), (String) null);
        }
    }
}
