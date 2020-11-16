package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a mZE;
    private b naa;

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
        return this.mZE.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mZE.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.mZE;
    }

    public void setDragController(a aVar) {
        this.mZE = aVar;
    }

    public void setDragObject(b bVar) {
        this.naa = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.naa;
    }

    public void dKr() {
        if (this.naa != null) {
            if (this.naa.bm != null) {
                this.naa.bm.recycle();
                this.naa.bm = null;
            }
            this.naa = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.naa != null && this.mZE.mZv) {
            this.naa.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dKr();
    }
}
