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
    public float cvH;
    private float lmA;
    private b lmB;
    private Rect lmC;
    private int lmD;
    private int lmE;
    private DragLayer lmw;
    private d lmx;
    private c lmy;
    public boolean lmz;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.lmA = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.lmw = dragLayer;
        dragLayer.setDragController(this);
        this.lmD = this.lmw.getPaddingLeft();
        this.lmE = this.lmw.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.lmw != null && view != null && view.getDrawingCache() != null) {
            this.lmz = true;
            this.lmB = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.lmw.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.lmB.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.lmB.rect = rect;
            this.lmB.lnf = bundle;
            view.setVisibility(4);
            a(this.lmB);
            this.lmw.setDragObject(this.lmB);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.lmz) {
            this.lmz = false;
            this.lmB = null;
            this.lmx.ddV();
            this.lmx.ddW();
            this.lmw.ddY();
            this.lmw.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.cvH = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.lmz;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.lmz) {
            if (this.lmC == null) {
                this.lmC = new Rect();
                this.lmw.getDrawingRect(this.lmC);
                Rect rect = this.lmC;
                rect.top = (int) (rect.top - this.lmA);
                Rect rect2 = this.lmC;
                rect2.bottom = (int) (rect2.bottom + this.lmA);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.cvH = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.cvH = x;
                    this.lmB.rect.offset((int) (x - this.cvH), 0);
                    a(this.lmB);
                    ddR();
                    break;
            }
            return true;
        }
        return false;
    }

    public void ddR() {
        this.mTempRect.set(this.lmB.rect);
        this.lmw.offsetRectIntoDescendantCoords((View) this.lmx, this.mTempRect);
        this.lmx.j(this.mTempRect);
        this.lmw.invalidate();
        if (this.lmB.lnh) {
            this.lmx.ddT();
        } else if (this.lmB.lni) {
            this.lmx.ddU();
        } else {
            this.lmx.ddV();
        }
    }

    private void a(b bVar) {
        bVar.lnh = false;
        bVar.lni = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.lmw.getWidth() - this.lmD) - this.lmE;
        if (rect.left < this.lmD) {
            rect.left = this.lmD;
            rect.right = rect.left + width;
        }
        if (rect.right > this.lmD + width2) {
            rect.right = this.lmD + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.lmD + this.lmA) {
            bVar.lnh = true;
            bVar.lni = false;
        }
        if (rect.right > (this.lmD + width2) - this.lmA) {
            bVar.lnh = false;
            bVar.lni = true;
        }
    }

    public void a(d dVar) {
        this.lmx = dVar;
    }

    public void a(c cVar) {
        this.lmy = cVar;
        this.lmy.setDragController(this);
    }
}
