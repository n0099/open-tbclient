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
    private DragLayer hpT;
    private d hpU;
    private c hpV;
    public boolean hpW;
    private float hpX;
    private b hpY;
    private Rect hpZ;
    private int hqa;
    private int hqb;
    private Context mContext;
    public float mStartX;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.hpX = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.hpT = dragLayer;
        dragLayer.setDragController(this);
        this.hqa = this.hpT.getPaddingLeft();
        this.hqb = this.hpT.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.hpT != null && view != null && view.getDrawingCache() != null) {
            this.hpW = true;
            this.hpY = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.hpT.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.hpY.bjY = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.hpY.rect = rect;
            this.hpY.hqB = bundle;
            view.setVisibility(4);
            a(this.hpY);
            this.hpT.setDragObject(this.hpY);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.hpW) {
            this.hpW = false;
            this.hpY = null;
            this.hpU.bEG();
            this.hpU.bEH();
            this.hpT.bEJ();
            this.hpT.invalidate();
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
        return this.hpW;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hpW) {
            if (this.hpZ == null) {
                this.hpZ = new Rect();
                this.hpT.getDrawingRect(this.hpZ);
                Rect rect = this.hpZ;
                rect.top = (int) (rect.top - this.hpX);
                Rect rect2 = this.hpZ;
                rect2.bottom = (int) (rect2.bottom + this.hpX);
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
                    this.hpY.rect.offset((int) (x - this.mStartX), 0);
                    a(this.hpY);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.hpY.rect);
        this.hpT.offsetRectIntoDescendantCoords((View) this.hpU, this.mTempRect);
        this.hpU.m(this.mTempRect);
        this.hpT.invalidate();
        if (this.hpY.hqC) {
            this.hpU.bEE();
        } else if (this.hpY.hqD) {
            this.hpU.bEF();
        } else {
            this.hpU.bEG();
        }
    }

    private void a(b bVar) {
        bVar.hqC = false;
        bVar.hqD = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.hpT.getWidth() - this.hqa) - this.hqb;
        if (rect.left < this.hqa) {
            rect.left = this.hqa;
            rect.right = rect.left + width;
        }
        if (rect.right > this.hqa + width2) {
            rect.right = this.hqa + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.hqa + this.hpX) {
            bVar.hqC = true;
            bVar.hqD = false;
        }
        if (rect.right > (this.hqa + width2) - this.hpX) {
            bVar.hqC = false;
            bVar.hqD = true;
        }
    }

    public void a(d dVar) {
        this.hpU = dVar;
    }

    public void a(c cVar) {
        this.hpV = cVar;
        this.hpV.setDragController(this);
    }
}
