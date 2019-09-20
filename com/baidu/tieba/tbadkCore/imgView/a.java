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
    public float aKd;
    private Vibrator aYA;
    private DragLayer jki;
    private d jkj;
    private c jkk;
    public boolean jkl;
    private float jkm;
    private b jkn;
    private Rect jko;
    private int jkp;
    private int jkq;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.aYA = (Vibrator) context.getSystemService("vibrator");
        this.jkm = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.jki = dragLayer;
        dragLayer.setDragController(this);
        this.jkp = this.jki.getPaddingLeft();
        this.jkq = this.jki.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.jki != null && view != null && view.getDrawingCache() != null) {
            this.jkl = true;
            this.jkn = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.jki.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.jkn.cFw = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.jkn.cyf = rect;
            this.jkn.jkQ = bundle;
            view.setVisibility(4);
            a(this.jkn);
            this.jki.setDragObject(this.jkn);
            this.aYA.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.jkl) {
            this.jkl = false;
            this.jkn = null;
            this.jkj.cqY();
            this.jkj.cqZ();
            this.jki.crb();
            this.jki.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.aKd = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.jkl;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jkl) {
            if (this.jko == null) {
                this.jko = new Rect();
                this.jki.getDrawingRect(this.jko);
                Rect rect = this.jko;
                rect.top = (int) (rect.top - this.jkm);
                Rect rect2 = this.jko;
                rect2.bottom = (int) (rect2.bottom + this.jkm);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.aKd = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.aKd = x;
                    this.jkn.cyf.offset((int) (x - this.aKd), 0);
                    a(this.jkn);
                    cqU();
                    break;
            }
            return true;
        }
        return false;
    }

    public void cqU() {
        this.mTempRect.set(this.jkn.cyf);
        this.jki.offsetRectIntoDescendantCoords((View) this.jkj, this.mTempRect);
        this.jkj.p(this.mTempRect);
        this.jki.invalidate();
        if (this.jkn.jkR) {
            this.jkj.cqW();
        } else if (this.jkn.jkS) {
            this.jkj.cqX();
        } else {
            this.jkj.cqY();
        }
    }

    private void a(b bVar) {
        bVar.jkR = false;
        bVar.jkS = false;
        Rect rect = bVar.cyf;
        int width = rect.width();
        int width2 = (this.jki.getWidth() - this.jkp) - this.jkq;
        if (rect.left < this.jkp) {
            rect.left = this.jkp;
            rect.right = rect.left + width;
        }
        if (rect.right > this.jkp + width2) {
            rect.right = this.jkp + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.jkp + this.jkm) {
            bVar.jkR = true;
            bVar.jkS = false;
        }
        if (rect.right > (this.jkp + width2) - this.jkm) {
            bVar.jkR = false;
            bVar.jkS = true;
        }
    }

    public void a(d dVar) {
        this.jkj = dVar;
    }

    public void a(c cVar) {
        this.jkk = cVar;
        this.jkk.setDragController(this);
    }
}
