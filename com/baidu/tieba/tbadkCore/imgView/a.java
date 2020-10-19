package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a {
    public float cZB;
    private Context mContext;
    private DragLayer mFR;
    private d mFS;
    private c mFT;
    public boolean mFU;
    private float mFV;
    private b mFW;
    private Rect mFX;
    private int mFY;
    private int mFZ;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.mFV = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.mFR = dragLayer;
        dragLayer.setDragController(this);
        this.mFY = this.mFR.getPaddingLeft();
        this.mFZ = this.mFR.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.mFR != null && view != null && view.getDrawingCache() != null) {
            this.mFU = true;
            this.mFW = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.mFR.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.mFW.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.mFW.bvm = rect;
            this.mFW.mGB = bundle;
            view.setVisibility(4);
            a(this.mFW);
            this.mFR.setDragObject(this.mFW);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.mFU) {
            this.mFU = false;
            this.mFW = null;
            this.mFS.dEN();
            this.mFS.dEO();
            this.mFR.dEQ();
            this.mFR.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.cZB = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.mFU;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mFU) {
            if (this.mFX == null) {
                this.mFX = new Rect();
                this.mFR.getDrawingRect(this.mFX);
                Rect rect = this.mFX;
                rect.top = (int) (rect.top - this.mFV);
                Rect rect2 = this.mFX;
                rect2.bottom = (int) (rect2.bottom + this.mFV);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.cZB = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.cZB = x;
                    this.mFW.bvm.offset((int) (x - this.cZB), 0);
                    a(this.mFW);
                    dEJ();
                    break;
            }
            return true;
        }
        return false;
    }

    public void dEJ() {
        this.mTempRect.set(this.mFW.bvm);
        this.mFR.offsetRectIntoDescendantCoords((View) this.mFS, this.mTempRect);
        this.mFS.j(this.mTempRect);
        this.mFR.invalidate();
        if (this.mFW.mGC) {
            this.mFS.dEL();
        } else if (this.mFW.mGD) {
            this.mFS.dEM();
        } else {
            this.mFS.dEN();
        }
    }

    private void a(b bVar) {
        bVar.mGC = false;
        bVar.mGD = false;
        Rect rect = bVar.bvm;
        int width = rect.width();
        int width2 = (this.mFR.getWidth() - this.mFY) - this.mFZ;
        if (rect.left < this.mFY) {
            rect.left = this.mFY;
            rect.right = rect.left + width;
        }
        if (rect.right > this.mFY + width2) {
            rect.right = this.mFY + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.mFY + this.mFV) {
            bVar.mGC = true;
            bVar.mGD = false;
        }
        if (rect.right > (this.mFY + width2) - this.mFV) {
            bVar.mGC = false;
            bVar.mGD = true;
        }
    }

    public void a(d dVar) {
        this.mFS = dVar;
    }

    public void a(c cVar) {
        this.mFT = cVar;
        this.mFT.setDragController(this);
    }
}
