package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private d daI;
    private a dai;

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
        return this.dai.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.dai.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.dai;
    }

    public void setDragController(a aVar) {
        this.dai = aVar;
    }

    public void setDragObject(d dVar) {
        this.daI = dVar;
        invalidate();
    }

    public d getDragObject() {
        return this.daI;
    }

    public void axh() {
        if (this.daI != null) {
            if (this.daI.aAK != null) {
                this.daI.aAK.recycle();
                this.daI.aAK = null;
            }
            this.daI = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.daI != null && this.dai.cZZ) {
            this.daI.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        axh();
    }
}
