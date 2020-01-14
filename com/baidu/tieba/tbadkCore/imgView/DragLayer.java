package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b khH;
    private a khm;

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
        return this.khm.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.khm.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.khm;
    }

    public void setDragController(a aVar) {
        this.khm = aVar;
    }

    public void setDragObject(b bVar) {
        this.khH = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.khH;
    }

    public void cKc() {
        if (this.khH != null) {
            if (this.khH.bm != null) {
                this.khH.bm.recycle();
                this.khH.bm = null;
            }
            this.khH = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.khH != null && this.khm.khd) {
            this.khH.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cKc();
    }
}
