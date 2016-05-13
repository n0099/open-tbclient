package com.baidu.tieba.postsearch;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnTouchListener {
    final /* synthetic */ l dVl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.dVl = lVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        PostSearchActivity postSearchActivity;
        postSearchActivity = this.dVl.dUY;
        postSearchActivity.aKB();
        return false;
    }
}
