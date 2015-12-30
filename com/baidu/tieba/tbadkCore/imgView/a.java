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
    public float bxe;
    private DragLayer dHY;
    private Vibrator dHZ;
    private f dIa;
    private e dIb;
    public boolean dIc;
    private float dId;
    private d dIe;
    private Rect dIf;
    private int dIg;
    private int dIh;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.dHZ = (Vibrator) context.getSystemService("vibrator");
        this.dId = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.dHY = dragLayer;
        dragLayer.setDragController(this);
        this.dIg = this.dHY.getPaddingLeft();
        this.dIh = this.dHY.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.dHY != null && view != null && view.getDrawingCache() != null) {
            this.dIc = true;
            this.dIe = new d(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.dHY.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.dIe.aDl = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.dIe.rect = rect;
            this.dIe.dII = bundle;
            view.setVisibility(4);
            a(this.dIe);
            this.dHY.setDragObject(this.dIe);
            this.dHZ.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.dIc) {
            this.dIc = false;
            this.dIe = null;
            this.dIa.aFO();
            this.dIa.aFP();
            this.dHY.aFR();
            this.dHY.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.bxe = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.dIc;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dIc) {
            if (this.dIf == null) {
                this.dIf = new Rect();
                this.dHY.getDrawingRect(this.dIf);
                Rect rect = this.dIf;
                rect.top = (int) (rect.top - this.dId);
                Rect rect2 = this.dIf;
                rect2.bottom = (int) (rect2.bottom + this.dId);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.bxe = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.bxe = x;
                    this.dIe.rect.offset((int) (x - this.bxe), 0);
                    a(this.dIe);
                    aFK();
                    break;
            }
            return true;
        }
        return false;
    }

    public void aFK() {
        this.mTempRect.set(this.dIe.rect);
        this.dHY.offsetRectIntoDescendantCoords((View) this.dIa, this.mTempRect);
        this.dIa.d(this.mTempRect);
        this.dHY.invalidate();
        if (this.dIe.dIJ) {
            this.dIa.aFM();
        } else if (this.dIe.dIK) {
            this.dIa.aFN();
        } else {
            this.dIa.aFO();
        }
    }

    private void a(d dVar) {
        dVar.dIJ = false;
        dVar.dIK = false;
        Rect rect = dVar.rect;
        int width = rect.width();
        int width2 = (this.dHY.getWidth() - this.dIg) - this.dIh;
        if (rect.left < this.dIg) {
            rect.left = this.dIg;
            rect.right = rect.left + width;
        }
        if (rect.right > this.dIg + width2) {
            rect.right = this.dIg + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.dIg + this.dId) {
            dVar.dIJ = true;
            dVar.dIK = false;
        }
        if (rect.right > (this.dIg + width2) - this.dId) {
            dVar.dIJ = false;
            dVar.dIK = true;
        }
    }

    public void a(f fVar) {
        this.dIa = fVar;
    }

    public void a(e eVar) {
        this.dIb = eVar;
        this.dIb.setDragController(this);
    }
}
