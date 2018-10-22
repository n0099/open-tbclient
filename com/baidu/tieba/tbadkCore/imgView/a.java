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
    private DragLayer heq;
    private d her;
    private c hes;
    public boolean het;
    private float heu;
    private b hev;
    private Rect hew;
    private int hex;
    private int hey;
    private Context mContext;
    public float mStartX;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.heu = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.heq = dragLayer;
        dragLayer.setDragController(this);
        this.hex = this.heq.getPaddingLeft();
        this.hey = this.heq.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.heq != null && view != null && view.getDrawingCache() != null) {
            this.het = true;
            this.hev = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.heq.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.hev.bfJ = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.hev.rect = rect;
            this.hev.heY = bundle;
            view.setVisibility(4);
            a(this.hev);
            this.heq.setDragObject(this.hev);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.het) {
            this.het = false;
            this.hev = null;
            this.her.bCy();
            this.her.bCz();
            this.heq.bCB();
            this.heq.invalidate();
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
        return this.het;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.het) {
            if (this.hew == null) {
                this.hew = new Rect();
                this.heq.getDrawingRect(this.hew);
                Rect rect = this.hew;
                rect.top = (int) (rect.top - this.heu);
                Rect rect2 = this.hew;
                rect2.bottom = (int) (rect2.bottom + this.heu);
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
                    this.hev.rect.offset((int) (x - this.mStartX), 0);
                    a(this.hev);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.hev.rect);
        this.heq.offsetRectIntoDescendantCoords((View) this.her, this.mTempRect);
        this.her.m(this.mTempRect);
        this.heq.invalidate();
        if (this.hev.heZ) {
            this.her.bCw();
        } else if (this.hev.hfa) {
            this.her.bCx();
        } else {
            this.her.bCy();
        }
    }

    private void a(b bVar) {
        bVar.heZ = false;
        bVar.hfa = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.heq.getWidth() - this.hex) - this.hey;
        if (rect.left < this.hex) {
            rect.left = this.hex;
            rect.right = rect.left + width;
        }
        if (rect.right > this.hex + width2) {
            rect.right = this.hex + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.hex + this.heu) {
            bVar.heZ = true;
            bVar.hfa = false;
        }
        if (rect.right > (this.hex + width2) - this.heu) {
            bVar.heZ = false;
            bVar.hfa = true;
        }
    }

    public void a(d dVar) {
        this.her = dVar;
    }

    public void a(c cVar) {
        this.hes = cVar;
        this.hes.setDragController(this);
    }
}
