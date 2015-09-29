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
    public float bkT;
    private float cZA;
    private d cZB;
    private Rect cZC;
    private int cZD;
    private int cZE;
    private DragLayer cZv;
    private Vibrator cZw;
    private f cZx;
    private e cZy;
    public boolean cZz;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.cZw = (Vibrator) context.getSystemService("vibrator");
        this.cZA = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.cZv = dragLayer;
        dragLayer.setDragController(this);
        this.cZD = this.cZv.getPaddingLeft();
        this.cZE = this.cZv.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        this.cZz = true;
        this.cZB = new d(this.mContext);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.cZv.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.cZB.aAz = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        this.cZB.apC = rect;
        this.cZB.dah = bundle;
        view.setVisibility(4);
        a(this.cZB);
        this.cZv.setDragObject(this.cZB);
        this.cZw.vibrate(300L);
    }

    public void endDrag() {
        if (this.cZz) {
            this.cZz = false;
            this.cZB = null;
            this.cZx.awU();
            this.cZx.awV();
            this.cZv.awX();
            this.cZv.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.bkT = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.cZz;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cZz) {
            if (this.cZC == null) {
                this.cZC = new Rect();
                this.cZv.getDrawingRect(this.cZC);
                Rect rect = this.cZC;
                rect.top = (int) (rect.top - this.cZA);
                Rect rect2 = this.cZC;
                rect2.bottom = (int) (rect2.bottom + this.cZA);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.bkT = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.bkT = x;
                    this.cZB.apC.offset((int) (x - this.bkT), 0);
                    a(this.cZB);
                    awQ();
                    break;
            }
            return true;
        }
        return false;
    }

    public void awQ() {
        this.mTempRect.set(this.cZB.apC);
        this.cZv.offsetRectIntoDescendantCoords((View) this.cZx, this.mTempRect);
        this.cZx.d(this.mTempRect);
        this.cZv.invalidate();
        if (this.cZB.dai) {
            this.cZx.awS();
        } else if (this.cZB.daj) {
            this.cZx.awT();
        } else {
            this.cZx.awU();
        }
    }

    private void a(d dVar) {
        dVar.dai = false;
        dVar.daj = false;
        Rect rect = dVar.apC;
        int width = rect.width();
        int width2 = (this.cZv.getWidth() - this.cZD) - this.cZE;
        if (rect.left < this.cZD) {
            rect.left = this.cZD;
            rect.right = rect.left + width;
        }
        if (rect.right > this.cZD + width2) {
            rect.right = this.cZD + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.cZD + this.cZA) {
            dVar.dai = true;
            dVar.daj = false;
        }
        if (rect.right > (this.cZD + width2) - this.cZA) {
            dVar.dai = false;
            dVar.daj = true;
        }
    }

    public void a(f fVar) {
        this.cZx = fVar;
    }

    public void a(e eVar) {
        this.cZy = eVar;
        this.cZy.setDragController(this);
    }
}
