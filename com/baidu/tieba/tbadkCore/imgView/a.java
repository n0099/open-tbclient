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
    public float bGV;
    private DragLayer kgV;
    private d kgW;
    private c kgX;
    public boolean kgY;
    private float kgZ;
    private b kha;
    private Rect khb;
    private int khc;
    private int khd;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.kgZ = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.kgV = dragLayer;
        dragLayer.setDragController(this);
        this.khc = this.kgV.getPaddingLeft();
        this.khd = this.kgV.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.kgV != null && view != null && view.getDrawingCache() != null) {
            this.kgY = true;
            this.kha = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.kgV.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.kha.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.kha.rect = rect;
            this.kha.khD = bundle;
            view.setVisibility(4);
            a(this.kha);
            this.kgV.setDragObject(this.kha);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.kgY) {
            this.kgY = false;
            this.kha = null;
            this.kgW.cJX();
            this.kgW.cJY();
            this.kgV.cKa();
            this.kgV.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.bGV = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.kgY;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.kgY) {
            if (this.khb == null) {
                this.khb = new Rect();
                this.kgV.getDrawingRect(this.khb);
                Rect rect = this.khb;
                rect.top = (int) (rect.top - this.kgZ);
                Rect rect2 = this.khb;
                rect2.bottom = (int) (rect2.bottom + this.kgZ);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bGV = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.bGV = x;
                    this.kha.rect.offset((int) (x - this.bGV), 0);
                    a(this.kha);
                    cJT();
                    break;
            }
            return true;
        }
        return false;
    }

    public void cJT() {
        this.mTempRect.set(this.kha.rect);
        this.kgV.offsetRectIntoDescendantCoords((View) this.kgW, this.mTempRect);
        this.kgW.j(this.mTempRect);
        this.kgV.invalidate();
        if (this.kha.khE) {
            this.kgW.cJV();
        } else if (this.kha.khF) {
            this.kgW.cJW();
        } else {
            this.kgW.cJX();
        }
    }

    private void a(b bVar) {
        bVar.khE = false;
        bVar.khF = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.kgV.getWidth() - this.khc) - this.khd;
        if (rect.left < this.khc) {
            rect.left = this.khc;
            rect.right = rect.left + width;
        }
        if (rect.right > this.khc + width2) {
            rect.right = this.khc + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.khc + this.kgZ) {
            bVar.khE = true;
            bVar.khF = false;
        }
        if (rect.right > (this.khc + width2) - this.kgZ) {
            bVar.khE = false;
            bVar.khF = true;
        }
    }

    public void a(d dVar) {
        this.kgW = dVar;
    }

    public void a(c cVar) {
        this.kgX = cVar;
        this.kgX.setDragController(this);
    }
}
