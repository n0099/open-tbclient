package com.baidu.tieba.postsearch;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnTouchListener {
    final /* synthetic */ k cFE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(k kVar) {
        this.cFE = kVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        PostSearchActivity postSearchActivity;
        postSearchActivity = this.cFE.cFs;
        postSearchActivity.aoG();
        return false;
    }
}
