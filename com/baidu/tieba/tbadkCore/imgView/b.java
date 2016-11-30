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
    public float cwm;
    private g fDA;
    private f fDB;
    public boolean fDC;
    private float fDD;
    private e fDE;
    private Rect fDF;
    private int fDG;
    private int fDH;
    private DragLayer fDy;
    private Vibrator fDz;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.fDz = (Vibrator) context.getSystemService("vibrator");
        this.fDD = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.fDy = dragLayer;
        dragLayer.setDragController(this);
        this.fDG = this.fDy.getPaddingLeft();
        this.fDH = this.fDy.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.fDy != null && view != null && view.getDrawingCache() != null) {
            this.fDC = true;
            this.fDE = new e(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.fDy.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.fDE.aGn = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.fDE.rect = rect;
            this.fDE.fEi = bundle;
            view.setVisibility(4);
            a(this.fDE);
            this.fDy.setDragObject(this.fDE);
            this.fDz.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.fDC) {
            this.fDC = false;
            this.fDE = null;
            this.fDA.bmG();
            this.fDA.bmH();
            this.fDy.bmJ();
            this.fDy.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.cwm = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.fDC;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.fDC) {
            if (this.fDF == null) {
                this.fDF = new Rect();
                this.fDy.getDrawingRect(this.fDF);
                Rect rect = this.fDF;
                rect.top = (int) (rect.top - this.fDD);
                Rect rect2 = this.fDF;
                rect2.bottom = (int) (rect2.bottom + this.fDD);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.cwm = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.cwm = x;
                    this.fDE.rect.offset((int) (x - this.cwm), 0);
                    a(this.fDE);
                    bmC();
                    break;
            }
            return true;
        }
        return false;
    }

    public void bmC() {
        this.mTempRect.set(this.fDE.rect);
        this.fDy.offsetRectIntoDescendantCoords((View) this.fDA, this.mTempRect);
        this.fDA.d(this.mTempRect);
        this.fDy.invalidate();
        if (this.fDE.fEj) {
            this.fDA.bmE();
        } else if (this.fDE.fEk) {
            this.fDA.bmF();
        } else {
            this.fDA.bmG();
        }
    }

    private void a(e eVar) {
        eVar.fEj = false;
        eVar.fEk = false;
        Rect rect = eVar.rect;
        int width = rect.width();
        int width2 = (this.fDy.getWidth() - this.fDG) - this.fDH;
        if (rect.left < this.fDG) {
            rect.left = this.fDG;
            rect.right = rect.left + width;
        }
        if (rect.right > this.fDG + width2) {
            rect.right = this.fDG + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.fDG + this.fDD) {
            eVar.fEj = true;
            eVar.fEk = false;
        }
        if (rect.right > (this.fDG + width2) - this.fDD) {
            eVar.fEj = false;
            eVar.fEk = true;
        }
    }

    public void a(g gVar) {
        this.fDA = gVar;
    }

    public void a(f fVar) {
        this.fDB = fVar;
        this.fDB.setDragController(this);
    }
}
