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
    private Vibrator dNn;
    public float dwp;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private DragLayer nyk;
    private d nyl;
    private c nym;
    public boolean nyn;
    private float nyo;
    private b nyp;
    private Rect nyq;
    private int nyr;
    private int nys;

    public a(Context context) {
        this.mContext = context;
        this.dNn = (Vibrator) context.getSystemService("vibrator");
        this.nyo = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.nyk = dragLayer;
        dragLayer.setDragController(this);
        this.nyr = this.nyk.getPaddingLeft();
        this.nys = this.nyk.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.nyk != null && view != null && view.getDrawingCache() != null) {
            this.nyn = true;
            this.nyp = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.nyk.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.nyp.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.nyp.rect = rect;
            this.nyp.nyR = bundle;
            view.setVisibility(4);
            a(this.nyp);
            this.nyk.setDragObject(this.nyp);
            this.dNn.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.nyn) {
            this.nyn = false;
            this.nyp = null;
            this.nyl.dNV();
            this.nyl.dNW();
            this.nyk.dNY();
            this.nyk.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.dwp = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.nyn;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nyn) {
            if (this.nyq == null) {
                this.nyq = new Rect();
                this.nyk.getDrawingRect(this.nyq);
                Rect rect = this.nyq;
                rect.top = (int) (rect.top - this.nyo);
                Rect rect2 = this.nyq;
                rect2.bottom = (int) (rect2.bottom + this.nyo);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.dwp = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.dwp = x;
                    this.nyp.rect.offset((int) (x - this.dwp), 0);
                    a(this.nyp);
                    dNR();
                    break;
            }
            return true;
        }
        return false;
    }

    public void dNR() {
        this.mTempRect.set(this.nyp.rect);
        this.nyk.offsetRectIntoDescendantCoords((View) this.nyl, this.mTempRect);
        this.nyl.i(this.mTempRect);
        this.nyk.invalidate();
        if (this.nyp.nyS) {
            this.nyl.dNT();
        } else if (this.nyp.nyT) {
            this.nyl.dNU();
        } else {
            this.nyl.dNV();
        }
    }

    private void a(b bVar) {
        bVar.nyS = false;
        bVar.nyT = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.nyk.getWidth() - this.nyr) - this.nys;
        if (rect.left < this.nyr) {
            rect.left = this.nyr;
            rect.right = rect.left + width;
        }
        if (rect.right > this.nyr + width2) {
            rect.right = this.nyr + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.nyr + this.nyo) {
            bVar.nyS = true;
            bVar.nyT = false;
        }
        if (rect.right > (this.nyr + width2) - this.nyo) {
            bVar.nyS = false;
            bVar.nyT = true;
        }
    }

    public void a(d dVar) {
        this.nyl = dVar;
    }

    public void a(c cVar) {
        this.nym = cVar;
        this.nym.setDragController(this);
    }
}
