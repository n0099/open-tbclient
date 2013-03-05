package com.baidu.tieba.pb;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements View.OnTouchListener {
    final /* synthetic */ PbActivity a;
    private final /* synthetic */ GestureDetector b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(PbActivity pbActivity, GestureDetector gestureDetector) {
        this.a = pbActivity;
        this.b = gestureDetector;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.b.onTouchEvent(motionEvent);
    }
}
