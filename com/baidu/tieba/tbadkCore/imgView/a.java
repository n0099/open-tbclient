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
public class a {
    public float cfx;
    private DragLayer flS;
    private Vibrator flT;
    private f flU;
    private e flV;
    public boolean flW;
    private float flX;
    private d flY;
    private Rect flZ;
    private int fma;
    private int fmb;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.flT = (Vibrator) context.getSystemService("vibrator");
        this.flX = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.flS = dragLayer;
        dragLayer.setDragController(this);
        this.fma = this.flS.getPaddingLeft();
        this.fmb = this.flS.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.flS != null && view != null && view.getDrawingCache() != null) {
            this.flW = true;
            this.flY = new d(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.flS.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.flY.aCR = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.flY.rect = rect;
            this.flY.fmC = bundle;
            view.setVisibility(4);
            a(this.flY);
            this.flS.setDragObject(this.flY);
            this.flT.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.flW) {
            this.flW = false;
            this.flY = null;
            this.flU.bgd();
            this.flU.bge();
            this.flS.bgg();
            this.flS.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.cfx = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.flW;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.flW) {
            if (this.flZ == null) {
                this.flZ = new Rect();
                this.flS.getDrawingRect(this.flZ);
                Rect rect = this.flZ;
                rect.top = (int) (rect.top - this.flX);
                Rect rect2 = this.flZ;
                rect2.bottom = (int) (rect2.bottom + this.flX);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.cfx = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.cfx = x;
                    this.flY.rect.offset((int) (x - this.cfx), 0);
                    a(this.flY);
                    bfZ();
                    break;
            }
            return true;
        }
        return false;
    }

    public void bfZ() {
        this.mTempRect.set(this.flY.rect);
        this.flS.offsetRectIntoDescendantCoords((View) this.flU, this.mTempRect);
        this.flU.d(this.mTempRect);
        this.flS.invalidate();
        if (this.flY.fmD) {
            this.flU.bgb();
        } else if (this.flY.fmE) {
            this.flU.bgc();
        } else {
            this.flU.bgd();
        }
    }

    private void a(d dVar) {
        dVar.fmD = false;
        dVar.fmE = false;
        Rect rect = dVar.rect;
        int width = rect.width();
        int width2 = (this.flS.getWidth() - this.fma) - this.fmb;
        if (rect.left < this.fma) {
            rect.left = this.fma;
            rect.right = rect.left + width;
        }
        if (rect.right > this.fma + width2) {
            rect.right = this.fma + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.fma + this.flX) {
            dVar.fmD = true;
            dVar.fmE = false;
        }
        if (rect.right > (this.fma + width2) - this.flX) {
            dVar.fmD = false;
            dVar.fmE = true;
        }
    }

    public void a(f fVar) {
        this.flU = fVar;
    }

    public void a(e eVar) {
        this.flV = eVar;
        this.flV.setDragController(this);
    }
}
