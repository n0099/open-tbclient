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
    public float bAp;
    private DragLayer dXY;
    private Vibrator dXZ;
    private f dYa;
    private e dYb;
    public boolean dYc;
    private float dYd;
    private d dYe;
    private Rect dYf;
    private int dYg;
    private int dYh;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.dXZ = (Vibrator) context.getSystemService("vibrator");
        this.dYd = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.dXY = dragLayer;
        dragLayer.setDragController(this);
        this.dYg = this.dXY.getPaddingLeft();
        this.dYh = this.dXY.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.dXY != null && view != null && view.getDrawingCache() != null) {
            this.dYc = true;
            this.dYe = new d(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.dXY.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.dYe.aEb = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.dYe.rect = rect;
            this.dYe.dYI = bundle;
            view.setVisibility(4);
            a(this.dYe);
            this.dXY.setDragObject(this.dYe);
            this.dXZ.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.dYc) {
            this.dYc = false;
            this.dYe = null;
            this.dYa.aMT();
            this.dYa.aMU();
            this.dXY.aMW();
            this.dXY.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.bAp = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.dYc;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dYc) {
            if (this.dYf == null) {
                this.dYf = new Rect();
                this.dXY.getDrawingRect(this.dYf);
                Rect rect = this.dYf;
                rect.top = (int) (rect.top - this.dYd);
                Rect rect2 = this.dYf;
                rect2.bottom = (int) (rect2.bottom + this.dYd);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.bAp = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.bAp = x;
                    this.dYe.rect.offset((int) (x - this.bAp), 0);
                    a(this.dYe);
                    aMP();
                    break;
            }
            return true;
        }
        return false;
    }

    public void aMP() {
        this.mTempRect.set(this.dYe.rect);
        this.dXY.offsetRectIntoDescendantCoords((View) this.dYa, this.mTempRect);
        this.dYa.d(this.mTempRect);
        this.dXY.invalidate();
        if (this.dYe.dYJ) {
            this.dYa.aMR();
        } else if (this.dYe.dYK) {
            this.dYa.aMS();
        } else {
            this.dYa.aMT();
        }
    }

    private void a(d dVar) {
        dVar.dYJ = false;
        dVar.dYK = false;
        Rect rect = dVar.rect;
        int width = rect.width();
        int width2 = (this.dXY.getWidth() - this.dYg) - this.dYh;
        if (rect.left < this.dYg) {
            rect.left = this.dYg;
            rect.right = rect.left + width;
        }
        if (rect.right > this.dYg + width2) {
            rect.right = this.dYg + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.dYg + this.dYd) {
            dVar.dYJ = true;
            dVar.dYK = false;
        }
        if (rect.right > (this.dYg + width2) - this.dYd) {
            dVar.dYJ = false;
            dVar.dYK = true;
        }
    }

    public void a(f fVar) {
        this.dYa = fVar;
    }

    public void a(e eVar) {
        this.dYb = eVar;
        this.dYb.setDragController(this);
    }
}
