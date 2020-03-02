package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b kiL;
    private a kiq;

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
        return this.kiq.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.kiq.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.kiq;
    }

    public void setDragController(a aVar) {
        this.kiq = aVar;
    }

    public void setDragObject(b bVar) {
        this.kiL = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.kiL;
    }

    public void cLC() {
        if (this.kiL != null) {
            if (this.kiL.bm != null) {
                this.kiL.bm.recycle();
                this.kiL.bm = null;
            }
            this.kiL = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.kiL != null && this.kiq.kih) {
            this.kiL.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cLC();
    }
}
