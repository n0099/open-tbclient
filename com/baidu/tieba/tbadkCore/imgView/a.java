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
    private int nnA;
    private int nnB;
    private DragLayer nnt;
    private d nnu;
    private c nnv;
    public boolean nnw;
    private float nnx;
    private b nny;
    private Rect nnz;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.nnx = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.nnt = dragLayer;
        dragLayer.setDragController(this);
        this.nnA = this.nnt.getPaddingLeft();
        this.nnB = this.nnt.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.nnt != null && view != null && view.getDrawingCache() != null) {
            this.nnw = true;
            this.nny = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.nnt.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.nny.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.nny.bHi = rect;
            this.nny.noc = bundle;
            view.setVisibility(4);
            a(this.nny);
            this.nnt.setDragObject(this.nny);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.nnw) {
            this.nnw = false;
            this.nny = null;
            this.nnu.dPF();
            this.nnu.dPG();
            this.nnt.dPI();
            this.nnt.invalidate();
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
        return this.nnw;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nnw) {
            if (this.nnz == null) {
                this.nnz = new Rect();
                this.nnt.getDrawingRect(this.nnz);
                Rect rect = this.nnz;
                rect.top = (int) (rect.top - this.nnx);
                Rect rect2 = this.nnz;
                rect2.bottom = (int) (rect2.bottom + this.nnx);
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
                    this.nny.bHi.offset((int) (x - this.dtt), 0);
                    a(this.nny);
                    dPB();
                    break;
            }
            return true;
        }
        return false;
    }

    public void dPB() {
        this.mTempRect.set(this.nny.bHi);
        this.nnt.offsetRectIntoDescendantCoords((View) this.nnu, this.mTempRect);
        this.nnu.j(this.mTempRect);
        this.nnt.invalidate();
        if (this.nny.nod) {
            this.nnu.dPD();
        } else if (this.nny.noe) {
            this.nnu.dPE();
        } else {
            this.nnu.dPF();
        }
    }

    private void a(b bVar) {
        bVar.nod = false;
        bVar.noe = false;
        Rect rect = bVar.bHi;
        int width = rect.width();
        int width2 = (this.nnt.getWidth() - this.nnA) - this.nnB;
        if (rect.left < this.nnA) {
            rect.left = this.nnA;
            rect.right = rect.left + width;
        }
        if (rect.right > this.nnA + width2) {
            rect.right = this.nnA + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.nnA + this.nnx) {
            bVar.nod = true;
            bVar.noe = false;
        }
        if (rect.right > (this.nnA + width2) - this.nnx) {
            bVar.nod = false;
            bVar.noe = true;
        }
    }

    public void a(d dVar) {
        this.nnu = dVar;
    }

    public void a(c cVar) {
        this.nnv = cVar;
        this.nnv.setDragController(this);
    }
}
