package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b kUF;
    private a kUk;

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
        return this.kUk.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.kUk.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.kUk;
    }

    public void setDragController(a aVar) {
        this.kUk = aVar;
    }

    public void setDragObject(b bVar) {
        this.kUF = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.kUF;
    }

    public void cWT() {
        if (this.kUF != null) {
            if (this.kUF.bm != null) {
                this.kUF.bm.recycle();
                this.kUF.bm = null;
            }
            this.kUF = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.kUF != null && this.kUk.kUb) {
            this.kUF.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cWT();
    }
}
