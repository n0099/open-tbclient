package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dk implements View.OnFocusChangeListener {
    final /* synthetic */ cr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(cr crVar) {
        this.a = crVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        NewPbActivity newPbActivity;
        if (!z) {
            newPbActivity = this.a.g;
            com.baidu.adp.lib.g.g.a(newPbActivity, view);
        }
    }
}
