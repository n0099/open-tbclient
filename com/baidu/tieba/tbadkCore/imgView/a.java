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
    private DragLayer kha;
    private d khb;
    private c khc;
    public boolean khd;
    private float khe;
    private b khf;
    private Rect khg;
    private int khh;
    private int khi;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.khe = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.kha = dragLayer;
        dragLayer.setDragController(this);
        this.khh = this.kha.getPaddingLeft();
        this.khi = this.kha.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.kha != null && view != null && view.getDrawingCache() != null) {
            this.khd = true;
            this.khf = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.kha.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.khf.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.khf.rect = rect;
            this.khf.khI = bundle;
            view.setVisibility(4);
            a(this.khf);
            this.kha.setDragObject(this.khf);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.khd) {
            this.khd = false;
            this.khf = null;
            this.khb.cJZ();
            this.khb.cKa();
            this.kha.cKc();
            this.kha.invalidate();
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
        return this.khd;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.khd) {
            if (this.khg == null) {
                this.khg = new Rect();
                this.kha.getDrawingRect(this.khg);
                Rect rect = this.khg;
                rect.top = (int) (rect.top - this.khe);
                Rect rect2 = this.khg;
                rect2.bottom = (int) (rect2.bottom + this.khe);
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
                    this.khf.rect.offset((int) (x - this.bGV), 0);
                    a(this.khf);
                    cJV();
                    break;
            }
            return true;
        }
        return false;
    }

    public void cJV() {
        this.mTempRect.set(this.khf.rect);
        this.kha.offsetRectIntoDescendantCoords((View) this.khb, this.mTempRect);
        this.khb.j(this.mTempRect);
        this.kha.invalidate();
        if (this.khf.khJ) {
            this.khb.cJX();
        } else if (this.khf.khK) {
            this.khb.cJY();
        } else {
            this.khb.cJZ();
        }
    }

    private void a(b bVar) {
        bVar.khJ = false;
        bVar.khK = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.kha.getWidth() - this.khh) - this.khi;
        if (rect.left < this.khh) {
            rect.left = this.khh;
            rect.right = rect.left + width;
        }
        if (rect.right > this.khh + width2) {
            rect.right = this.khh + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.khh + this.khe) {
            bVar.khJ = true;
            bVar.khK = false;
        }
        if (rect.right > (this.khh + width2) - this.khe) {
            bVar.khJ = false;
            bVar.khK = true;
        }
    }

    public void a(d dVar) {
        this.khb = dVar;
    }

    public void a(c cVar) {
        this.khc = cVar;
        this.khc.setDragController(this);
    }
}
