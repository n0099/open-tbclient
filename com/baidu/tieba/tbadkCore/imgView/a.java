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
    public float aJF;
    private Vibrator aYc;
    private DragLayer jgF;
    private d jgG;
    private c jgH;
    public boolean jgI;
    private float jgJ;
    private b jgK;
    private Rect jgL;
    private int jgM;
    private int jgN;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.aYc = (Vibrator) context.getSystemService("vibrator");
        this.jgJ = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.jgF = dragLayer;
        dragLayer.setDragController(this);
        this.jgM = this.jgF.getPaddingLeft();
        this.jgN = this.jgF.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.jgF != null && view != null && view.getDrawingCache() != null) {
            this.jgI = true;
            this.jgK = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.jgF.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.jgK.cEy = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.jgK.cxc = rect;
            this.jgK.jhn = bundle;
            view.setVisibility(4);
            a(this.jgK);
            this.jgF.setDragObject(this.jgK);
            this.aYc.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.jgI) {
            this.jgI = false;
            this.jgK = null;
            this.jgG.cpO();
            this.jgG.cpP();
            this.jgF.cpR();
            this.jgF.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.aJF = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.jgI;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jgI) {
            if (this.jgL == null) {
                this.jgL = new Rect();
                this.jgF.getDrawingRect(this.jgL);
                Rect rect = this.jgL;
                rect.top = (int) (rect.top - this.jgJ);
                Rect rect2 = this.jgL;
                rect2.bottom = (int) (rect2.bottom + this.jgJ);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.aJF = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.aJF = x;
                    this.jgK.cxc.offset((int) (x - this.aJF), 0);
                    a(this.jgK);
                    cpK();
                    break;
            }
            return true;
        }
        return false;
    }

    public void cpK() {
        this.mTempRect.set(this.jgK.cxc);
        this.jgF.offsetRectIntoDescendantCoords((View) this.jgG, this.mTempRect);
        this.jgG.p(this.mTempRect);
        this.jgF.invalidate();
        if (this.jgK.jho) {
            this.jgG.cpM();
        } else if (this.jgK.jhp) {
            this.jgG.cpN();
        } else {
            this.jgG.cpO();
        }
    }

    private void a(b bVar) {
        bVar.jho = false;
        bVar.jhp = false;
        Rect rect = bVar.cxc;
        int width = rect.width();
        int width2 = (this.jgF.getWidth() - this.jgM) - this.jgN;
        if (rect.left < this.jgM) {
            rect.left = this.jgM;
            rect.right = rect.left + width;
        }
        if (rect.right > this.jgM + width2) {
            rect.right = this.jgM + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.jgM + this.jgJ) {
            bVar.jho = true;
            bVar.jhp = false;
        }
        if (rect.right > (this.jgM + width2) - this.jgJ) {
            bVar.jho = false;
            bVar.jhp = true;
        }
    }

    public void a(d dVar) {
        this.jgG = dVar;
    }

    public void a(c cVar) {
        this.jgH = cVar;
        this.jgH.setDragController(this);
    }
}
