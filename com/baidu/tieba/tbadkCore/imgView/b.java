package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    public float bFy;
    private Vibrator gZA;
    private e gZB;
    private d gZC;
    public boolean gZD;
    private float gZE;
    private c gZF;
    private Rect gZG;
    private int gZH;
    private int gZI;
    private DragLayer gZz;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.gZA = (Vibrator) context.getSystemService("vibrator");
        this.gZE = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.gZz = dragLayer;
        dragLayer.setDragController(this);
        this.gZH = this.gZz.getPaddingLeft();
        this.gZI = this.gZz.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.gZz != null && view != null && view.getDrawingCache() != null) {
            this.gZD = true;
            this.gZF = new c(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.gZz.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.gZF.bCr = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.gZF.rect = rect;
            this.gZF.hak = bundle;
            view.setVisibility(4);
            a(this.gZF);
            this.gZz.setDragObject(this.gZF);
            this.gZA.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.gZD) {
            this.gZD = false;
            this.gZF = null;
            this.gZB.bwg();
            this.gZB.bwh();
            this.gZz.bwj();
            this.gZz.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.bFy = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.gZD;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gZD) {
            if (this.gZG == null) {
                this.gZG = new Rect();
                this.gZz.getDrawingRect(this.gZG);
                Rect rect = this.gZG;
                rect.top = (int) (rect.top - this.gZE);
                Rect rect2 = this.gZG;
                rect2.bottom = (int) (rect2.bottom + this.gZE);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bFy = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.bFy = x;
                    this.gZF.rect.offset((int) (x - this.bFy), 0);
                    a(this.gZF);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.gZF.rect);
        this.gZz.offsetRectIntoDescendantCoords((View) this.gZB, this.mTempRect);
        this.gZB.n(this.mTempRect);
        this.gZz.invalidate();
        if (this.gZF.hal) {
            this.gZB.bwe();
        } else if (this.gZF.ham) {
            this.gZB.bwf();
        } else {
            this.gZB.bwg();
        }
    }

    private void a(c cVar) {
        cVar.hal = false;
        cVar.ham = false;
        Rect rect = cVar.rect;
        int width = rect.width();
        int width2 = (this.gZz.getWidth() - this.gZH) - this.gZI;
        if (rect.left < this.gZH) {
            rect.left = this.gZH;
            rect.right = rect.left + width;
        }
        if (rect.right > this.gZH + width2) {
            rect.right = this.gZH + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.gZH + this.gZE) {
            cVar.hal = true;
            cVar.ham = false;
        }
        if (rect.right > (this.gZH + width2) - this.gZE) {
            cVar.hal = false;
            cVar.ham = true;
        }
    }

    public void a(e eVar) {
        this.gZB = eVar;
    }

    public void a(d dVar) {
        this.gZC = dVar;
        this.gZC.setDragController(this);
    }
}
