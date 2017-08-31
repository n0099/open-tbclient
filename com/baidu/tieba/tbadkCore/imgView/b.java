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
    public boolean gjA;
    public float gjB;
    private float gjC;
    private c gjD;
    private Rect gjE;
    private int gjF;
    private int gjG;
    private DragLayer gjw;
    private Vibrator gjx;
    private e gjy;
    private d gjz;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.gjx = (Vibrator) context.getSystemService("vibrator");
        this.gjC = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.gjw = dragLayer;
        dragLayer.setDragController(this);
        this.gjF = this.gjw.getPaddingLeft();
        this.gjG = this.gjw.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.gjw != null && view != null && view.getDrawingCache() != null) {
            this.gjA = true;
            this.gjD = new c(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.gjw.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.gjD.aND = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.gjD.rect = rect;
            this.gjD.gki = bundle;
            view.setVisibility(4);
            a(this.gjD);
            this.gjw.setDragObject(this.gjD);
            this.gjx.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.gjA) {
            this.gjA = false;
            this.gjD = null;
            this.gjy.bsL();
            this.gjy.bsM();
            this.gjw.bsO();
            this.gjw.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.gjB = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.gjA;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gjA) {
            if (this.gjE == null) {
                this.gjE = new Rect();
                this.gjw.getDrawingRect(this.gjE);
                Rect rect = this.gjE;
                rect.top = (int) (rect.top - this.gjC);
                Rect rect2 = this.gjE;
                rect2.bottom = (int) (rect2.bottom + this.gjC);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.gjB = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.gjB = x;
                    this.gjD.rect.offset((int) (x - this.gjB), 0);
                    a(this.gjD);
                    bsH();
                    break;
            }
            return true;
        }
        return false;
    }

    public void bsH() {
        this.mTempRect.set(this.gjD.rect);
        this.gjw.offsetRectIntoDescendantCoords((View) this.gjy, this.mTempRect);
        this.gjy.e(this.mTempRect);
        this.gjw.invalidate();
        if (this.gjD.gkj) {
            this.gjy.bsJ();
        } else if (this.gjD.gkk) {
            this.gjy.bsK();
        } else {
            this.gjy.bsL();
        }
    }

    private void a(c cVar) {
        cVar.gkj = false;
        cVar.gkk = false;
        Rect rect = cVar.rect;
        int width = rect.width();
        int width2 = (this.gjw.getWidth() - this.gjF) - this.gjG;
        if (rect.left < this.gjF) {
            rect.left = this.gjF;
            rect.right = rect.left + width;
        }
        if (rect.right > this.gjF + width2) {
            rect.right = this.gjF + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.gjF + this.gjC) {
            cVar.gkj = true;
            cVar.gkk = false;
        }
        if (rect.right > (this.gjF + width2) - this.gjC) {
            cVar.gkj = false;
            cVar.gkk = true;
        }
    }

    public void a(e eVar) {
        this.gjy = eVar;
    }

    public void a(d dVar) {
        this.gjz = dVar;
        this.gjz.setDragController(this);
    }
}
