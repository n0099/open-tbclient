package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
final class ar implements View.OnFocusChangeListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        if (!z) {
            this.a.a();
        }
    }
}
