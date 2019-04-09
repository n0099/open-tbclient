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
    public float aHe;
    private Vibrator aUw;
    private DragLayer iHp;
    private d iHq;
    private c iHr;
    public boolean iHs;
    private float iHt;
    private b iHu;
    private Rect iHv;
    private int iHw;
    private int iHx;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.aUw = (Vibrator) context.getSystemService("vibrator");
        this.iHt = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.iHp = dragLayer;
        dragLayer.setDragController(this);
        this.iHw = this.iHp.getPaddingLeft();
        this.iHx = this.iHp.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.iHp != null && view != null && view.getDrawingCache() != null) {
            this.iHs = true;
            this.iHu = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.iHp.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.iHu.cuX = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.iHu.rect = rect;
            this.iHu.iHX = bundle;
            view.setVisibility(4);
            a(this.iHu);
            this.iHp.setDragObject(this.iHu);
            this.aUw.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.iHs) {
            this.iHs = false;
            this.iHu = null;
            this.iHq.ceN();
            this.iHq.ceO();
            this.iHp.ceQ();
            this.iHp.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.aHe = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.iHs;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.iHs) {
            if (this.iHv == null) {
                this.iHv = new Rect();
                this.iHp.getDrawingRect(this.iHv);
                Rect rect = this.iHv;
                rect.top = (int) (rect.top - this.iHt);
                Rect rect2 = this.iHv;
                rect2.bottom = (int) (rect2.bottom + this.iHt);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.aHe = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.aHe = x;
                    this.iHu.rect.offset((int) (x - this.aHe), 0);
                    a(this.iHu);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.iHu.rect);
        this.iHp.offsetRectIntoDescendantCoords((View) this.iHq, this.mTempRect);
        this.iHq.n(this.mTempRect);
        this.iHp.invalidate();
        if (this.iHu.iHY) {
            this.iHq.ceL();
        } else if (this.iHu.iHZ) {
            this.iHq.ceM();
        } else {
            this.iHq.ceN();
        }
    }

    private void a(b bVar) {
        bVar.iHY = false;
        bVar.iHZ = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.iHp.getWidth() - this.iHw) - this.iHx;
        if (rect.left < this.iHw) {
            rect.left = this.iHw;
            rect.right = rect.left + width;
        }
        if (rect.right > this.iHw + width2) {
            rect.right = this.iHw + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.iHw + this.iHt) {
            bVar.iHY = true;
            bVar.iHZ = false;
        }
        if (rect.right > (this.iHw + width2) - this.iHt) {
            bVar.iHY = false;
            bVar.iHZ = true;
        }
    }

    public void a(d dVar) {
        this.iHq = dVar;
    }

    public void a(c cVar) {
        this.iHr = cVar;
        this.iHr.setDragController(this);
    }
}
