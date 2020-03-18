package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a kke;
    private b kkz;

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
        return this.kke.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.kke.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.kke;
    }

    public void setDragController(a aVar) {
        this.kke = aVar;
    }

    public void setDragObject(b bVar) {
        this.kkz = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.kkz;
    }

    public void cLX() {
        if (this.kkz != null) {
            if (this.kkz.bm != null) {
                this.kkz.bm.recycle();
                this.kkz.bm = null;
            }
            this.kkz = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.kkz != null && this.kke.kjV) {
            this.kkz.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cLX();
    }
}
