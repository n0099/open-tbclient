package com.baidu.tieba.postsearch;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnTouchListener {
    final /* synthetic */ k cDX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.cDX = kVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        PostSearchActivity postSearchActivity;
        postSearchActivity = this.cDX.cDL;
        postSearchActivity.aoe();
        return false;
    }
}
