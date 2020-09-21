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
    public float cNy;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;
    private DragLayer mqk;
    private d mql;
    private c mqm;
    public boolean mqn;
    private float mqo;
    private b mqp;
    private Rect mqq;
    private int mqr;
    private int mqs;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.mqo = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.mqk = dragLayer;
        dragLayer.setDragController(this);
        this.mqr = this.mqk.getPaddingLeft();
        this.mqs = this.mqk.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.mqk != null && view != null && view.getDrawingCache() != null) {
            this.mqn = true;
            this.mqp = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.mqk.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.mqp.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.mqp.bry = rect;
            this.mqp.mqT = bundle;
            view.setVisibility(4);
            a(this.mqp);
            this.mqk.setDragObject(this.mqp);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.mqn) {
            this.mqn = false;
            this.mqp = null;
            this.mql.dBb();
            this.mql.dBc();
            this.mqk.dBe();
            this.mqk.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.cNy = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.mqn;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mqn) {
            if (this.mqq == null) {
                this.mqq = new Rect();
                this.mqk.getDrawingRect(this.mqq);
                Rect rect = this.mqq;
                rect.top = (int) (rect.top - this.mqo);
                Rect rect2 = this.mqq;
                rect2.bottom = (int) (rect2.bottom + this.mqo);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.cNy = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.cNy = x;
                    this.mqp.bry.offset((int) (x - this.cNy), 0);
                    a(this.mqp);
                    dAX();
                    break;
            }
            return true;
        }
        return false;
    }

    public void dAX() {
        this.mTempRect.set(this.mqp.bry);
        this.mqk.offsetRectIntoDescendantCoords((View) this.mql, this.mTempRect);
        this.mql.j(this.mTempRect);
        this.mqk.invalidate();
        if (this.mqp.mqU) {
            this.mql.dAZ();
        } else if (this.mqp.mqV) {
            this.mql.dBa();
        } else {
            this.mql.dBb();
        }
    }

    private void a(b bVar) {
        bVar.mqU = false;
        bVar.mqV = false;
        Rect rect = bVar.bry;
        int width = rect.width();
        int width2 = (this.mqk.getWidth() - this.mqr) - this.mqs;
        if (rect.left < this.mqr) {
            rect.left = this.mqr;
            rect.right = rect.left + width;
        }
        if (rect.right > this.mqr + width2) {
            rect.right = this.mqr + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.mqr + this.mqo) {
            bVar.mqU = true;
            bVar.mqV = false;
        }
        if (rect.right > (this.mqr + width2) - this.mqo) {
            bVar.mqU = false;
            bVar.mqV = true;
        }
    }

    public void a(d dVar) {
        this.mql = dVar;
    }

    public void a(c cVar) {
        this.mqm = cVar;
        this.mqm.setDragController(this);
    }
}
