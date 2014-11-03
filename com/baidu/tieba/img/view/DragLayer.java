package com.baidu.tieba.img.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private e blO;
    private a blp;

    public DragLayer(Context context) {
        super(context);
        init();
    }

    public DragLayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public DragLayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.blp.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.blp.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.blp;
    }

    public void setDragController(a aVar) {
        this.blp = aVar;
    }

    public void setDragObject(e eVar) {
        this.blO = eVar;
        invalidate();
    }

    public e getDragObject() {
        return this.blO;
    }

    public void Sn() {
        if (this.blO != null) {
            if (this.blO.blb != null) {
                this.blO.blb.recycle();
                this.blO.blb = null;
            }
            this.blO = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.blO != null && this.blp.blf) {
            this.blO.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Sn();
    }
}
