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
    public float bHA;
    private DragLayer hcq;
    private Vibrator hcr;
    private e hcs;
    private d hct;
    public boolean hcu;
    private float hcv;
    private c hcw;
    private Rect hcx;
    private int hcy;
    private int hcz;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.hcr = (Vibrator) context.getSystemService("vibrator");
        this.hcv = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.hcq = dragLayer;
        dragLayer.setDragController(this);
        this.hcy = this.hcq.getPaddingLeft();
        this.hcz = this.hcq.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.hcq != null && view != null && view.getDrawingCache() != null) {
            this.hcu = true;
            this.hcw = new c(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.hcq.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.hcw.bEt = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.hcw.rect = rect;
            this.hcw.hdb = bundle;
            view.setVisibility(4);
            a(this.hcw);
            this.hcq.setDragObject(this.hcw);
            this.hcr.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.hcu) {
            this.hcu = false;
            this.hcw = null;
            this.hcs.bxv();
            this.hcs.bxw();
            this.hcq.bxy();
            this.hcq.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.bHA = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.hcu;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hcu) {
            if (this.hcx == null) {
                this.hcx = new Rect();
                this.hcq.getDrawingRect(this.hcx);
                Rect rect = this.hcx;
                rect.top = (int) (rect.top - this.hcv);
                Rect rect2 = this.hcx;
                rect2.bottom = (int) (rect2.bottom + this.hcv);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bHA = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.bHA = x;
                    this.hcw.rect.offset((int) (x - this.bHA), 0);
                    a(this.hcw);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.hcw.rect);
        this.hcq.offsetRectIntoDescendantCoords((View) this.hcs, this.mTempRect);
        this.hcs.o(this.mTempRect);
        this.hcq.invalidate();
        if (this.hcw.hdc) {
            this.hcs.bxt();
        } else if (this.hcw.hdd) {
            this.hcs.bxu();
        } else {
            this.hcs.bxv();
        }
    }

    private void a(c cVar) {
        cVar.hdc = false;
        cVar.hdd = false;
        Rect rect = cVar.rect;
        int width = rect.width();
        int width2 = (this.hcq.getWidth() - this.hcy) - this.hcz;
        if (rect.left < this.hcy) {
            rect.left = this.hcy;
            rect.right = rect.left + width;
        }
        if (rect.right > this.hcy + width2) {
            rect.right = this.hcy + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.hcy + this.hcv) {
            cVar.hdc = true;
            cVar.hdd = false;
        }
        if (rect.right > (this.hcy + width2) - this.hcv) {
            cVar.hdc = false;
            cVar.hdd = true;
        }
    }

    public void a(e eVar) {
        this.hcs = eVar;
    }

    public void a(d dVar) {
        this.hct = dVar;
        this.hct.setDragController(this);
    }
}
