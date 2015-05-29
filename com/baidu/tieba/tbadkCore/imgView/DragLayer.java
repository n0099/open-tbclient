package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private a ctc;
    private e ctz;

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
        return this.ctc.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.ctc.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.ctc;
    }

    public void setDragController(a aVar) {
        this.ctc = aVar;
    }

    public void setDragObject(e eVar) {
        this.ctz = eVar;
        invalidate();
    }

    public e getDragObject() {
        return this.ctz;
    }

    public void aoZ() {
        if (this.ctz != null) {
            if (this.ctz.ate != null) {
                this.ctz.ate.recycle();
                this.ctz.ate = null;
            }
            this.ctz = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.ctz != null && this.ctc.csS) {
            this.ctz.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aoZ();
    }
}
