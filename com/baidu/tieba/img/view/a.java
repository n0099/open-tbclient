package com.baidu.tieba.img.view;

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
    public float Hb;
    private DragLayer bkO;
    private g bkP;
    private f bkQ;
    public boolean bkR;
    private float bkS;
    private e bkT;
    private Rect bkU;
    private int bkV;
    private int bkW;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.bkS = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.bkO = dragLayer;
        dragLayer.setDragController(this);
        this.bkV = this.bkO.getPaddingLeft();
        this.bkW = this.bkO.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        this.bkR = true;
        this.bkT = new e(this.mContext);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.bkO.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.bkT.bkN = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        this.bkT.Rt = rect;
        this.bkT.blB = bundle;
        view.setVisibility(4);
        a(this.bkT);
        this.bkO.setDragObject(this.bkT);
        this.mVibrator.vibrate(300L);
    }

    public void endDrag() {
        if (this.bkR) {
            this.bkR = false;
            this.bkT = null;
            this.bkP.Sh();
            this.bkP.Si();
            this.bkO.Sk();
            this.bkO.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.Hb = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.bkR;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bkR) {
            if (this.bkU == null) {
                this.bkU = new Rect();
                this.bkO.getDrawingRect(this.bkU);
                Rect rect = this.bkU;
                rect.top = (int) (rect.top - this.bkS);
                Rect rect2 = this.bkU;
                rect2.bottom = (int) (rect2.bottom + this.bkS);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.Hb = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.Hb = x;
                    this.bkT.Rt.offset((int) (x - this.Hb), 0);
                    a(this.bkT);
                    Sc();
                    break;
            }
            return true;
        }
        return false;
    }

    public void Sc() {
        this.mTempRect.set(this.bkT.Rt);
        this.bkO.offsetRectIntoDescendantCoords((View) this.bkP, this.mTempRect);
        this.bkP.d(this.mTempRect);
        this.bkO.invalidate();
        if (this.bkT.blC) {
            this.bkP.Sf();
        } else if (this.bkT.blD) {
            this.bkP.Sg();
        } else {
            this.bkP.Sh();
        }
    }

    private void a(e eVar) {
        eVar.blC = false;
        eVar.blD = false;
        Rect rect = eVar.Rt;
        int width = rect.width();
        int width2 = (this.bkO.getWidth() - this.bkV) - this.bkW;
        if (rect.left < this.bkV) {
            rect.left = this.bkV;
            rect.right = rect.left + width;
        }
        if (rect.right > this.bkV + width2) {
            rect.right = this.bkV + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.bkV + this.bkS) {
            eVar.blC = true;
            eVar.blD = false;
        }
        if (rect.right > (this.bkV + width2) - this.bkS) {
            eVar.blC = false;
            eVar.blD = true;
        }
    }

    public void a(g gVar) {
        this.bkP = gVar;
    }

    public void a(f fVar) {
        this.bkQ = fVar;
        this.bkQ.setDragController(this);
    }
}
