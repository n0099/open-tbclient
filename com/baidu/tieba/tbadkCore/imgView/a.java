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
    private Vibrator dOO;
    public float dxQ;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private DragLayer nAP;
    private d nAQ;
    private c nAR;
    public boolean nAS;
    private float nAT;
    private b nAU;
    private Rect nAV;
    private int nAW;
    private int nAX;

    public a(Context context) {
        this.mContext = context;
        this.dOO = (Vibrator) context.getSystemService("vibrator");
        this.nAT = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.nAP = dragLayer;
        dragLayer.setDragController(this);
        this.nAW = this.nAP.getPaddingLeft();
        this.nAX = this.nAP.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.nAP != null && view != null && view.getDrawingCache() != null) {
            this.nAS = true;
            this.nAU = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.nAP.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.nAU.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.nAU.rect = rect;
            this.nAU.nBw = bundle;
            view.setVisibility(4);
            a(this.nAU);
            this.nAP.setDragObject(this.nAU);
            this.dOO.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.nAS) {
            this.nAS = false;
            this.nAU = null;
            this.nAQ.dOm();
            this.nAQ.dOn();
            this.nAP.dOp();
            this.nAP.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.dxQ = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.nAS;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nAS) {
            if (this.nAV == null) {
                this.nAV = new Rect();
                this.nAP.getDrawingRect(this.nAV);
                Rect rect = this.nAV;
                rect.top = (int) (rect.top - this.nAT);
                Rect rect2 = this.nAV;
                rect2.bottom = (int) (rect2.bottom + this.nAT);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.dxQ = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.dxQ = x;
                    this.nAU.rect.offset((int) (x - this.dxQ), 0);
                    a(this.nAU);
                    dOi();
                    break;
            }
            return true;
        }
        return false;
    }

    public void dOi() {
        this.mTempRect.set(this.nAU.rect);
        this.nAP.offsetRectIntoDescendantCoords((View) this.nAQ, this.mTempRect);
        this.nAQ.i(this.mTempRect);
        this.nAP.invalidate();
        if (this.nAU.nBx) {
            this.nAQ.dOk();
        } else if (this.nAU.nBy) {
            this.nAQ.dOl();
        } else {
            this.nAQ.dOm();
        }
    }

    private void a(b bVar) {
        bVar.nBx = false;
        bVar.nBy = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.nAP.getWidth() - this.nAW) - this.nAX;
        if (rect.left < this.nAW) {
            rect.left = this.nAW;
            rect.right = rect.left + width;
        }
        if (rect.right > this.nAW + width2) {
            rect.right = this.nAW + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.nAW + this.nAT) {
            bVar.nBx = true;
            bVar.nBy = false;
        }
        if (rect.right > (this.nAW + width2) - this.nAT) {
            bVar.nBx = false;
            bVar.nBy = true;
        }
    }

    public void a(d dVar) {
        this.nAQ = dVar;
    }

    public void a(c cVar) {
        this.nAR = cVar;
        this.nAR.setDragController(this);
    }
}
