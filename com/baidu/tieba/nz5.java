package com.baidu.tieba;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.widget.ListAdapter;
/* loaded from: classes7.dex */
public interface nz5 {
    void a();

    void b(Canvas canvas);

    void onDraw(Canvas canvas);

    boolean onInterceptTouchEvent(MotionEvent motionEvent);

    void onMeasure(int i, int i2);

    void onSizeChanged(int i, int i2, int i3, int i4);

    boolean onTouchEvent(MotionEvent motionEvent);

    void requestLayout();

    void setAdapter(ListAdapter listAdapter);
}
