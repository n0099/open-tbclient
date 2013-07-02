package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements View.OnFocusChangeListener {
    final /* synthetic */ bk a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(bk bkVar) {
        this.a = bkVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        com.baidu.tieba.g gVar;
        if (!z) {
            gVar = this.a.b;
            com.baidu.tieba.util.ab.a(gVar, view);
        }
    }
}
