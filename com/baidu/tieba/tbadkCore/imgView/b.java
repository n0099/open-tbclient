package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    public float aRx;
    public boolean gAA;
    private float gAB;
    private c gAC;
    private Rect gAD;
    private int gAE;
    private int gAF;
    private DragLayer gAw;
    private Vibrator gAx;
    private e gAy;
    private d gAz;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.gAx = (Vibrator) context.getSystemService("vibrator");
        this.gAB = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.gAw = dragLayer;
        dragLayer.setDragController(this);
        this.gAE = this.gAw.getPaddingLeft();
        this.gAF = this.gAw.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.gAw != null && view != null && view.getDrawingCache() != null) {
            this.gAA = true;
            this.gAC = new c(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.gAw.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.gAC.aOp = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.gAC.rect = rect;
            this.gAC.gBh = bundle;
            view.setVisibility(4);
            a(this.gAC);
            this.gAw.setDragObject(this.gAC);
            this.gAx.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.gAA) {
            this.gAA = false;
            this.gAC = null;
            this.gAy.bwN();
            this.gAy.bwO();
            this.gAw.bwQ();
            this.gAw.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.aRx = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.gAA;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gAA) {
            if (this.gAD == null) {
                this.gAD = new Rect();
                this.gAw.getDrawingRect(this.gAD);
                Rect rect = this.gAD;
                rect.top = (int) (rect.top - this.gAB);
                Rect rect2 = this.gAD;
                rect2.bottom = (int) (rect2.bottom + this.gAB);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.aRx = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.aRx = x;
                    this.gAC.rect.offset((int) (x - this.aRx), 0);
                    a(this.gAC);
                    bwJ();
                    break;
            }
            return true;
        }
        return false;
    }

    public void bwJ() {
        this.mTempRect.set(this.gAC.rect);
        this.gAw.offsetRectIntoDescendantCoords((View) this.gAy, this.mTempRect);
        this.gAy.j(this.mTempRect);
        this.gAw.invalidate();
        if (this.gAC.gBi) {
            this.gAy.bwL();
        } else if (this.gAC.gBj) {
            this.gAy.bwM();
        } else {
            this.gAy.bwN();
        }
    }

    private void a(c cVar) {
        cVar.gBi = false;
        cVar.gBj = false;
        Rect rect = cVar.rect;
        int width = rect.width();
        int width2 = (this.gAw.getWidth() - this.gAE) - this.gAF;
        if (rect.left < this.gAE) {
            rect.left = this.gAE;
            rect.right = rect.left + width;
        }
        if (rect.right > this.gAE + width2) {
            rect.right = this.gAE + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.gAE + this.gAB) {
            cVar.gBi = true;
            cVar.gBj = false;
        }
        if (rect.right > (this.gAE + width2) - this.gAB) {
            cVar.gBi = false;
            cVar.gBj = true;
        }
    }

    public void a(e eVar) {
        this.gAy = eVar;
    }

    public void a(d dVar) {
        this.gAz = dVar;
        this.gAz.setDragController(this);
    }
}
