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
    private int gkA;
    private DragLayer gkq;
    private Vibrator gkr;
    private e gks;
    private d gkt;
    public boolean gku;
    public float gkv;
    private float gkw;
    private c gkx;
    private Rect gky;
    private int gkz;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.gkr = (Vibrator) context.getSystemService("vibrator");
        this.gkw = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.gkq = dragLayer;
        dragLayer.setDragController(this);
        this.gkz = this.gkq.getPaddingLeft();
        this.gkA = this.gkq.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.gkq != null && view != null && view.getDrawingCache() != null) {
            this.gku = true;
            this.gkx = new c(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.gkq.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.gkx.aNA = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.gkx.rect = rect;
            this.gkx.glc = bundle;
            view.setVisibility(4);
            a(this.gkx);
            this.gkq.setDragObject(this.gkx);
            this.gkr.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.gku) {
            this.gku = false;
            this.gkx = null;
            this.gks.bsW();
            this.gks.bsX();
            this.gkq.bsZ();
            this.gkq.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.gkv = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.gku;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gku) {
            if (this.gky == null) {
                this.gky = new Rect();
                this.gkq.getDrawingRect(this.gky);
                Rect rect = this.gky;
                rect.top = (int) (rect.top - this.gkw);
                Rect rect2 = this.gky;
                rect2.bottom = (int) (rect2.bottom + this.gkw);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.gkv = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.gkv = x;
                    this.gkx.rect.offset((int) (x - this.gkv), 0);
                    a(this.gkx);
                    bsS();
                    break;
            }
            return true;
        }
        return false;
    }

    public void bsS() {
        this.mTempRect.set(this.gkx.rect);
        this.gkq.offsetRectIntoDescendantCoords((View) this.gks, this.mTempRect);
        this.gks.e(this.mTempRect);
        this.gkq.invalidate();
        if (this.gkx.gld) {
            this.gks.bsU();
        } else if (this.gkx.gle) {
            this.gks.bsV();
        } else {
            this.gks.bsW();
        }
    }

    private void a(c cVar) {
        cVar.gld = false;
        cVar.gle = false;
        Rect rect = cVar.rect;
        int width = rect.width();
        int width2 = (this.gkq.getWidth() - this.gkz) - this.gkA;
        if (rect.left < this.gkz) {
            rect.left = this.gkz;
            rect.right = rect.left + width;
        }
        if (rect.right > this.gkz + width2) {
            rect.right = this.gkz + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.gkz + this.gkw) {
            cVar.gld = true;
            cVar.gle = false;
        }
        if (rect.right > (this.gkz + width2) - this.gkw) {
            cVar.gld = false;
            cVar.gle = true;
        }
    }

    public void a(e eVar) {
        this.gks = eVar;
    }

    public void a(d dVar) {
        this.gkt = dVar;
        this.gkt.setDragController(this);
    }
}
