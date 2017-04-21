package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    public float eZU;
    private DragLayer fzo;
    private Vibrator fzp;
    private g fzq;
    private f fzr;
    public boolean fzs;
    private float fzt;
    private e fzu;
    private Rect fzv;
    private int fzw;
    private int fzx;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.fzp = (Vibrator) context.getSystemService("vibrator");
        this.fzt = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.fzo = dragLayer;
        dragLayer.setDragController(this);
        this.fzw = this.fzo.getPaddingLeft();
        this.fzx = this.fzo.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.fzo != null && view != null && view.getDrawingCache() != null) {
            this.fzs = true;
            this.fzu = new e(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.fzo.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.fzu.aKl = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.fzu.rect = rect;
            this.fzu.fzY = bundle;
            view.setVisibility(4);
            a(this.fzu);
            this.fzo.setDragObject(this.fzu);
            this.fzp.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.fzs) {
            this.fzs = false;
            this.fzu = null;
            this.fzq.bjM();
            this.fzq.bjN();
            this.fzo.bjP();
            this.fzo.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.eZU = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.fzs;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.fzs) {
            if (this.fzv == null) {
                this.fzv = new Rect();
                this.fzo.getDrawingRect(this.fzv);
                Rect rect = this.fzv;
                rect.top = (int) (rect.top - this.fzt);
                Rect rect2 = this.fzv;
                rect2.bottom = (int) (rect2.bottom + this.fzt);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.eZU = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.eZU = x;
                    this.fzu.rect.offset((int) (x - this.eZU), 0);
                    a(this.fzu);
                    bjI();
                    break;
            }
            return true;
        }
        return false;
    }

    public void bjI() {
        this.mTempRect.set(this.fzu.rect);
        this.fzo.offsetRectIntoDescendantCoords((View) this.fzq, this.mTempRect);
        this.fzq.e(this.mTempRect);
        this.fzo.invalidate();
        if (this.fzu.fzZ) {
            this.fzq.bjK();
        } else if (this.fzu.fAa) {
            this.fzq.bjL();
        } else {
            this.fzq.bjM();
        }
    }

    private void a(e eVar) {
        eVar.fzZ = false;
        eVar.fAa = false;
        Rect rect = eVar.rect;
        int width = rect.width();
        int width2 = (this.fzo.getWidth() - this.fzw) - this.fzx;
        if (rect.left < this.fzw) {
            rect.left = this.fzw;
            rect.right = rect.left + width;
        }
        if (rect.right > this.fzw + width2) {
            rect.right = this.fzw + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.fzw + this.fzt) {
            eVar.fzZ = true;
            eVar.fAa = false;
        }
        if (rect.right > (this.fzw + width2) - this.fzt) {
            eVar.fzZ = false;
            eVar.fAa = true;
        }
    }

    public void a(g gVar) {
        this.fzq = gVar;
    }

    public void a(f fVar) {
        this.fzr = fVar;
        this.fzr.setDragController(this);
    }
}
