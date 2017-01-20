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
    public float chT;
    private DragLayer fqQ;
    private Vibrator fqR;
    private g fqS;
    private f fqT;
    public boolean fqU;
    private float fqV;
    private e fqW;
    private Rect fqX;
    private int fqY;
    private int fqZ;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.fqR = (Vibrator) context.getSystemService("vibrator");
        this.fqV = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.fqQ = dragLayer;
        dragLayer.setDragController(this);
        this.fqY = this.fqQ.getPaddingLeft();
        this.fqZ = this.fqQ.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.fqQ != null && view != null && view.getDrawingCache() != null) {
            this.fqU = true;
            this.fqW = new e(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.fqQ.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.fqW.aEw = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.fqW.rect = rect;
            this.fqW.frB = bundle;
            view.setVisibility(4);
            a(this.fqW);
            this.fqQ.setDragObject(this.fqW);
            this.fqR.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.fqU) {
            this.fqU = false;
            this.fqW = null;
            this.fqS.bik();
            this.fqS.bil();
            this.fqQ.bin();
            this.fqQ.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.chT = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.fqU;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.fqU) {
            if (this.fqX == null) {
                this.fqX = new Rect();
                this.fqQ.getDrawingRect(this.fqX);
                Rect rect = this.fqX;
                rect.top = (int) (rect.top - this.fqV);
                Rect rect2 = this.fqX;
                rect2.bottom = (int) (rect2.bottom + this.fqV);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.chT = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.chT = x;
                    this.fqW.rect.offset((int) (x - this.chT), 0);
                    a(this.fqW);
                    big();
                    break;
            }
            return true;
        }
        return false;
    }

    public void big() {
        this.mTempRect.set(this.fqW.rect);
        this.fqQ.offsetRectIntoDescendantCoords((View) this.fqS, this.mTempRect);
        this.fqS.e(this.mTempRect);
        this.fqQ.invalidate();
        if (this.fqW.frC) {
            this.fqS.bii();
        } else if (this.fqW.frD) {
            this.fqS.bij();
        } else {
            this.fqS.bik();
        }
    }

    private void a(e eVar) {
        eVar.frC = false;
        eVar.frD = false;
        Rect rect = eVar.rect;
        int width = rect.width();
        int width2 = (this.fqQ.getWidth() - this.fqY) - this.fqZ;
        if (rect.left < this.fqY) {
            rect.left = this.fqY;
            rect.right = rect.left + width;
        }
        if (rect.right > this.fqY + width2) {
            rect.right = this.fqY + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.fqY + this.fqV) {
            eVar.frC = true;
            eVar.frD = false;
        }
        if (rect.right > (this.fqY + width2) - this.fqV) {
            eVar.frC = false;
            eVar.frD = true;
        }
    }

    public void a(g gVar) {
        this.fqS = gVar;
    }

    public void a(f fVar) {
        this.fqT = fVar;
        this.fqT.setDragController(this);
    }
}
