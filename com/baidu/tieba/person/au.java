package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class au implements View.OnClickListener {
    final /* synthetic */ as a;
    private final /* synthetic */ UserData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar, UserData userData) {
        this.a = asVar;
        this.b = userData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.a(this.b);
    }
}
