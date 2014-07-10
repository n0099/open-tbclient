package com.baidu.tieba.square;

import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnTouchListener {
    final /* synthetic */ q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar) {
        this.a = qVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ViewPager viewPager;
        viewPager = this.a.c;
        if (view == viewPager) {
            if (motionEvent.getAction() == 0) {
                this.a.b();
                return false;
            } else if (motionEvent.getAction() == 1) {
                this.a.a();
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
