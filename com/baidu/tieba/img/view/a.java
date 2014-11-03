package com.baidu.tieba.img.view;

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
    public float Hc;
    private DragLayer blc;
    private g bld;
    private f ble;
    public boolean blf;
    private float blg;
    private e blh;
    private Rect bli;
    private int blj;
    private int blk;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.blg = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.blc = dragLayer;
        dragLayer.setDragController(this);
        this.blj = this.blc.getPaddingLeft();
        this.blk = this.blc.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        this.blf = true;
        this.blh = new e(this.mContext);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.blc.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.blh.blb = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        this.blh.Rx = rect;
        this.blh.blP = bundle;
        view.setVisibility(4);
        a(this.blh);
        this.blc.setDragObject(this.blh);
        this.mVibrator.vibrate(300L);
    }

    public void endDrag() {
        if (this.blf) {
            this.blf = false;
            this.blh = null;
            this.bld.Sk();
            this.bld.Sl();
            this.blc.Sn();
            this.blc.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.Hc = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.blf;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.blf) {
            if (this.bli == null) {
                this.bli = new Rect();
                this.blc.getDrawingRect(this.bli);
                Rect rect = this.bli;
                rect.top = (int) (rect.top - this.blg);
                Rect rect2 = this.bli;
                rect2.bottom = (int) (rect2.bottom + this.blg);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.Hc = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.Hc = x;
                    this.blh.Rx.offset((int) (x - this.Hc), 0);
                    a(this.blh);
                    Sf();
                    break;
            }
            return true;
        }
        return false;
    }

    public void Sf() {
        this.mTempRect.set(this.blh.Rx);
        this.blc.offsetRectIntoDescendantCoords((View) this.bld, this.mTempRect);
        this.bld.d(this.mTempRect);
        this.blc.invalidate();
        if (this.blh.blQ) {
            this.bld.Si();
        } else if (this.blh.blR) {
            this.bld.Sj();
        } else {
            this.bld.Sk();
        }
    }

    private void a(e eVar) {
        eVar.blQ = false;
        eVar.blR = false;
        Rect rect = eVar.Rx;
        int width = rect.width();
        int width2 = (this.blc.getWidth() - this.blj) - this.blk;
        if (rect.left < this.blj) {
            rect.left = this.blj;
            rect.right = rect.left + width;
        }
        if (rect.right > this.blj + width2) {
            rect.right = this.blj + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.blj + this.blg) {
            eVar.blQ = true;
            eVar.blR = false;
        }
        if (rect.right > (this.blj + width2) - this.blg) {
            eVar.blQ = false;
            eVar.blR = true;
        }
    }

    public void a(g gVar) {
        this.bld = gVar;
    }

    public void a(f fVar) {
        this.ble = fVar;
        this.ble.setDragController(this);
    }
}
