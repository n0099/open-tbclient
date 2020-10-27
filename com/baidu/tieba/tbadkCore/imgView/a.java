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
    public float dic;
    private Context mContext;
    private c mSA;
    public boolean mSB;
    private float mSD;
    private b mSE;
    private Rect mSF;
    private int mSG;
    private int mSH;
    private DragLayer mSy;
    private d mSz;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.mSD = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.mSy = dragLayer;
        dragLayer.setDragController(this);
        this.mSG = this.mSy.getPaddingLeft();
        this.mSH = this.mSy.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.mSy != null && view != null && view.getDrawingCache() != null) {
            this.mSB = true;
            this.mSE = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.mSy.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.mSE.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.mSE.bxA = rect;
            this.mSE.mTk = bundle;
            view.setVisibility(4);
            a(this.mSE);
            this.mSy.setDragObject(this.mSE);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.mSB) {
            this.mSB = false;
            this.mSE = null;
            this.mSz.dHV();
            this.mSz.dHW();
            this.mSy.dHY();
            this.mSy.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.dic = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.mSB;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mSB) {
            if (this.mSF == null) {
                this.mSF = new Rect();
                this.mSy.getDrawingRect(this.mSF);
                Rect rect = this.mSF;
                rect.top = (int) (rect.top - this.mSD);
                Rect rect2 = this.mSF;
                rect2.bottom = (int) (rect2.bottom + this.mSD);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.dic = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.dic = x;
                    this.mSE.bxA.offset((int) (x - this.dic), 0);
                    a(this.mSE);
                    dHR();
                    break;
            }
            return true;
        }
        return false;
    }

    public void dHR() {
        this.mTempRect.set(this.mSE.bxA);
        this.mSy.offsetRectIntoDescendantCoords((View) this.mSz, this.mTempRect);
        this.mSz.j(this.mTempRect);
        this.mSy.invalidate();
        if (this.mSE.mTl) {
            this.mSz.dHT();
        } else if (this.mSE.mTm) {
            this.mSz.dHU();
        } else {
            this.mSz.dHV();
        }
    }

    private void a(b bVar) {
        bVar.mTl = false;
        bVar.mTm = false;
        Rect rect = bVar.bxA;
        int width = rect.width();
        int width2 = (this.mSy.getWidth() - this.mSG) - this.mSH;
        if (rect.left < this.mSG) {
            rect.left = this.mSG;
            rect.right = rect.left + width;
        }
        if (rect.right > this.mSG + width2) {
            rect.right = this.mSG + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.mSG + this.mSD) {
            bVar.mTl = true;
            bVar.mTm = false;
        }
        if (rect.right > (this.mSG + width2) - this.mSD) {
            bVar.mTl = false;
            bVar.mTm = true;
        }
    }

    public void a(d dVar) {
        this.mSz = dVar;
    }

    public void a(c cVar) {
        this.mSA = cVar;
        this.mSA.setDragController(this);
    }
}
