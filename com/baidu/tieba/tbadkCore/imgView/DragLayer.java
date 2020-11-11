package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a mYM;
    private b mZi;

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
        return this.mYM.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mYM.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.mYM;
    }

    public void setDragController(a aVar) {
        this.mYM = aVar;
    }

    public void setDragObject(b bVar) {
        this.mZi = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.mZi;
    }

    public void dKA() {
        if (this.mZi != null) {
            if (this.mZi.bm != null) {
                this.mZi.bm.recycle();
                this.mZi.bm = null;
            }
            this.mZi = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mZi != null && this.mYM.mYD) {
            this.mZi.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dKA();
    }
}
