package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class an implements View.OnClickListener {
    final /* synthetic */ com.baidu.tieba.model.bl a;
    final /* synthetic */ am b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar, com.baidu.tieba.model.bl blVar) {
        this.b = amVar;
        this.a = blVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a.f() != null) {
            FrsActivity.a(this.b.a, this.a.f(), (String) null);
        }
    }
}
