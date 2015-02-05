package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a bZH;
    private e caf;

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
        return this.bZH.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.bZH.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.bZH;
    }

    public void setDragController(a aVar) {
        this.bZH = aVar;
    }

    public void setDragObject(e eVar) {
        this.caf = eVar;
        invalidate();
    }

    public e getDragObject() {
        return this.caf;
    }

    public void ahS() {
        if (this.caf != null) {
            if (this.caf.aiR != null) {
                this.caf.aiR.recycle();
                this.caf.aiR = null;
            }
            this.caf = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.caf != null && this.bZH.bZx) {
            this.caf.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ahS();
    }
}
