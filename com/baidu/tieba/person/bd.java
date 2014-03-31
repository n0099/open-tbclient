package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
final class bd implements View.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PersonChangeActivity.n(this.a);
    }
}
