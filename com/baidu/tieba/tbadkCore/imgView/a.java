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
    private Vibrator cUW;
    private DragLayer gPp;
    private d gPq;
    private c gPr;
    public boolean gPs;
    private float gPt;
    private b gPu;
    private Rect gPv;
    private int gPw;
    private int gPx;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.cUW = (Vibrator) context.getSystemService("vibrator");
        this.gPt = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.gPp = dragLayer;
        dragLayer.setDragController(this);
        this.gPw = this.gPp.getPaddingLeft();
        this.gPx = this.gPp.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.gPp != null && view != null && view.getDrawingCache() != null) {
            this.gPs = true;
            this.gPu = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.gPp.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.gPu.aXO = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.gPu.rect = rect;
            this.gPu.gPY = bundle;
            view.setVisibility(4);
            a(this.gPu);
            this.gPp.setDragObject(this.gPu);
            this.cUW.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.gPs) {
            this.gPs = false;
            this.gPu = null;
            this.gPq.bwE();
            this.gPq.bwF();
            this.gPp.bwH();
            this.gPp.invalidate();
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
        return this.gPs;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gPs) {
            if (this.gPv == null) {
                this.gPv = new Rect();
                this.gPp.getDrawingRect(this.gPv);
                Rect rect = this.gPv;
                rect.top = (int) (rect.top - this.gPt);
                Rect rect2 = this.gPv;
                rect2.bottom = (int) (rect2.bottom + this.gPt);
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
                    this.gPu.rect.offset((int) (x - this.baY), 0);
                    a(this.gPu);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.gPu.rect);
        this.gPp.offsetRectIntoDescendantCoords((View) this.gPq, this.mTempRect);
        this.gPq.l(this.mTempRect);
        this.gPp.invalidate();
        if (this.gPu.gPZ) {
            this.gPq.bwC();
        } else if (this.gPu.gQa) {
            this.gPq.bwD();
        } else {
            this.gPq.bwE();
        }
    }

    private void a(b bVar) {
        bVar.gPZ = false;
        bVar.gQa = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.gPp.getWidth() - this.gPw) - this.gPx;
        if (rect.left < this.gPw) {
            rect.left = this.gPw;
            rect.right = rect.left + width;
        }
        if (rect.right > this.gPw + width2) {
            rect.right = this.gPw + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.gPw + this.gPt) {
            bVar.gPZ = true;
            bVar.gQa = false;
        }
        if (rect.right > (this.gPw + width2) - this.gPt) {
            bVar.gPZ = false;
            bVar.gQa = true;
        }
    }

    public void a(d dVar) {
        this.gPq = dVar;
    }

    public void a(c cVar) {
        this.gPr = cVar;
        this.gPr.setDragController(this);
    }
}
