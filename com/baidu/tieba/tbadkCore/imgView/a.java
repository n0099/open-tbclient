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
    public float cdw;
    private DragLayer eYP;
    private Vibrator eYQ;
    private f eYR;
    private e eYS;
    public boolean eYT;
    private float eYU;
    private d eYV;
    private Rect eYW;
    private int eYX;
    private int eYY;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.eYQ = (Vibrator) context.getSystemService("vibrator");
        this.eYU = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.eYP = dragLayer;
        dragLayer.setDragController(this);
        this.eYX = this.eYP.getPaddingLeft();
        this.eYY = this.eYP.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.eYP != null && view != null && view.getDrawingCache() != null) {
            this.eYT = true;
            this.eYV = new d(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.eYP.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.eYV.aCb = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.eYV.rect = rect;
            this.eYV.eZz = bundle;
            view.setVisibility(4);
            a(this.eYV);
            this.eYP.setDragObject(this.eYV);
            this.eYQ.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.eYT) {
            this.eYT = false;
            this.eYV = null;
            this.eYR.bcO();
            this.eYR.bcP();
            this.eYP.bcR();
            this.eYP.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.cdw = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.eYT;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.eYT) {
            if (this.eYW == null) {
                this.eYW = new Rect();
                this.eYP.getDrawingRect(this.eYW);
                Rect rect = this.eYW;
                rect.top = (int) (rect.top - this.eYU);
                Rect rect2 = this.eYW;
                rect2.bottom = (int) (rect2.bottom + this.eYU);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.cdw = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.cdw = x;
                    this.eYV.rect.offset((int) (x - this.cdw), 0);
                    a(this.eYV);
                    bcK();
                    break;
            }
            return true;
        }
        return false;
    }

    public void bcK() {
        this.mTempRect.set(this.eYV.rect);
        this.eYP.offsetRectIntoDescendantCoords((View) this.eYR, this.mTempRect);
        this.eYR.d(this.mTempRect);
        this.eYP.invalidate();
        if (this.eYV.eZA) {
            this.eYR.bcM();
        } else if (this.eYV.eZB) {
            this.eYR.bcN();
        } else {
            this.eYR.bcO();
        }
    }

    private void a(d dVar) {
        dVar.eZA = false;
        dVar.eZB = false;
        Rect rect = dVar.rect;
        int width = rect.width();
        int width2 = (this.eYP.getWidth() - this.eYX) - this.eYY;
        if (rect.left < this.eYX) {
            rect.left = this.eYX;
            rect.right = rect.left + width;
        }
        if (rect.right > this.eYX + width2) {
            rect.right = this.eYX + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.eYX + this.eYU) {
            dVar.eZA = true;
            dVar.eZB = false;
        }
        if (rect.right > (this.eYX + width2) - this.eYU) {
            dVar.eZA = false;
            dVar.eZB = true;
        }
    }

    public void a(f fVar) {
        this.eYR = fVar;
    }

    public void a(e eVar) {
        this.eYS = eVar;
        this.eYS.setDragController(this);
    }
}
