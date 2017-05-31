package com.baidu.tieba.pb.pb.main;

import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gu implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ fx evi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gu(fx fxVar) {
        this.evi = fxVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.evi.aMj();
    }
}
