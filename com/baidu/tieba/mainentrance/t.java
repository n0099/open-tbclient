package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnTouchListener {
    final /* synthetic */ SquareSearchActivity bWd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(SquareSearchActivity squareSearchActivity) {
        this.bWd = squareSearchActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ScrollView scrollView;
        Activity pageActivity = this.bWd.getPageContext().getPageActivity();
        scrollView = this.bWd.bVI;
        com.baidu.adp.lib.util.k.c(pageActivity, scrollView);
        return false;
    }
}
