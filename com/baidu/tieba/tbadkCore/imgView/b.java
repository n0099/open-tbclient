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
    public float cbx;
    private DragLayer fhC;
    private Vibrator fhD;
    private g fhE;
    private f fhF;
    public boolean fhG;
    private float fhH;
    private e fhI;
    private Rect fhJ;
    private int fhK;
    private int fhL;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.fhD = (Vibrator) context.getSystemService("vibrator");
        this.fhH = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.fhC = dragLayer;
        dragLayer.setDragController(this);
        this.fhK = this.fhC.getPaddingLeft();
        this.fhL = this.fhC.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.fhC != null && view != null && view.getDrawingCache() != null) {
            this.fhG = true;
            this.fhI = new e(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.fhC.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.fhI.aFH = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.fhI.rect = rect;
            this.fhI.fin = bundle;
            view.setVisibility(4);
            a(this.fhI);
            this.fhC.setDragObject(this.fhI);
            this.fhD.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.fhG) {
            this.fhG = false;
            this.fhI = null;
            this.fhE.bgv();
            this.fhE.bgw();
            this.fhC.bgy();
            this.fhC.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.cbx = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.fhG;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.fhG) {
            if (this.fhJ == null) {
                this.fhJ = new Rect();
                this.fhC.getDrawingRect(this.fhJ);
                Rect rect = this.fhJ;
                rect.top = (int) (rect.top - this.fhH);
                Rect rect2 = this.fhJ;
                rect2.bottom = (int) (rect2.bottom + this.fhH);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.cbx = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.cbx = x;
                    this.fhI.rect.offset((int) (x - this.cbx), 0);
                    a(this.fhI);
                    bgr();
                    break;
            }
            return true;
        }
        return false;
    }

    public void bgr() {
        this.mTempRect.set(this.fhI.rect);
        this.fhC.offsetRectIntoDescendantCoords((View) this.fhE, this.mTempRect);
        this.fhE.e(this.mTempRect);
        this.fhC.invalidate();
        if (this.fhI.fio) {
            this.fhE.bgt();
        } else if (this.fhI.fip) {
            this.fhE.bgu();
        } else {
            this.fhE.bgv();
        }
    }

    private void a(e eVar) {
        eVar.fio = false;
        eVar.fip = false;
        Rect rect = eVar.rect;
        int width = rect.width();
        int width2 = (this.fhC.getWidth() - this.fhK) - this.fhL;
        if (rect.left < this.fhK) {
            rect.left = this.fhK;
            rect.right = rect.left + width;
        }
        if (rect.right > this.fhK + width2) {
            rect.right = this.fhK + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.fhK + this.fhH) {
            eVar.fio = true;
            eVar.fip = false;
        }
        if (rect.right > (this.fhK + width2) - this.fhH) {
            eVar.fio = false;
            eVar.fip = true;
        }
    }

    public void a(g gVar) {
        this.fhE = gVar;
    }

    public void a(f fVar) {
        this.fhF = fVar;
        this.fhF.setDragController(this);
    }
}
