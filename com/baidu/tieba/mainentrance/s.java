package com.baidu.tieba.mainentrance;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnTouchListener {
    final /* synthetic */ SquareSearchActivity cLU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(SquareSearchActivity squareSearchActivity) {
        this.cLU = squareSearchActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ScrollView scrollView;
        Activity pageActivity = this.cLU.getPageContext().getPageActivity();
        scrollView = this.cLU.cLz;
        com.baidu.adp.lib.util.k.c(pageActivity, scrollView);
        return false;
    }
}
