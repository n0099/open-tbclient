package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private d euI;
    private a eum;

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
        return this.eum.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.eum.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.eum;
    }

    public void setDragController(a aVar) {
        this.eum = aVar;
    }

    public void setDragObject(d dVar) {
        this.euI = dVar;
        invalidate();
    }

    public d getDragObject() {
        return this.euI;
    }

    public void aUD() {
        if (this.euI != null) {
            if (this.euI.aBB != null) {
                this.euI.aBB.recycle();
                this.euI.aBB = null;
            }
            this.euI = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.euI != null && this.eum.eud) {
            this.euI.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aUD();
    }
}
