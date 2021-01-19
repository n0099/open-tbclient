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
    private DragLayer noB;
    private d noC;
    private c noD;
    public boolean noE;
    private float noF;
    private b noG;
    private Rect noH;
    private int noI;
    private int noJ;

    public a(Context context) {
        this.mContext = context;
        this.dLj = (Vibrator) context.getSystemService("vibrator");
        this.noF = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.noB = dragLayer;
        dragLayer.setDragController(this);
        this.noI = this.noB.getPaddingLeft();
        this.noJ = this.noB.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.noB != null && view != null && view.getDrawingCache() != null) {
            this.noE = true;
            this.noG = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.noB.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.noG.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.noG.rect = rect;
            this.noG.npi = bundle;
            view.setVisibility(4);
            a(this.noG);
            this.noB.setDragObject(this.noG);
            this.dLj.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.noE) {
            this.noE = false;
            this.noG = null;
            this.noC.dLK();
            this.noC.dLL();
            this.noB.dLN();
            this.noB.invalidate();
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
        return this.noE;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.noE) {
            if (this.noH == null) {
                this.noH = new Rect();
                this.noB.getDrawingRect(this.noH);
                Rect rect = this.noH;
                rect.top = (int) (rect.top - this.noF);
                Rect rect2 = this.noH;
                rect2.bottom = (int) (rect2.bottom + this.noF);
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
                    this.noG.rect.offset((int) (x - this.duh), 0);
                    a(this.noG);
                    dLG();
                    break;
            }
            return true;
        }
        return false;
    }

    public void dLG() {
        this.mTempRect.set(this.noG.rect);
        this.noB.offsetRectIntoDescendantCoords((View) this.noC, this.mTempRect);
        this.noC.i(this.mTempRect);
        this.noB.invalidate();
        if (this.noG.npj) {
            this.noC.dLI();
        } else if (this.noG.npk) {
            this.noC.dLJ();
        } else {
            this.noC.dLK();
        }
    }

    private void a(b bVar) {
        bVar.npj = false;
        bVar.npk = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.noB.getWidth() - this.noI) - this.noJ;
        if (rect.left < this.noI) {
            rect.left = this.noI;
            rect.right = rect.left + width;
        }
        if (rect.right > this.noI + width2) {
            rect.right = this.noI + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.noI + this.noF) {
            bVar.npj = true;
            bVar.npk = false;
        }
        if (rect.right > (this.noI + width2) - this.noF) {
            bVar.npj = false;
            bVar.npk = true;
        }
    }

    public void a(d dVar) {
        this.noC = dVar;
    }

    public void a(c cVar) {
        this.noD = cVar;
        this.noD.setDragController(this);
    }
}
