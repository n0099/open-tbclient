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
    public float baY;
    private Vibrator cUS;
    private DragLayer gPq;
    private d gPr;
    private c gPs;
    public boolean gPt;
    private float gPu;
    private b gPv;
    private Rect gPw;
    private int gPx;
    private int gPy;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.cUS = (Vibrator) context.getSystemService("vibrator");
        this.gPu = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.gPq = dragLayer;
        dragLayer.setDragController(this);
        this.gPx = this.gPq.getPaddingLeft();
        this.gPy = this.gPq.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.gPq != null && view != null && view.getDrawingCache() != null) {
            this.gPt = true;
            this.gPv = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.gPq.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.gPv.aXO = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.gPv.rect = rect;
            this.gPv.gPZ = bundle;
            view.setVisibility(4);
            a(this.gPv);
            this.gPq.setDragObject(this.gPv);
            this.cUS.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.gPt) {
            this.gPt = false;
            this.gPv = null;
            this.gPr.bwF();
            this.gPr.bwG();
            this.gPq.bwI();
            this.gPq.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.baY = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.gPt;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gPt) {
            if (this.gPw == null) {
                this.gPw = new Rect();
                this.gPq.getDrawingRect(this.gPw);
                Rect rect = this.gPw;
                rect.top = (int) (rect.top - this.gPu);
                Rect rect2 = this.gPw;
                rect2.bottom = (int) (rect2.bottom + this.gPu);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.baY = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.baY = x;
                    this.gPv.rect.offset((int) (x - this.baY), 0);
                    a(this.gPv);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.gPv.rect);
        this.gPq.offsetRectIntoDescendantCoords((View) this.gPr, this.mTempRect);
        this.gPr.l(this.mTempRect);
        this.gPq.invalidate();
        if (this.gPv.gQa) {
            this.gPr.bwD();
        } else if (this.gPv.gQb) {
            this.gPr.bwE();
        } else {
            this.gPr.bwF();
        }
    }

    private void a(b bVar) {
        bVar.gQa = false;
        bVar.gQb = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.gPq.getWidth() - this.gPx) - this.gPy;
        if (rect.left < this.gPx) {
            rect.left = this.gPx;
            rect.right = rect.left + width;
        }
        if (rect.right > this.gPx + width2) {
            rect.right = this.gPx + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.gPx + this.gPu) {
            bVar.gQa = true;
            bVar.gQb = false;
        }
        if (rect.right > (this.gPx + width2) - this.gPu) {
            bVar.gQa = false;
            bVar.gQb = true;
        }
    }

    public void a(d dVar) {
        this.gPr = dVar;
    }

    public void a(c cVar) {
        this.gPs = cVar;
        this.gPs.setDragController(this);
    }
}
