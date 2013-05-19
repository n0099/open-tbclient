package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements View.OnFocusChangeListener {
    final /* synthetic */ bl a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(bl blVar) {
        this.a = blVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        com.baidu.tieba.e eVar;
        if (!z) {
            eVar = this.a.b;
            com.baidu.tieba.d.ag.a(eVar, view);
        }
    }
}
