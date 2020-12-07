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
    public float dtt;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;
    private DragLayer nnr;
    private d nns;
    private c nnt;
    public boolean nnu;
    private float nnv;
    private b nnw;
    private Rect nnx;
    private int nny;
    private int nnz;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.nnv = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.nnr = dragLayer;
        dragLayer.setDragController(this);
        this.nny = this.nnr.getPaddingLeft();
        this.nnz = this.nnr.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.nnr != null && view != null && view.getDrawingCache() != null) {
            this.nnu = true;
            this.nnw = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.nnr.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.nnw.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.nnw.bHi = rect;
            this.nnw.noa = bundle;
            view.setVisibility(4);
            a(this.nnw);
            this.nnr.setDragObject(this.nnw);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.nnu) {
            this.nnu = false;
            this.nnw = null;
            this.nns.dPE();
            this.nns.dPF();
            this.nnr.dPH();
            this.nnr.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.dtt = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.nnu;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nnu) {
            if (this.nnx == null) {
                this.nnx = new Rect();
                this.nnr.getDrawingRect(this.nnx);
                Rect rect = this.nnx;
                rect.top = (int) (rect.top - this.nnv);
                Rect rect2 = this.nnx;
                rect2.bottom = (int) (rect2.bottom + this.nnv);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.dtt = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.dtt = x;
                    this.nnw.bHi.offset((int) (x - this.dtt), 0);
                    a(this.nnw);
                    dPA();
                    break;
            }
            return true;
        }
        return false;
    }

    public void dPA() {
        this.mTempRect.set(this.nnw.bHi);
        this.nnr.offsetRectIntoDescendantCoords((View) this.nns, this.mTempRect);
        this.nns.j(this.mTempRect);
        this.nnr.invalidate();
        if (this.nnw.nob) {
            this.nns.dPC();
        } else if (this.nnw.noc) {
            this.nns.dPD();
        } else {
            this.nns.dPE();
        }
    }

    private void a(b bVar) {
        bVar.nob = false;
        bVar.noc = false;
        Rect rect = bVar.bHi;
        int width = rect.width();
        int width2 = (this.nnr.getWidth() - this.nny) - this.nnz;
        if (rect.left < this.nny) {
            rect.left = this.nny;
            rect.right = rect.left + width;
        }
        if (rect.right > this.nny + width2) {
            rect.right = this.nny + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.nny + this.nnv) {
            bVar.nob = true;
            bVar.noc = false;
        }
        if (rect.right > (this.nny + width2) - this.nnv) {
            bVar.nob = false;
            bVar.noc = true;
        }
    }

    public void a(d dVar) {
        this.nns = dVar;
    }

    public void a(c cVar) {
        this.nnt = cVar;
        this.nnt.setDragController(this);
    }
}
