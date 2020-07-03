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
    public float cAs;
    private b lHA;
    private Rect lHB;
    private int lHC;
    private int lHD;
    private DragLayer lHv;
    private d lHw;
    private c lHx;
    public boolean lHy;
    private float lHz;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.lHz = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.lHv = dragLayer;
        dragLayer.setDragController(this);
        this.lHC = this.lHv.getPaddingLeft();
        this.lHD = this.lHv.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.lHv != null && view != null && view.getDrawingCache() != null) {
            this.lHy = true;
            this.lHA = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.lHv.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.lHA.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.lHA.rect = rect;
            this.lHA.lIe = bundle;
            view.setVisibility(4);
            a(this.lHA);
            this.lHv.setDragObject(this.lHA);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.lHy) {
            this.lHy = false;
            this.lHA = null;
            this.lHw.diw();
            this.lHw.dix();
            this.lHv.diz();
            this.lHv.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.cAs = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.lHy;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.lHy) {
            if (this.lHB == null) {
                this.lHB = new Rect();
                this.lHv.getDrawingRect(this.lHB);
                Rect rect = this.lHB;
                rect.top = (int) (rect.top - this.lHz);
                Rect rect2 = this.lHB;
                rect2.bottom = (int) (rect2.bottom + this.lHz);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.cAs = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.cAs = x;
                    this.lHA.rect.offset((int) (x - this.cAs), 0);
                    a(this.lHA);
                    dis();
                    break;
            }
            return true;
        }
        return false;
    }

    public void dis() {
        this.mTempRect.set(this.lHA.rect);
        this.lHv.offsetRectIntoDescendantCoords((View) this.lHw, this.mTempRect);
        this.lHw.j(this.mTempRect);
        this.lHv.invalidate();
        if (this.lHA.lIf) {
            this.lHw.diu();
        } else if (this.lHA.lIg) {
            this.lHw.div();
        } else {
            this.lHw.diw();
        }
    }

    private void a(b bVar) {
        bVar.lIf = false;
        bVar.lIg = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.lHv.getWidth() - this.lHC) - this.lHD;
        if (rect.left < this.lHC) {
            rect.left = this.lHC;
            rect.right = rect.left + width;
        }
        if (rect.right > this.lHC + width2) {
            rect.right = this.lHC + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.lHC + this.lHz) {
            bVar.lIf = true;
            bVar.lIg = false;
        }
        if (rect.right > (this.lHC + width2) - this.lHz) {
            bVar.lIf = false;
            bVar.lIg = true;
        }
    }

    public void a(d dVar) {
        this.lHw = dVar;
    }

    public void a(c cVar) {
        this.lHx = cVar;
        this.lHx.setDragController(this);
    }
}
