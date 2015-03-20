package com.baidu.tieba.view;

import android.view.GestureDetector;
import android.view.MotionEvent;
/* loaded from: classes.dex */
class c extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ CustomScrollView ctk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(CustomScrollView customScrollView) {
        this.ctk = customScrollView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return Math.abs(f2) > Math.abs(f);
    }
}
