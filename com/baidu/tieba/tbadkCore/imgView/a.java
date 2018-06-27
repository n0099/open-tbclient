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
    public float baR;
    private Vibrator cSj;
    private DragLayer gOr;
    private d gOs;
    private c gOt;
    public boolean gOu;
    private float gOv;
    private b gOw;
    private Rect gOx;
    private int gOy;
    private int gOz;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.cSj = (Vibrator) context.getSystemService("vibrator");
        this.gOv = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.gOr = dragLayer;
        dragLayer.setDragController(this);
        this.gOy = this.gOr.getPaddingLeft();
        this.gOz = this.gOr.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.gOr != null && view != null && view.getDrawingCache() != null) {
            this.gOu = true;
            this.gOw = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.gOr.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.gOw.aXI = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.gOw.rect = rect;
            this.gOw.gPa = bundle;
            view.setVisibility(4);
            a(this.gOw);
            this.gOr.setDragObject(this.gOw);
            this.cSj.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.gOu) {
            this.gOu = false;
            this.gOw = null;
            this.gOs.byb();
            this.gOs.byc();
            this.gOr.bye();
            this.gOr.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.baR = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.gOu;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gOu) {
            if (this.gOx == null) {
                this.gOx = new Rect();
                this.gOr.getDrawingRect(this.gOx);
                Rect rect = this.gOx;
                rect.top = (int) (rect.top - this.gOv);
                Rect rect2 = this.gOx;
                rect2.bottom = (int) (rect2.bottom + this.gOv);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.baR = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.baR = x;
                    this.gOw.rect.offset((int) (x - this.baR), 0);
                    a(this.gOw);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.gOw.rect);
        this.gOr.offsetRectIntoDescendantCoords((View) this.gOs, this.mTempRect);
        this.gOs.k(this.mTempRect);
        this.gOr.invalidate();
        if (this.gOw.gPb) {
            this.gOs.bxZ();
        } else if (this.gOw.gPc) {
            this.gOs.bya();
        } else {
            this.gOs.byb();
        }
    }

    private void a(b bVar) {
        bVar.gPb = false;
        bVar.gPc = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.gOr.getWidth() - this.gOy) - this.gOz;
        if (rect.left < this.gOy) {
            rect.left = this.gOy;
            rect.right = rect.left + width;
        }
        if (rect.right > this.gOy + width2) {
            rect.right = this.gOy + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.gOy + this.gOv) {
            bVar.gPb = true;
            bVar.gPc = false;
        }
        if (rect.right > (this.gOy + width2) - this.gOv) {
            bVar.gPb = false;
            bVar.gPc = true;
        }
    }

    public void a(d dVar) {
        this.gOs = dVar;
    }

    public void a(c cVar) {
        this.gOt = cVar;
        this.gOt.setDragController(this);
    }
}
