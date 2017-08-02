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
    public float fBG;
    private DragLayer ghR;
    private Vibrator ghS;
    private e ghT;
    private d ghU;
    public boolean ghV;
    private float ghW;
    private c ghX;
    private Rect ghY;
    private int ghZ;
    private int gia;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.ghS = (Vibrator) context.getSystemService("vibrator");
        this.ghW = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.ghR = dragLayer;
        dragLayer.setDragController(this);
        this.ghZ = this.ghR.getPaddingLeft();
        this.gia = this.ghR.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.ghR != null && view != null && view.getDrawingCache() != null) {
            this.ghV = true;
            this.ghX = new c(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.ghR.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.ghX.aME = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.ghX.rect = rect;
            this.ghX.giD = bundle;
            view.setVisibility(4);
            a(this.ghX);
            this.ghR.setDragObject(this.ghX);
            this.ghS.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.ghV) {
            this.ghV = false;
            this.ghX = null;
            this.ghT.bsO();
            this.ghT.bsP();
            this.ghR.bsR();
            this.ghR.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.fBG = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.ghV;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ghV) {
            if (this.ghY == null) {
                this.ghY = new Rect();
                this.ghR.getDrawingRect(this.ghY);
                Rect rect = this.ghY;
                rect.top = (int) (rect.top - this.ghW);
                Rect rect2 = this.ghY;
                rect2.bottom = (int) (rect2.bottom + this.ghW);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.fBG = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.fBG = x;
                    this.ghX.rect.offset((int) (x - this.fBG), 0);
                    a(this.ghX);
                    bsK();
                    break;
            }
            return true;
        }
        return false;
    }

    public void bsK() {
        this.mTempRect.set(this.ghX.rect);
        this.ghR.offsetRectIntoDescendantCoords((View) this.ghT, this.mTempRect);
        this.ghT.e(this.mTempRect);
        this.ghR.invalidate();
        if (this.ghX.giE) {
            this.ghT.bsM();
        } else if (this.ghX.giF) {
            this.ghT.bsN();
        } else {
            this.ghT.bsO();
        }
    }

    private void a(c cVar) {
        cVar.giE = false;
        cVar.giF = false;
        Rect rect = cVar.rect;
        int width = rect.width();
        int width2 = (this.ghR.getWidth() - this.ghZ) - this.gia;
        if (rect.left < this.ghZ) {
            rect.left = this.ghZ;
            rect.right = rect.left + width;
        }
        if (rect.right > this.ghZ + width2) {
            rect.right = this.ghZ + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.ghZ + this.ghW) {
            cVar.giE = true;
            cVar.giF = false;
        }
        if (rect.right > (this.ghZ + width2) - this.ghW) {
            cVar.giE = false;
            cVar.giF = true;
        }
    }

    public void a(e eVar) {
        this.ghT = eVar;
    }

    public void a(d dVar) {
        this.ghU = dVar;
        this.ghU.setDragController(this);
    }
}
