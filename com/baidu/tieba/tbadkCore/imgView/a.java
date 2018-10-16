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
    private DragLayer hep;
    private d heq;
    private c her;
    public boolean hes;
    private float het;
    private b heu;
    private Rect hev;
    private int hew;
    private int hex;
    private Context mContext;
    public float mStartX;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.het = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.hep = dragLayer;
        dragLayer.setDragController(this);
        this.hew = this.hep.getPaddingLeft();
        this.hex = this.hep.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.hep != null && view != null && view.getDrawingCache() != null) {
            this.hes = true;
            this.heu = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.hep.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.heu.bfJ = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.heu.rect = rect;
            this.heu.heX = bundle;
            view.setVisibility(4);
            a(this.heu);
            this.hep.setDragObject(this.heu);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.hes) {
            this.hes = false;
            this.heu = null;
            this.heq.bCy();
            this.heq.bCz();
            this.hep.bCB();
            this.hep.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.mStartX = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.hes;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hes) {
            if (this.hev == null) {
                this.hev = new Rect();
                this.hep.getDrawingRect(this.hev);
                Rect rect = this.hev;
                rect.top = (int) (rect.top - this.het);
                Rect rect2 = this.hev;
                rect2.bottom = (int) (rect2.bottom + this.het);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.mStartX = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.mStartX = x;
                    this.heu.rect.offset((int) (x - this.mStartX), 0);
                    a(this.heu);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.heu.rect);
        this.hep.offsetRectIntoDescendantCoords((View) this.heq, this.mTempRect);
        this.heq.m(this.mTempRect);
        this.hep.invalidate();
        if (this.heu.heY) {
            this.heq.bCw();
        } else if (this.heu.heZ) {
            this.heq.bCx();
        } else {
            this.heq.bCy();
        }
    }

    private void a(b bVar) {
        bVar.heY = false;
        bVar.heZ = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.hep.getWidth() - this.hew) - this.hex;
        if (rect.left < this.hew) {
            rect.left = this.hew;
            rect.right = rect.left + width;
        }
        if (rect.right > this.hew + width2) {
            rect.right = this.hew + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.hew + this.het) {
            bVar.heY = true;
            bVar.heZ = false;
        }
        if (rect.right > (this.hew + width2) - this.het) {
            bVar.heY = false;
            bVar.heZ = true;
        }
    }

    public void a(d dVar) {
        this.heq = dVar;
    }

    public void a(c cVar) {
        this.her = cVar;
        this.her.setDragController(this);
    }
}
