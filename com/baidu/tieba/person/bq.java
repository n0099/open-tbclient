package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
final class bq implements View.OnFocusChangeListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        if (!z) {
            this.a.a();
        }
    }
}
