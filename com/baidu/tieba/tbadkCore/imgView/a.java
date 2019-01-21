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
    private DragLayer hrc;
    private d hrd;
    private c hre;
    public boolean hrf;
    private float hrg;
    private b hrh;
    private Rect hri;
    private int hrj;
    private int hrk;
    private Context mContext;
    public float mStartX;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.hrg = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.hrc = dragLayer;
        dragLayer.setDragController(this);
        this.hrj = this.hrc.getPaddingLeft();
        this.hrk = this.hrc.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.hrc != null && view != null && view.getDrawingCache() != null) {
            this.hrf = true;
            this.hrh = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.hrc.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.hrh.bkN = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.hrh.rect = rect;
            this.hrh.hrK = bundle;
            view.setVisibility(4);
            a(this.hrh);
            this.hrc.setDragObject(this.hrh);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.hrf) {
            this.hrf = false;
            this.hrh = null;
            this.hrd.bFp();
            this.hrd.bFq();
            this.hrc.bFs();
            this.hrc.invalidate();
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
        return this.hrf;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hrf) {
            if (this.hri == null) {
                this.hri = new Rect();
                this.hrc.getDrawingRect(this.hri);
                Rect rect = this.hri;
                rect.top = (int) (rect.top - this.hrg);
                Rect rect2 = this.hri;
                rect2.bottom = (int) (rect2.bottom + this.hrg);
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
                    this.hrh.rect.offset((int) (x - this.mStartX), 0);
                    a(this.hrh);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.hrh.rect);
        this.hrc.offsetRectIntoDescendantCoords((View) this.hrd, this.mTempRect);
        this.hrd.m(this.mTempRect);
        this.hrc.invalidate();
        if (this.hrh.hrL) {
            this.hrd.bFn();
        } else if (this.hrh.hrM) {
            this.hrd.bFo();
        } else {
            this.hrd.bFp();
        }
    }

    private void a(b bVar) {
        bVar.hrL = false;
        bVar.hrM = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.hrc.getWidth() - this.hrj) - this.hrk;
        if (rect.left < this.hrj) {
            rect.left = this.hrj;
            rect.right = rect.left + width;
        }
        if (rect.right > this.hrj + width2) {
            rect.right = this.hrj + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.hrj + this.hrg) {
            bVar.hrL = true;
            bVar.hrM = false;
        }
        if (rect.right > (this.hrj + width2) - this.hrg) {
            bVar.hrL = false;
            bVar.hrM = true;
        }
    }

    public void a(d dVar) {
        this.hrd = dVar;
    }

    public void a(c cVar) {
        this.hre = cVar;
        this.hre.setDragController(this);
    }
}
