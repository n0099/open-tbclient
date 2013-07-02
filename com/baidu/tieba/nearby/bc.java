package com.baidu.tieba.nearby;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements View.OnTouchListener {
    GestureDetector a;
    final /* synthetic */ NewNearbyActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(NewNearbyActivity newNearbyActivity) {
        this.b = newNearbyActivity;
        this.a = new GestureDetector(newNearbyActivity.b);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.a.onTouchEvent(motionEvent);
    }
}
