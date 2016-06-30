package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a eZc;
    private d eZy;

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
        return this.eZc.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.eZc.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.eZc;
    }

    public void setDragController(a aVar) {
        this.eZc = aVar;
    }

    public void setDragObject(d dVar) {
        this.eZy = dVar;
        invalidate();
    }

    public d getDragObject() {
        return this.eZy;
    }

    public void bcR() {
        if (this.eZy != null) {
            if (this.eZy.aCb != null) {
                this.eZy.aCb.recycle();
                this.eZy.aCb = null;
            }
            this.eZy = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.eZy != null && this.eZc.eYT) {
            this.eZy.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bcR();
    }
}
