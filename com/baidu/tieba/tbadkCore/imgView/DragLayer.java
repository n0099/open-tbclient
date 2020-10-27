package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a mSL;
    private b mTi;

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
        return this.mSL.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mSL.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.mSL;
    }

    public void setDragController(a aVar) {
        this.mSL = aVar;
    }

    public void setDragObject(b bVar) {
        this.mTi = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.mTi;
    }

    public void dHY() {
        if (this.mTi != null) {
            if (this.mTi.bm != null) {
                this.mTi.bm.recycle();
                this.mTi.bm = null;
            }
            this.mTi = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mTi != null && this.mSL.mSB) {
            this.mTi.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dHY();
    }
}
