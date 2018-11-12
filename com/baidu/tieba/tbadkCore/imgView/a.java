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
    private DragLayer hfN;
    private d hfO;
    private c hfP;
    public boolean hfQ;
    private float hfR;
    private b hfS;
    private Rect hfT;
    private int hfU;
    private int hfV;
    private Context mContext;
    public float mStartX;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.hfR = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.hfN = dragLayer;
        dragLayer.setDragController(this);
        this.hfU = this.hfN.getPaddingLeft();
        this.hfV = this.hfN.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.hfN != null && view != null && view.getDrawingCache() != null) {
            this.hfQ = true;
            this.hfS = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.hfN.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.hfS.bgw = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.hfS.rect = rect;
            this.hfS.hgv = bundle;
            view.setVisibility(4);
            a(this.hfS);
            this.hfN.setDragObject(this.hfS);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.hfQ) {
            this.hfQ = false;
            this.hfS = null;
            this.hfO.bBU();
            this.hfO.bBV();
            this.hfN.bBX();
            this.hfN.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.mStartX = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.hfQ;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hfQ) {
            if (this.hfT == null) {
                this.hfT = new Rect();
                this.hfN.getDrawingRect(this.hfT);
                Rect rect = this.hfT;
                rect.top = (int) (rect.top - this.hfR);
                Rect rect2 = this.hfT;
                rect2.bottom = (int) (rect2.bottom + this.hfR);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.mStartX = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.mStartX = x;
                    this.hfS.rect.offset((int) (x - this.mStartX), 0);
                    a(this.hfS);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.hfS.rect);
        this.hfN.offsetRectIntoDescendantCoords((View) this.hfO, this.mTempRect);
        this.hfO.m(this.mTempRect);
        this.hfN.invalidate();
        if (this.hfS.hgw) {
            this.hfO.bBS();
        } else if (this.hfS.hgx) {
            this.hfO.bBT();
        } else {
            this.hfO.bBU();
        }
    }

    private void a(b bVar) {
        bVar.hgw = false;
        bVar.hgx = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.hfN.getWidth() - this.hfU) - this.hfV;
        if (rect.left < this.hfU) {
            rect.left = this.hfU;
            rect.right = rect.left + width;
        }
        if (rect.right > this.hfU + width2) {
            rect.right = this.hfU + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.hfU + this.hfR) {
            bVar.hgw = true;
            bVar.hgx = false;
        }
        if (rect.right > (this.hfU + width2) - this.hfR) {
            bVar.hgw = false;
            bVar.hgx = true;
        }
    }

    public void a(d dVar) {
        this.hfO = dVar;
    }

    public void a(c cVar) {
        this.hfP = cVar;
        this.hfP.setDragController(this);
    }
}
