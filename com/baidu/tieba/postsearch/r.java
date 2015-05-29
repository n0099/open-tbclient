package com.baidu.tieba.postsearch;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnTouchListener {
    final /* synthetic */ l bXY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar) {
        this.bXY = lVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        PostSearchActivity postSearchActivity;
        postSearchActivity = this.bXY.bXM;
        postSearchActivity.afQ();
        return false;
    }
}
