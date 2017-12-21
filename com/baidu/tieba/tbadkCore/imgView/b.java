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
    public float aRD;
    private DragLayer gDk;
    private Vibrator gDl;
    private e gDm;
    private d gDn;
    public boolean gDo;
    private float gDp;
    private c gDq;
    private Rect gDr;
    private int gDs;
    private int gDt;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.gDl = (Vibrator) context.getSystemService("vibrator");
        this.gDp = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.gDk = dragLayer;
        dragLayer.setDragController(this);
        this.gDs = this.gDk.getPaddingLeft();
        this.gDt = this.gDk.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.gDk != null && view != null && view.getDrawingCache() != null) {
            this.gDo = true;
            this.gDq = new c(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.gDk.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.gDq.aOv = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.gDq.rect = rect;
            this.gDq.gDV = bundle;
            view.setVisibility(4);
            a(this.gDq);
            this.gDk.setDragObject(this.gDq);
            this.gDl.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.gDo) {
            this.gDo = false;
            this.gDq = null;
            this.gDm.bxu();
            this.gDm.bxv();
            this.gDk.bxx();
            this.gDk.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.aRD = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.gDo;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gDo) {
            if (this.gDr == null) {
                this.gDr = new Rect();
                this.gDk.getDrawingRect(this.gDr);
                Rect rect = this.gDr;
                rect.top = (int) (rect.top - this.gDp);
                Rect rect2 = this.gDr;
                rect2.bottom = (int) (rect2.bottom + this.gDp);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.aRD = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.aRD = x;
                    this.gDq.rect.offset((int) (x - this.aRD), 0);
                    a(this.gDq);
                    bxq();
                    break;
            }
            return true;
        }
        return false;
    }

    public void bxq() {
        this.mTempRect.set(this.gDq.rect);
        this.gDk.offsetRectIntoDescendantCoords((View) this.gDm, this.mTempRect);
        this.gDm.j(this.mTempRect);
        this.gDk.invalidate();
        if (this.gDq.gDW) {
            this.gDm.bxs();
        } else if (this.gDq.gDX) {
            this.gDm.bxt();
        } else {
            this.gDm.bxu();
        }
    }

    private void a(c cVar) {
        cVar.gDW = false;
        cVar.gDX = false;
        Rect rect = cVar.rect;
        int width = rect.width();
        int width2 = (this.gDk.getWidth() - this.gDs) - this.gDt;
        if (rect.left < this.gDs) {
            rect.left = this.gDs;
            rect.right = rect.left + width;
        }
        if (rect.right > this.gDs + width2) {
            rect.right = this.gDs + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.gDs + this.gDp) {
            cVar.gDW = true;
            cVar.gDX = false;
        }
        if (rect.right > (this.gDs + width2) - this.gDp) {
            cVar.gDW = false;
            cVar.gDX = true;
        }
    }

    public void a(e eVar) {
        this.gDm = eVar;
    }

    public void a(d dVar) {
        this.gDn = dVar;
        this.gDn.setDragController(this);
    }
}
