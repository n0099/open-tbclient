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
    public float eVH;
    public boolean fvA;
    private float fvB;
    private e fvC;
    private Rect fvD;
    private int fvE;
    private int fvF;
    private DragLayer fvw;
    private Vibrator fvx;
    private g fvy;
    private f fvz;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.fvx = (Vibrator) context.getSystemService("vibrator");
        this.fvB = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.fvw = dragLayer;
        dragLayer.setDragController(this);
        this.fvE = this.fvw.getPaddingLeft();
        this.fvF = this.fvw.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.fvw != null && view != null && view.getDrawingCache() != null) {
            this.fvA = true;
            this.fvC = new e(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.fvw.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.fvC.aKu = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.fvC.rect = rect;
            this.fvC.fwh = bundle;
            view.setVisibility(4);
            a(this.fvC);
            this.fvw.setDragObject(this.fvC);
            this.fvx.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.fvA) {
            this.fvA = false;
            this.fvC = null;
            this.fvy.bhj();
            this.fvy.bhk();
            this.fvw.bhm();
            this.fvw.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.eVH = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.fvA;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.fvA) {
            if (this.fvD == null) {
                this.fvD = new Rect();
                this.fvw.getDrawingRect(this.fvD);
                Rect rect = this.fvD;
                rect.top = (int) (rect.top - this.fvB);
                Rect rect2 = this.fvD;
                rect2.bottom = (int) (rect2.bottom + this.fvB);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.eVH = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.eVH = x;
                    this.fvC.rect.offset((int) (x - this.eVH), 0);
                    a(this.fvC);
                    bhf();
                    break;
            }
            return true;
        }
        return false;
    }

    public void bhf() {
        this.mTempRect.set(this.fvC.rect);
        this.fvw.offsetRectIntoDescendantCoords((View) this.fvy, this.mTempRect);
        this.fvy.e(this.mTempRect);
        this.fvw.invalidate();
        if (this.fvC.fwi) {
            this.fvy.bhh();
        } else if (this.fvC.fwj) {
            this.fvy.bhi();
        } else {
            this.fvy.bhj();
        }
    }

    private void a(e eVar) {
        eVar.fwi = false;
        eVar.fwj = false;
        Rect rect = eVar.rect;
        int width = rect.width();
        int width2 = (this.fvw.getWidth() - this.fvE) - this.fvF;
        if (rect.left < this.fvE) {
            rect.left = this.fvE;
            rect.right = rect.left + width;
        }
        if (rect.right > this.fvE + width2) {
            rect.right = this.fvE + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.fvE + this.fvB) {
            eVar.fwi = true;
            eVar.fwj = false;
        }
        if (rect.right > (this.fvE + width2) - this.fvB) {
            eVar.fwi = false;
            eVar.fwj = true;
        }
    }

    public void a(g gVar) {
        this.fvy = gVar;
    }

    public void a(f fVar) {
        this.fvz = fVar;
        this.fvz.setDragController(this);
    }
}
