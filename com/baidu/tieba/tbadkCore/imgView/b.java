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
    public float bFq;
    private DragLayer hjZ;
    private Vibrator hka;
    private e hkb;
    private d hkc;
    public boolean hkd;
    private float hke;
    private c hkf;
    private Rect hkg;
    private int hkh;
    private int hki;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.hka = (Vibrator) context.getSystemService("vibrator");
        this.hke = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.hjZ = dragLayer;
        dragLayer.setDragController(this);
        this.hkh = this.hjZ.getPaddingLeft();
        this.hki = this.hjZ.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.hjZ != null && view != null && view.getDrawingCache() != null) {
            this.hkd = true;
            this.hkf = new c(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.hjZ.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.hkf.bCi = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.hkf.rect = rect;
            this.hkf.hkJ = bundle;
            view.setVisibility(4);
            a(this.hkf);
            this.hjZ.setDragObject(this.hkf);
            this.hka.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.hkd) {
            this.hkd = false;
            this.hkf = null;
            this.hkb.bCK();
            this.hkb.bCL();
            this.hjZ.bCN();
            this.hjZ.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.bFq = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.hkd;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hkd) {
            if (this.hkg == null) {
                this.hkg = new Rect();
                this.hjZ.getDrawingRect(this.hkg);
                Rect rect = this.hkg;
                rect.top = (int) (rect.top - this.hke);
                Rect rect2 = this.hkg;
                rect2.bottom = (int) (rect2.bottom + this.hke);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bFq = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.bFq = x;
                    this.hkf.rect.offset((int) (x - this.bFq), 0);
                    a(this.hkf);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.hkf.rect);
        this.hjZ.offsetRectIntoDescendantCoords((View) this.hkb, this.mTempRect);
        this.hkb.n(this.mTempRect);
        this.hjZ.invalidate();
        if (this.hkf.hkK) {
            this.hkb.bCI();
        } else if (this.hkf.hkL) {
            this.hkb.bCJ();
        } else {
            this.hkb.bCK();
        }
    }

    private void a(c cVar) {
        cVar.hkK = false;
        cVar.hkL = false;
        Rect rect = cVar.rect;
        int width = rect.width();
        int width2 = (this.hjZ.getWidth() - this.hkh) - this.hki;
        if (rect.left < this.hkh) {
            rect.left = this.hkh;
            rect.right = rect.left + width;
        }
        if (rect.right > this.hkh + width2) {
            rect.right = this.hkh + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.hkh + this.hke) {
            cVar.hkK = true;
            cVar.hkL = false;
        }
        if (rect.right > (this.hkh + width2) - this.hke) {
            cVar.hkK = false;
            cVar.hkL = true;
        }
    }

    public void a(e eVar) {
        this.hkb = eVar;
    }

    public void a(d dVar) {
        this.hkc = dVar;
        this.hkc.setDragController(this);
    }
}
