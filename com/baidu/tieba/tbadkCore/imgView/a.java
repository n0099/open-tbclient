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
    public float crh;
    private int fwA;
    private int fwB;
    private DragLayer fws;
    private Vibrator fwt;
    private f fwu;
    private e fwv;
    public boolean fww;
    private float fwx;
    private d fwy;
    private Rect fwz;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.fwt = (Vibrator) context.getSystemService("vibrator");
        this.fwx = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.fws = dragLayer;
        dragLayer.setDragController(this);
        this.fwA = this.fws.getPaddingLeft();
        this.fwB = this.fws.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.fws != null && view != null && view.getDrawingCache() != null) {
            this.fww = true;
            this.fwy = new d(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.fws.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.fwy.aFx = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.fwy.rect = rect;
            this.fwy.fxc = bundle;
            view.setVisibility(4);
            a(this.fwy);
            this.fws.setDragObject(this.fwy);
            this.fwt.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.fww) {
            this.fww = false;
            this.fwy = null;
            this.fwu.bkq();
            this.fwu.bkr();
            this.fws.bkt();
            this.fws.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.crh = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.fww;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.fww) {
            if (this.fwz == null) {
                this.fwz = new Rect();
                this.fws.getDrawingRect(this.fwz);
                Rect rect = this.fwz;
                rect.top = (int) (rect.top - this.fwx);
                Rect rect2 = this.fwz;
                rect2.bottom = (int) (rect2.bottom + this.fwx);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.crh = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.crh = x;
                    this.fwy.rect.offset((int) (x - this.crh), 0);
                    a(this.fwy);
                    bkm();
                    break;
            }
            return true;
        }
        return false;
    }

    public void bkm() {
        this.mTempRect.set(this.fwy.rect);
        this.fws.offsetRectIntoDescendantCoords((View) this.fwu, this.mTempRect);
        this.fwu.d(this.mTempRect);
        this.fws.invalidate();
        if (this.fwy.fxd) {
            this.fwu.bko();
        } else if (this.fwy.fxe) {
            this.fwu.bkp();
        } else {
            this.fwu.bkq();
        }
    }

    private void a(d dVar) {
        dVar.fxd = false;
        dVar.fxe = false;
        Rect rect = dVar.rect;
        int width = rect.width();
        int width2 = (this.fws.getWidth() - this.fwA) - this.fwB;
        if (rect.left < this.fwA) {
            rect.left = this.fwA;
            rect.right = rect.left + width;
        }
        if (rect.right > this.fwA + width2) {
            rect.right = this.fwA + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.fwA + this.fwx) {
            dVar.fxd = true;
            dVar.fxe = false;
        }
        if (rect.right > (this.fwA + width2) - this.fwx) {
            dVar.fxd = false;
            dVar.fxe = true;
        }
    }

    public void a(f fVar) {
        this.fwu = fVar;
    }

    public void a(e eVar) {
        this.fwv = eVar;
        this.fwv.setDragController(this);
    }
}
