package com.baidu.tieba;

import android.graphics.Canvas;
import android.view.MotionEvent;
/* loaded from: classes7.dex */
public interface xn {
    boolean a(MotionEvent motionEvent);

    void b(int i, int i2);

    void c(int i);

    boolean dispatchTouchEvent(MotionEvent motionEvent);

    void draw(Canvas canvas);

    boolean e(MotionEvent motionEvent);
}
