package com.baidu.tieba.view;

import android.view.GestureDetector;
import android.view.MotionEvent;
/* loaded from: classes.dex */
class j extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ CustomScrollView ceQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(CustomScrollView customScrollView) {
        this.ceQ = customScrollView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return Math.abs(f2) > Math.abs(f);
    }
}
