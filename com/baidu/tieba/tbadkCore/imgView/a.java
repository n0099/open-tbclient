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
    private DragLayer hrb;
    private d hrc;
    private c hrd;
    public boolean hre;
    private float hrf;
    private b hrg;
    private Rect hrh;
    private int hri;
    private int hrj;
    private Context mContext;
    public float mStartX;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.hrf = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.hrb = dragLayer;
        dragLayer.setDragController(this);
        this.hri = this.hrb.getPaddingLeft();
        this.hrj = this.hrb.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.hrb != null && view != null && view.getDrawingCache() != null) {
            this.hre = true;
            this.hrg = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.hrb.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.hrg.bkM = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.hrg.rect = rect;
            this.hrg.hrJ = bundle;
            view.setVisibility(4);
            a(this.hrg);
            this.hrb.setDragObject(this.hrg);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.hre) {
            this.hre = false;
            this.hrg = null;
            this.hrc.bFp();
            this.hrc.bFq();
            this.hrb.bFs();
            this.hrb.invalidate();
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
        return this.hre;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hre) {
            if (this.hrh == null) {
                this.hrh = new Rect();
                this.hrb.getDrawingRect(this.hrh);
                Rect rect = this.hrh;
                rect.top = (int) (rect.top - this.hrf);
                Rect rect2 = this.hrh;
                rect2.bottom = (int) (rect2.bottom + this.hrf);
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
                    this.hrg.rect.offset((int) (x - this.mStartX), 0);
                    a(this.hrg);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.hrg.rect);
        this.hrb.offsetRectIntoDescendantCoords((View) this.hrc, this.mTempRect);
        this.hrc.m(this.mTempRect);
        this.hrb.invalidate();
        if (this.hrg.hrK) {
            this.hrc.bFn();
        } else if (this.hrg.hrL) {
            this.hrc.bFo();
        } else {
            this.hrc.bFp();
        }
    }

    private void a(b bVar) {
        bVar.hrK = false;
        bVar.hrL = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.hrb.getWidth() - this.hri) - this.hrj;
        if (rect.left < this.hri) {
            rect.left = this.hri;
            rect.right = rect.left + width;
        }
        if (rect.right > this.hri + width2) {
            rect.right = this.hri + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.hri + this.hrf) {
            bVar.hrK = true;
            bVar.hrL = false;
        }
        if (rect.right > (this.hri + width2) - this.hrf) {
            bVar.hrK = false;
            bVar.hrL = true;
        }
    }

    public void a(d dVar) {
        this.hrc = dVar;
    }

    public void a(c cVar) {
        this.hrd = cVar;
        this.hrd.setDragController(this);
    }
}
