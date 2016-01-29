package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnFocusChangeListener {
    final /* synthetic */ PersonChangeActivity cYF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(PersonChangeActivity personChangeActivity) {
        this.cYF = personChangeActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            this.cYF.atE();
        }
    }
}
