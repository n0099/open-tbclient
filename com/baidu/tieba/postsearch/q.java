package com.baidu.tieba.postsearch;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnTouchListener {
    final /* synthetic */ k cEi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(k kVar) {
        this.cEi = kVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        PostSearchActivity postSearchActivity;
        postSearchActivity = this.cEi.cDW;
        postSearchActivity.aoe();
        return false;
    }
}
