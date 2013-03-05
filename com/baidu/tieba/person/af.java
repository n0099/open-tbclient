package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tieba.pb.PbActivity;
import com.baidu.tieba.pb.SubPbActivity;
/* loaded from: classes.dex */
class af implements View.OnClickListener {
    final /* synthetic */ ad a;
    private final /* synthetic */ com.baidu.tieba.b.l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ad adVar, com.baidu.tieba.b.l lVar) {
        this.a = adVar;
        this.b = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b.a() == 2) {
            PbActivity.a(this.a.a, this.b.g(), "");
        } else if (this.b.i()) {
            SubPbActivity.a(this.a.a, this.b.g(), this.b.h(), true);
        } else {
            PbActivity.a(this.a.a, this.b.g(), this.b.h(), "");
        }
    }
}
