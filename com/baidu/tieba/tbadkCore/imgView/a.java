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
    public float cDf;
    private DragLayer lOJ;
    private d lOK;
    private c lOL;
    public boolean lOM;
    private float lON;
    private b lOO;
    private Rect lOP;
    private int lOQ;
    private int lOR;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.lON = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.lOJ = dragLayer;
        dragLayer.setDragController(this);
        this.lOQ = this.lOJ.getPaddingLeft();
        this.lOR = this.lOJ.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.lOJ != null && view != null && view.getDrawingCache() != null) {
            this.lOM = true;
            this.lOO = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.lOJ.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.lOO.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.lOO.rect = rect;
            this.lOO.lPs = bundle;
            view.setVisibility(4);
            a(this.lOO);
            this.lOJ.setDragObject(this.lOO);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.lOM) {
            this.lOM = false;
            this.lOO = null;
            this.lOK.dlF();
            this.lOK.dlG();
            this.lOJ.dlI();
            this.lOJ.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.cDf = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.lOM;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.lOM) {
            if (this.lOP == null) {
                this.lOP = new Rect();
                this.lOJ.getDrawingRect(this.lOP);
                Rect rect = this.lOP;
                rect.top = (int) (rect.top - this.lON);
                Rect rect2 = this.lOP;
                rect2.bottom = (int) (rect2.bottom + this.lON);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.cDf = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.cDf = x;
                    this.lOO.rect.offset((int) (x - this.cDf), 0);
                    a(this.lOO);
                    dlB();
                    break;
            }
            return true;
        }
        return false;
    }

    public void dlB() {
        this.mTempRect.set(this.lOO.rect);
        this.lOJ.offsetRectIntoDescendantCoords((View) this.lOK, this.mTempRect);
        this.lOK.j(this.mTempRect);
        this.lOJ.invalidate();
        if (this.lOO.lPt) {
            this.lOK.dlD();
        } else if (this.lOO.lPu) {
            this.lOK.dlE();
        } else {
            this.lOK.dlF();
        }
    }

    private void a(b bVar) {
        bVar.lPt = false;
        bVar.lPu = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.lOJ.getWidth() - this.lOQ) - this.lOR;
        if (rect.left < this.lOQ) {
            rect.left = this.lOQ;
            rect.right = rect.left + width;
        }
        if (rect.right > this.lOQ + width2) {
            rect.right = this.lOQ + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.lOQ + this.lON) {
            bVar.lPt = true;
            bVar.lPu = false;
        }
        if (rect.right > (this.lOQ + width2) - this.lON) {
            bVar.lPt = false;
            bVar.lPu = true;
        }
    }

    public void a(d dVar) {
        this.lOK = dVar;
    }

    public void a(c cVar) {
        this.lOL = cVar;
        this.lOL.setDragController(this);
    }
}
