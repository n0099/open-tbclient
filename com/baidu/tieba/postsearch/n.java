package com.baidu.tieba.postsearch;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnTouchListener {
    final /* synthetic */ k den;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.den = kVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        PostSearchActivity postSearchActivity;
        postSearchActivity = this.den.deb;
        postSearchActivity.aus();
        return false;
    }
}
