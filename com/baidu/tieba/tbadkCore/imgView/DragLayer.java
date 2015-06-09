package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private e ctA;
    private a ctd;

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
        return this.ctd.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.ctd.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.ctd;
    }

    public void setDragController(a aVar) {
        this.ctd = aVar;
    }

    public void setDragObject(e eVar) {
        this.ctA = eVar;
        invalidate();
    }

    public e getDragObject() {
        return this.ctA;
    }

    public void apa() {
        if (this.ctA != null) {
            if (this.ctA.ate != null) {
                this.ctA.ate.recycle();
                this.ctA.ate = null;
            }
            this.ctA = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.ctA != null && this.ctd.csT) {
            this.ctA.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        apa();
    }
}
