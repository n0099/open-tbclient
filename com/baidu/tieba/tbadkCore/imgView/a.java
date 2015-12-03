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
    public float btn;
    private Rect dAA;
    private int dAB;
    private int dAC;
    private DragLayer dAt;
    private Vibrator dAu;
    private f dAv;
    private e dAw;
    public boolean dAx;
    private float dAy;
    private d dAz;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.dAu = (Vibrator) context.getSystemService("vibrator");
        this.dAy = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.dAt = dragLayer;
        dragLayer.setDragController(this);
        this.dAB = this.dAt.getPaddingLeft();
        this.dAC = this.dAt.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.dAt != null && view != null && view.getDrawingCache() != null) {
            this.dAx = true;
            this.dAz = new d(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.dAt.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.dAz.aBE = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.dAz.rect = rect;
            this.dAz.dBf = bundle;
            view.setVisibility(4);
            a(this.dAz);
            this.dAt.setDragObject(this.dAz);
            this.dAu.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.dAx) {
            this.dAx = false;
            this.dAz = null;
            this.dAv.aDB();
            this.dAv.aDC();
            this.dAt.aDE();
            this.dAt.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.btn = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.dAx;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dAx) {
            if (this.dAA == null) {
                this.dAA = new Rect();
                this.dAt.getDrawingRect(this.dAA);
                Rect rect = this.dAA;
                rect.top = (int) (rect.top - this.dAy);
                Rect rect2 = this.dAA;
                rect2.bottom = (int) (rect2.bottom + this.dAy);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.btn = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.btn = x;
                    this.dAz.rect.offset((int) (x - this.btn), 0);
                    a(this.dAz);
                    aDx();
                    break;
            }
            return true;
        }
        return false;
    }

    public void aDx() {
        this.mTempRect.set(this.dAz.rect);
        this.dAt.offsetRectIntoDescendantCoords((View) this.dAv, this.mTempRect);
        this.dAv.d(this.mTempRect);
        this.dAt.invalidate();
        if (this.dAz.dBg) {
            this.dAv.aDz();
        } else if (this.dAz.dBh) {
            this.dAv.aDA();
        } else {
            this.dAv.aDB();
        }
    }

    private void a(d dVar) {
        dVar.dBg = false;
        dVar.dBh = false;
        Rect rect = dVar.rect;
        int width = rect.width();
        int width2 = (this.dAt.getWidth() - this.dAB) - this.dAC;
        if (rect.left < this.dAB) {
            rect.left = this.dAB;
            rect.right = rect.left + width;
        }
        if (rect.right > this.dAB + width2) {
            rect.right = this.dAB + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.dAB + this.dAy) {
            dVar.dBg = true;
            dVar.dBh = false;
        }
        if (rect.right > (this.dAB + width2) - this.dAy) {
            dVar.dBg = false;
            dVar.dBh = true;
        }
    }

    public void a(f fVar) {
        this.dAv = fVar;
    }

    public void a(e eVar) {
        this.dAw = eVar;
        this.dAw.setDragController(this);
    }
}
