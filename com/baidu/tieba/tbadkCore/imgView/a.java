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
    public float aHd;
    private Vibrator aUv;
    private DragLayer iHo;
    private d iHp;
    private c iHq;
    public boolean iHr;
    private float iHs;
    private b iHt;
    private Rect iHu;
    private int iHv;
    private int iHw;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.aUv = (Vibrator) context.getSystemService("vibrator");
        this.iHs = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.iHo = dragLayer;
        dragLayer.setDragController(this);
        this.iHv = this.iHo.getPaddingLeft();
        this.iHw = this.iHo.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.iHo != null && view != null && view.getDrawingCache() != null) {
            this.iHr = true;
            this.iHt = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.iHo.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.iHt.cuW = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.iHt.rect = rect;
            this.iHt.iHW = bundle;
            view.setVisibility(4);
            a(this.iHt);
            this.iHo.setDragObject(this.iHt);
            this.aUv.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.iHr) {
            this.iHr = false;
            this.iHt = null;
            this.iHp.ceN();
            this.iHp.ceO();
            this.iHo.ceQ();
            this.iHo.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.aHd = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.iHr;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.iHr) {
            if (this.iHu == null) {
                this.iHu = new Rect();
                this.iHo.getDrawingRect(this.iHu);
                Rect rect = this.iHu;
                rect.top = (int) (rect.top - this.iHs);
                Rect rect2 = this.iHu;
                rect2.bottom = (int) (rect2.bottom + this.iHs);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.aHd = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.aHd = x;
                    this.iHt.rect.offset((int) (x - this.aHd), 0);
                    a(this.iHt);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.iHt.rect);
        this.iHo.offsetRectIntoDescendantCoords((View) this.iHp, this.mTempRect);
        this.iHp.n(this.mTempRect);
        this.iHo.invalidate();
        if (this.iHt.iHX) {
            this.iHp.ceL();
        } else if (this.iHt.iHY) {
            this.iHp.ceM();
        } else {
            this.iHp.ceN();
        }
    }

    private void a(b bVar) {
        bVar.iHX = false;
        bVar.iHY = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.iHo.getWidth() - this.iHv) - this.iHw;
        if (rect.left < this.iHv) {
            rect.left = this.iHv;
            rect.right = rect.left + width;
        }
        if (rect.right > this.iHv + width2) {
            rect.right = this.iHv + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.iHv + this.iHs) {
            bVar.iHX = true;
            bVar.iHY = false;
        }
        if (rect.right > (this.iHv + width2) - this.iHs) {
            bVar.iHX = false;
            bVar.iHY = true;
        }
    }

    public void a(d dVar) {
        this.iHp = dVar;
    }

    public void a(c cVar) {
        this.iHq = cVar;
        this.iHq.setDragController(this);
    }
}
