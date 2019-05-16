package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b jaP;
    private a jau;

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
        return this.jau.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.jau.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.jau;
    }

    public void setDragController(a aVar) {
        this.jau = aVar;
    }

    public void setDragObject(b bVar) {
        this.jaP = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.jaP;
    }

    public void cmV() {
        if (this.jaP != null) {
            if (this.jaP.cDg != null) {
                this.jaP.cDg.recycle();
                this.jaP.cDg = null;
            }
            this.jaP = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.jaP != null && this.jau.jal) {
            this.jaP.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cmV();
    }
}
