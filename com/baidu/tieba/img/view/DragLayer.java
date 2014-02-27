package com.baidu.tieba.img.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a a;
    private e b;

    public DragLayer(Context context) {
        super(context);
    }

    public DragLayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public DragLayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.a.a(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.a.b(motionEvent);
    }

    public a getDragController() {
        return this.a;
    }

    public void setDragController(a aVar) {
        this.a = aVar;
    }

    public void setDragObject(e eVar) {
        this.b = eVar;
        invalidate();
    }

    public e getDragObject() {
        return this.b;
    }

    public final void a() {
        if (this.b != null) {
            if (this.b.b != null) {
                this.b.b.recycle();
                this.b.b = null;
            }
            this.b = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.b != null && this.a.a) {
            this.b.a(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }
}
