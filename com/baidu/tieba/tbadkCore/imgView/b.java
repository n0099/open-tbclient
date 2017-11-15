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
    public float aOA;
    private DragLayer grA;
    private Vibrator grB;
    private e grC;
    private d grD;
    public boolean grE;
    private float grF;
    private c grG;
    private Rect grH;
    private int grI;
    private int grJ;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.grB = (Vibrator) context.getSystemService("vibrator");
        this.grF = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.grA = dragLayer;
        dragLayer.setDragController(this);
        this.grI = this.grA.getPaddingLeft();
        this.grJ = this.grA.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.grA != null && view != null && view.getDrawingCache() != null) {
            this.grE = true;
            this.grG = new c(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.grA.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.grG.aNO = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.grG.rect = rect;
            this.grG.gsl = bundle;
            view.setVisibility(4);
            a(this.grG);
            this.grA.setDragObject(this.grG);
            this.grB.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.grE) {
            this.grE = false;
            this.grG = null;
            this.grC.bvd();
            this.grC.bve();
            this.grA.bvg();
            this.grA.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.aOA = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.grE;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.grE) {
            if (this.grH == null) {
                this.grH = new Rect();
                this.grA.getDrawingRect(this.grH);
                Rect rect = this.grH;
                rect.top = (int) (rect.top - this.grF);
                Rect rect2 = this.grH;
                rect2.bottom = (int) (rect2.bottom + this.grF);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.aOA = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.aOA = x;
                    this.grG.rect.offset((int) (x - this.aOA), 0);
                    a(this.grG);
                    buZ();
                    break;
            }
            return true;
        }
        return false;
    }

    public void buZ() {
        this.mTempRect.set(this.grG.rect);
        this.grA.offsetRectIntoDescendantCoords((View) this.grC, this.mTempRect);
        this.grC.j(this.mTempRect);
        this.grA.invalidate();
        if (this.grG.gsm) {
            this.grC.bvb();
        } else if (this.grG.gsn) {
            this.grC.bvc();
        } else {
            this.grC.bvd();
        }
    }

    private void a(c cVar) {
        cVar.gsm = false;
        cVar.gsn = false;
        Rect rect = cVar.rect;
        int width = rect.width();
        int width2 = (this.grA.getWidth() - this.grI) - this.grJ;
        if (rect.left < this.grI) {
            rect.left = this.grI;
            rect.right = rect.left + width;
        }
        if (rect.right > this.grI + width2) {
            rect.right = this.grI + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.grI + this.grF) {
            cVar.gsm = true;
            cVar.gsn = false;
        }
        if (rect.right > (this.grI + width2) - this.grF) {
            cVar.gsm = false;
            cVar.gsn = true;
        }
    }

    public void a(e eVar) {
        this.grC = eVar;
    }

    public void a(d dVar) {
        this.grD = dVar;
        this.grD.setDragController(this);
    }
}
