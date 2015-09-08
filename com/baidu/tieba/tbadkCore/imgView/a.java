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
    public float adu;
    private DragLayer cRR;
    private Vibrator cRS;
    private f cRT;
    private e cRU;
    public boolean cRV;
    private float cRW;
    private d cRX;
    private Rect cRY;
    private int cRZ;
    private int cSa;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.cRS = (Vibrator) context.getSystemService("vibrator");
        this.cRW = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.cRR = dragLayer;
        dragLayer.setDragController(this);
        this.cRZ = this.cRR.getPaddingLeft();
        this.cSa = this.cRR.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        this.cRV = true;
        this.cRX = new d(this.mContext);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.cRR.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.cRX.aBV = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        this.cRX.arc = rect;
        this.cRX.cSD = bundle;
        view.setVisibility(4);
        a(this.cRX);
        this.cRR.setDragObject(this.cRX);
        this.cRS.vibrate(300L);
    }

    public void endDrag() {
        if (this.cRV) {
            this.cRV = false;
            this.cRX = null;
            this.cRT.auF();
            this.cRT.auG();
            this.cRR.auI();
            this.cRR.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.adu = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.cRV;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cRV) {
            if (this.cRY == null) {
                this.cRY = new Rect();
                this.cRR.getDrawingRect(this.cRY);
                Rect rect = this.cRY;
                rect.top = (int) (rect.top - this.cRW);
                Rect rect2 = this.cRY;
                rect2.bottom = (int) (rect2.bottom + this.cRW);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.adu = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.adu = x;
                    this.cRX.arc.offset((int) (x - this.adu), 0);
                    a(this.cRX);
                    auB();
                    break;
            }
            return true;
        }
        return false;
    }

    public void auB() {
        this.mTempRect.set(this.cRX.arc);
        this.cRR.offsetRectIntoDescendantCoords((View) this.cRT, this.mTempRect);
        this.cRT.d(this.mTempRect);
        this.cRR.invalidate();
        if (this.cRX.cSE) {
            this.cRT.auD();
        } else if (this.cRX.cSF) {
            this.cRT.auE();
        } else {
            this.cRT.auF();
        }
    }

    private void a(d dVar) {
        dVar.cSE = false;
        dVar.cSF = false;
        Rect rect = dVar.arc;
        int width = rect.width();
        int width2 = (this.cRR.getWidth() - this.cRZ) - this.cSa;
        if (rect.left < this.cRZ) {
            rect.left = this.cRZ;
            rect.right = rect.left + width;
        }
        if (rect.right > this.cRZ + width2) {
            rect.right = this.cRZ + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.cRZ + this.cRW) {
            dVar.cSE = true;
            dVar.cSF = false;
        }
        if (rect.right > (this.cRZ + width2) - this.cRW) {
            dVar.cSE = false;
            dVar.cSF = true;
        }
    }

    public void a(f fVar) {
        this.cRT = fVar;
    }

    public void a(e eVar) {
        this.cRU = eVar;
        this.cRU.setDragController(this);
    }
}
