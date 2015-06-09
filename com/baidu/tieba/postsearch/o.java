package com.baidu.tieba.postsearch;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnTouchListener {
    final /* synthetic */ l bXZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.bXZ = lVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        PostSearchActivity postSearchActivity;
        postSearchActivity = this.bXZ.bXN;
        postSearchActivity.afR();
        return false;
    }
}
