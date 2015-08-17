package com.baidu.tieba.postsearch;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnTouchListener {
    final /* synthetic */ k coS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(k kVar) {
        this.coS = kVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        PostSearchActivity postSearchActivity;
        postSearchActivity = this.coS.coG;
        postSearchActivity.ahP();
        return false;
    }
}
