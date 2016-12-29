package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b fhP;
    private e fim;

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
        return this.fhP.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.fhP.onTouchEvent(motionEvent);
    }

    public b getDragController() {
        return this.fhP;
    }

    public void setDragController(b bVar) {
        this.fhP = bVar;
    }

    public void setDragObject(e eVar) {
        this.fim = eVar;
        invalidate();
    }

    public e getDragObject() {
        return this.fim;
    }

    public void bgy() {
        if (this.fim != null) {
            if (this.fim.aFH != null) {
                this.fim.aFH.recycle();
                this.fim.aFH = null;
            }
            this.fim = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fim != null && this.fhP.fhG) {
            this.fim.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bgy();
    }
}
