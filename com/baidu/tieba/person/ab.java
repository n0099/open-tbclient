package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnFocusChangeListener {
    final /* synthetic */ PersonChangeActivity bCA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PersonChangeActivity personChangeActivity) {
        this.bCA = personChangeActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            this.bCA.ZT();
        }
    }
}
