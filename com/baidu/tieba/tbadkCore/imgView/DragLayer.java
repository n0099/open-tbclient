package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DragLayer extends FrameLayout {
    private b mqS;
    private a mqw;

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
        return this.mqw.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mqw.onTouchEvent(motionEvent);
    }

    public a getDragController() {
        return this.mqw;
    }

    public void setDragController(a aVar) {
        this.mqw = aVar;
    }

    public void setDragObject(b bVar) {
        this.mqS = bVar;
        invalidate();
    }

    public b getDragObject() {
        return this.mqS;
    }

    public void dBe() {
        if (this.mqS != null) {
            if (this.mqS.bm != null) {
                this.mqS.bm.recycle();
                this.mqS.bm = null;
            }
            this.mqS = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mqS != null && this.mqw.mqn) {
            this.mqS.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dBe();
    }
}
