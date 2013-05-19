package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
class af implements View.OnClickListener {
    final /* synthetic */ ad a;
    private final /* synthetic */ com.baidu.tieba.c.ap b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ad adVar, com.baidu.tieba.c.ap apVar) {
        this.a = adVar;
        this.b = apVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b.a() == 2) {
            NewPbActivity.a(this.a.a, this.b.g(), null, "");
        } else if (this.b.i()) {
            NewPbActivity.b(this.a.a, this.b.g(), this.b.h(), "");
        } else {
            NewPbActivity.a(this.a.a, this.b.g(), this.b.h(), "");
        }
    }
}
