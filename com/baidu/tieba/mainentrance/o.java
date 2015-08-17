package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnTouchListener {
    final /* synthetic */ SquareSearchActivity bQZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(SquareSearchActivity squareSearchActivity) {
        this.bQZ = squareSearchActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ScrollView scrollView;
        Activity pageActivity = this.bQZ.getPageContext().getPageActivity();
        scrollView = this.bQZ.bQF;
        com.baidu.adp.lib.util.k.c(pageActivity, scrollView);
        return false;
    }
}
