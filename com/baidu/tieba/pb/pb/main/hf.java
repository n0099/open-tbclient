package com.baidu.tieba.pb.pb.main;

import android.view.ViewTreeObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class hf implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ gg eEv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hf(gg ggVar) {
        this.eEv = ggVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.eEv.aQh();
    }
}
