package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private c hkI;
    private b hkm;

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
        return this.hkm.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.hkm.onTouchEvent(motionEvent);
    }

    public b getDragController() {
        return this.hkm;
    }

    public void setDragController(b bVar) {
        this.hkm = bVar;
    }

    public void setDragObject(c cVar) {
        this.hkI = cVar;
        invalidate();
    }

    public c getDragObject() {
        return this.hkI;
    }

    public void bCN() {
        if (this.hkI != null) {
            if (this.hkI.bCi != null) {
                this.hkI.bCi.recycle();
                this.hkI.bCi = null;
            }
            this.hkI = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.hkI != null && this.hkm.hkd) {
            this.hkI.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bCN();
    }
}
