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
    private Rect fNA;
    private int fNB;
    private int fNC;
    private DragLayer fNt;
    private Vibrator fNu;
    private g fNv;
    private f fNw;
    public boolean fNx;
    private float fNy;
    private e fNz;
    public float foS;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.fNu = (Vibrator) context.getSystemService("vibrator");
        this.fNy = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.fNt = dragLayer;
        dragLayer.setDragController(this);
        this.fNB = this.fNt.getPaddingLeft();
        this.fNC = this.fNt.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.fNt != null && view != null && view.getDrawingCache() != null) {
            this.fNx = true;
            this.fNz = new e(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.fNt.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.fNz.aLw = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.fNz.rect = rect;
            this.fNz.fOe = bundle;
            view.setVisibility(4);
            a(this.fNz);
            this.fNt.setDragObject(this.fNz);
            this.fNu.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.fNx) {
            this.fNx = false;
            this.fNz = null;
            this.fNv.bmR();
            this.fNv.bmS();
            this.fNt.bmU();
            this.fNt.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.foS = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.fNx;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.fNx) {
            if (this.fNA == null) {
                this.fNA = new Rect();
                this.fNt.getDrawingRect(this.fNA);
                Rect rect = this.fNA;
                rect.top = (int) (rect.top - this.fNy);
                Rect rect2 = this.fNA;
                rect2.bottom = (int) (rect2.bottom + this.fNy);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.foS = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.foS = x;
                    this.fNz.rect.offset((int) (x - this.foS), 0);
                    a(this.fNz);
                    bmN();
                    break;
            }
            return true;
        }
        return false;
    }

    public void bmN() {
        this.mTempRect.set(this.fNz.rect);
        this.fNt.offsetRectIntoDescendantCoords((View) this.fNv, this.mTempRect);
        this.fNv.e(this.mTempRect);
        this.fNt.invalidate();
        if (this.fNz.fOf) {
            this.fNv.bmP();
        } else if (this.fNz.fOg) {
            this.fNv.bmQ();
        } else {
            this.fNv.bmR();
        }
    }

    private void a(e eVar) {
        eVar.fOf = false;
        eVar.fOg = false;
        Rect rect = eVar.rect;
        int width = rect.width();
        int width2 = (this.fNt.getWidth() - this.fNB) - this.fNC;
        if (rect.left < this.fNB) {
            rect.left = this.fNB;
            rect.right = rect.left + width;
        }
        if (rect.right > this.fNB + width2) {
            rect.right = this.fNB + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.fNB + this.fNy) {
            eVar.fOf = true;
            eVar.fOg = false;
        }
        if (rect.right > (this.fNB + width2) - this.fNy) {
            eVar.fOf = false;
            eVar.fOg = true;
        }
    }

    public void a(g gVar) {
        this.fNv = gVar;
    }

    public void a(f fVar) {
        this.fNw = fVar;
        this.fNw.setDragController(this);
    }
}
