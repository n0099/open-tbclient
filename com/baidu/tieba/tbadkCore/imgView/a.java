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
    private Vibrator dLj;
    public float duh;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private DragLayer noA;
    private d noB;
    private c noC;
    public boolean noD;
    private float noE;
    private b noF;
    private Rect noG;
    private int noH;
    private int noI;

    public a(Context context) {
        this.mContext = context;
        this.dLj = (Vibrator) context.getSystemService("vibrator");
        this.noE = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.noA = dragLayer;
        dragLayer.setDragController(this);
        this.noH = this.noA.getPaddingLeft();
        this.noI = this.noA.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.noA != null && view != null && view.getDrawingCache() != null) {
            this.noD = true;
            this.noF = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.noA.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.noF.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.noF.rect = rect;
            this.noF.nph = bundle;
            view.setVisibility(4);
            a(this.noF);
            this.noA.setDragObject(this.noF);
            this.dLj.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.noD) {
            this.noD = false;
            this.noF = null;
            this.noB.dLK();
            this.noB.dLL();
            this.noA.dLN();
            this.noA.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.duh = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.noD;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.noD) {
            if (this.noG == null) {
                this.noG = new Rect();
                this.noA.getDrawingRect(this.noG);
                Rect rect = this.noG;
                rect.top = (int) (rect.top - this.noE);
                Rect rect2 = this.noG;
                rect2.bottom = (int) (rect2.bottom + this.noE);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.duh = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.duh = x;
                    this.noF.rect.offset((int) (x - this.duh), 0);
                    a(this.noF);
                    dLG();
                    break;
            }
            return true;
        }
        return false;
    }

    public void dLG() {
        this.mTempRect.set(this.noF.rect);
        this.noA.offsetRectIntoDescendantCoords((View) this.noB, this.mTempRect);
        this.noB.i(this.mTempRect);
        this.noA.invalidate();
        if (this.noF.npi) {
            this.noB.dLI();
        } else if (this.noF.npj) {
            this.noB.dLJ();
        } else {
            this.noB.dLK();
        }
    }

    private void a(b bVar) {
        bVar.npi = false;
        bVar.npj = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.noA.getWidth() - this.noH) - this.noI;
        if (rect.left < this.noH) {
            rect.left = this.noH;
            rect.right = rect.left + width;
        }
        if (rect.right > this.noH + width2) {
            rect.right = this.noH + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.noH + this.noE) {
            bVar.npi = true;
            bVar.npj = false;
        }
        if (rect.right > (this.noH + width2) - this.noE) {
            bVar.npi = false;
            bVar.npj = true;
        }
    }

    public void a(d dVar) {
        this.noB = dVar;
    }

    public void a(c cVar) {
        this.noC = cVar;
        this.noC.setDragController(this);
    }
}
