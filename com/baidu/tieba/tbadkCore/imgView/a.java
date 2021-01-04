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
    private Vibrator dPV;
    public float dyT;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private DragLayer ntg;
    private d nth;
    private c nti;
    public boolean ntj;
    private float ntk;
    private b ntl;
    private Rect ntm;
    private int ntn;
    private int nto;

    public a(Context context) {
        this.mContext = context;
        this.dPV = (Vibrator) context.getSystemService("vibrator");
        this.ntk = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.ntg = dragLayer;
        dragLayer.setDragController(this);
        this.ntn = this.ntg.getPaddingLeft();
        this.nto = this.ntg.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.ntg != null && view != null && view.getDrawingCache() != null) {
            this.ntj = true;
            this.ntl = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.ntg.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.ntl.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.ntl.rect = rect;
            this.ntl.ntN = bundle;
            view.setVisibility(4);
            a(this.ntl);
            this.ntg.setDragObject(this.ntl);
            this.dPV.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.ntj) {
            this.ntj = false;
            this.ntl = null;
            this.nth.dPB();
            this.nth.dPC();
            this.ntg.dPE();
            this.ntg.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.dyT = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.ntj;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ntj) {
            if (this.ntm == null) {
                this.ntm = new Rect();
                this.ntg.getDrawingRect(this.ntm);
                Rect rect = this.ntm;
                rect.top = (int) (rect.top - this.ntk);
                Rect rect2 = this.ntm;
                rect2.bottom = (int) (rect2.bottom + this.ntk);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.dyT = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.dyT = x;
                    this.ntl.rect.offset((int) (x - this.dyT), 0);
                    a(this.ntl);
                    dPx();
                    break;
            }
            return true;
        }
        return false;
    }

    public void dPx() {
        this.mTempRect.set(this.ntl.rect);
        this.ntg.offsetRectIntoDescendantCoords((View) this.nth, this.mTempRect);
        this.nth.i(this.mTempRect);
        this.ntg.invalidate();
        if (this.ntl.ntO) {
            this.nth.dPz();
        } else if (this.ntl.ntP) {
            this.nth.dPA();
        } else {
            this.nth.dPB();
        }
    }

    private void a(b bVar) {
        bVar.ntO = false;
        bVar.ntP = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.ntg.getWidth() - this.ntn) - this.nto;
        if (rect.left < this.ntn) {
            rect.left = this.ntn;
            rect.right = rect.left + width;
        }
        if (rect.right > this.ntn + width2) {
            rect.right = this.ntn + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.ntn + this.ntk) {
            bVar.ntO = true;
            bVar.ntP = false;
        }
        if (rect.right > (this.ntn + width2) - this.ntk) {
            bVar.ntO = false;
            bVar.ntP = true;
        }
    }

    public void a(d dVar) {
        this.nth = dVar;
    }

    public void a(c cVar) {
        this.nti = cVar;
        this.nti.setDragController(this);
    }
}
