package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
final class bs implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.a(300);
    }
}
