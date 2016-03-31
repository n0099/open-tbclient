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
public class a {
    public float bFO;
    private DragLayer eqP;
    private Vibrator eqQ;
    private f eqR;
    private e eqS;
    public boolean eqT;
    private float eqU;
    private d eqV;
    private Rect eqW;
    private int eqX;
    private int eqY;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.eqQ = (Vibrator) context.getSystemService("vibrator");
        this.eqU = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.eqP = dragLayer;
        dragLayer.setDragController(this);
        this.eqX = this.eqP.getPaddingLeft();
        this.eqY = this.eqP.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.eqP != null && view != null && view.getDrawingCache() != null) {
            this.eqT = true;
            this.eqV = new d(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.eqP.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.eqV.aFr = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.eqV.rect = rect;
            this.eqV.erz = bundle;
            view.setVisibility(4);
            a(this.eqV);
            this.eqP.setDragObject(this.eqV);
            this.eqQ.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.eqT) {
            this.eqT = false;
            this.eqV = null;
            this.eqR.aTU();
            this.eqR.aTV();
            this.eqP.aTX();
            this.eqP.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.bFO = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.eqT;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.eqT) {
            if (this.eqW == null) {
                this.eqW = new Rect();
                this.eqP.getDrawingRect(this.eqW);
                Rect rect = this.eqW;
                rect.top = (int) (rect.top - this.eqU);
                Rect rect2 = this.eqW;
                rect2.bottom = (int) (rect2.bottom + this.eqU);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.bFO = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.bFO = x;
                    this.eqV.rect.offset((int) (x - this.bFO), 0);
                    a(this.eqV);
                    aTQ();
                    break;
            }
            return true;
        }
        return false;
    }

    public void aTQ() {
        this.mTempRect.set(this.eqV.rect);
        this.eqP.offsetRectIntoDescendantCoords((View) this.eqR, this.mTempRect);
        this.eqR.d(this.mTempRect);
        this.eqP.invalidate();
        if (this.eqV.erA) {
            this.eqR.aTS();
        } else if (this.eqV.erB) {
            this.eqR.aTT();
        } else {
            this.eqR.aTU();
        }
    }

    private void a(d dVar) {
        dVar.erA = false;
        dVar.erB = false;
        Rect rect = dVar.rect;
        int width = rect.width();
        int width2 = (this.eqP.getWidth() - this.eqX) - this.eqY;
        if (rect.left < this.eqX) {
            rect.left = this.eqX;
            rect.right = rect.left + width;
        }
        if (rect.right > this.eqX + width2) {
            rect.right = this.eqX + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.eqX + this.eqU) {
            dVar.erA = true;
            dVar.erB = false;
        }
        if (rect.right > (this.eqX + width2) - this.eqU) {
            dVar.erA = false;
            dVar.erB = true;
        }
    }

    public void a(f fVar) {
        this.eqR = fVar;
    }

    public void a(e eVar) {
        this.eqS = eVar;
        this.eqS.setDragController(this);
    }
}
