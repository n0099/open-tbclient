package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
final class cc implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PersonChangeActivity.m(this.a);
    }
}
