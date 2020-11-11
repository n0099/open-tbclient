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
    public float dnY;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;
    private DragLayer mYA;
    private d mYB;
    private c mYC;
    public boolean mYD;
    private float mYE;
    private b mYF;
    private Rect mYG;
    private int mYH;
    private int mYI;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.mYE = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.mYA = dragLayer;
        dragLayer.setDragController(this);
        this.mYH = this.mYA.getPaddingLeft();
        this.mYI = this.mYA.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.mYA != null && view != null && view.getDrawingCache() != null) {
            this.mYD = true;
            this.mYF = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.mYA.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.mYF.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.mYF.bDL = rect;
            this.mYF.mZj = bundle;
            view.setVisibility(4);
            a(this.mYF);
            this.mYA.setDragObject(this.mYF);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.mYD) {
            this.mYD = false;
            this.mYF = null;
            this.mYB.dKx();
            this.mYB.dKy();
            this.mYA.dKA();
            this.mYA.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.dnY = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.mYD;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mYD) {
            if (this.mYG == null) {
                this.mYG = new Rect();
                this.mYA.getDrawingRect(this.mYG);
                Rect rect = this.mYG;
                rect.top = (int) (rect.top - this.mYE);
                Rect rect2 = this.mYG;
                rect2.bottom = (int) (rect2.bottom + this.mYE);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.dnY = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.dnY = x;
                    this.mYF.bDL.offset((int) (x - this.dnY), 0);
                    a(this.mYF);
                    dKt();
                    break;
            }
            return true;
        }
        return false;
    }

    public void dKt() {
        this.mTempRect.set(this.mYF.bDL);
        this.mYA.offsetRectIntoDescendantCoords((View) this.mYB, this.mTempRect);
        this.mYB.j(this.mTempRect);
        this.mYA.invalidate();
        if (this.mYF.mZk) {
            this.mYB.dKv();
        } else if (this.mYF.mZl) {
            this.mYB.dKw();
        } else {
            this.mYB.dKx();
        }
    }

    private void a(b bVar) {
        bVar.mZk = false;
        bVar.mZl = false;
        Rect rect = bVar.bDL;
        int width = rect.width();
        int width2 = (this.mYA.getWidth() - this.mYH) - this.mYI;
        if (rect.left < this.mYH) {
            rect.left = this.mYH;
            rect.right = rect.left + width;
        }
        if (rect.right > this.mYH + width2) {
            rect.right = this.mYH + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.mYH + this.mYE) {
            bVar.mZk = true;
            bVar.mZl = false;
        }
        if (rect.right > (this.mYH + width2) - this.mYE) {
            bVar.mZk = false;
            bVar.mZl = true;
        }
    }

    public void a(d dVar) {
        this.mYB = dVar;
    }

    public void a(c cVar) {
        this.mYC = cVar;
        this.mYC.setDragController(this);
    }
}
