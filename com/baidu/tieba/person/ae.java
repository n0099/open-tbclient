package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ad f1650a;
    private final /* synthetic */ com.baidu.tieba.model.bc b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar, com.baidu.tieba.model.bc bcVar) {
        this.f1650a = adVar;
        this.b = bcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b.f() != null) {
            FrsActivity.a(this.f1650a.f1649a, this.b.f(), (String) null);
        }
    }
}
