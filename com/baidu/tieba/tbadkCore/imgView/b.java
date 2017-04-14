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
    public float eXD;
    private DragLayer fwX;
    private Vibrator fwY;
    private g fwZ;
    private f fxa;
    public boolean fxb;
    private float fxc;
    private e fxd;
    private Rect fxe;
    private int fxf;
    private int fxg;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.fwY = (Vibrator) context.getSystemService("vibrator");
        this.fxc = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.fwX = dragLayer;
        dragLayer.setDragController(this);
        this.fxf = this.fwX.getPaddingLeft();
        this.fxg = this.fwX.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.fwX != null && view != null && view.getDrawingCache() != null) {
            this.fxb = true;
            this.fxd = new e(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.fwX.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.fxd.aKj = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.fxd.rect = rect;
            this.fxd.fxI = bundle;
            view.setVisibility(4);
            a(this.fxd);
            this.fwX.setDragObject(this.fxd);
            this.fwY.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.fxb) {
            this.fxb = false;
            this.fxd = null;
            this.fwZ.biL();
            this.fwZ.biM();
            this.fwX.biO();
            this.fwX.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.eXD = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.fxb;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.fxb) {
            if (this.fxe == null) {
                this.fxe = new Rect();
                this.fwX.getDrawingRect(this.fxe);
                Rect rect = this.fxe;
                rect.top = (int) (rect.top - this.fxc);
                Rect rect2 = this.fxe;
                rect2.bottom = (int) (rect2.bottom + this.fxc);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.eXD = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.eXD = x;
                    this.fxd.rect.offset((int) (x - this.eXD), 0);
                    a(this.fxd);
                    biH();
                    break;
            }
            return true;
        }
        return false;
    }

    public void biH() {
        this.mTempRect.set(this.fxd.rect);
        this.fwX.offsetRectIntoDescendantCoords((View) this.fwZ, this.mTempRect);
        this.fwZ.e(this.mTempRect);
        this.fwX.invalidate();
        if (this.fxd.fxJ) {
            this.fwZ.biJ();
        } else if (this.fxd.fxK) {
            this.fwZ.biK();
        } else {
            this.fwZ.biL();
        }
    }

    private void a(e eVar) {
        eVar.fxJ = false;
        eVar.fxK = false;
        Rect rect = eVar.rect;
        int width = rect.width();
        int width2 = (this.fwX.getWidth() - this.fxf) - this.fxg;
        if (rect.left < this.fxf) {
            rect.left = this.fxf;
            rect.right = rect.left + width;
        }
        if (rect.right > this.fxf + width2) {
            rect.right = this.fxf + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.fxf + this.fxc) {
            eVar.fxJ = true;
            eVar.fxK = false;
        }
        if (rect.right > (this.fxf + width2) - this.fxc) {
            eVar.fxJ = false;
            eVar.fxK = true;
        }
    }

    public void a(g gVar) {
        this.fwZ = gVar;
    }

    public void a(f fVar) {
        this.fxa = fVar;
        this.fxa.setDragController(this);
    }
}
