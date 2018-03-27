package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b hcE;
    private c hda;

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
        return this.hcE.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.hcE.onTouchEvent(motionEvent);
    }

    public b getDragController() {
        return this.hcE;
    }

    public void setDragController(b bVar) {
        this.hcE = bVar;
    }

    public void setDragObject(c cVar) {
        this.hda = cVar;
        invalidate();
    }

    public c getDragObject() {
        return this.hda;
    }

    public void bxy() {
        if (this.hda != null) {
            if (this.hda.bEt != null) {
                this.hda.bEt.recycle();
                this.hda.bEt = null;
            }
            this.hda = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.hda != null && this.hcE.hcu) {
            this.hda.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bxy();
    }
}
