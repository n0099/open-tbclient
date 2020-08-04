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
    private DragLayer lOL;
    private d lOM;
    private c lON;
    public boolean lOO;
    private float lOP;
    private b lOQ;
    private Rect lOR;
    private int lOS;
    private int lOT;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.lOP = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.lOL = dragLayer;
        dragLayer.setDragController(this);
        this.lOS = this.lOL.getPaddingLeft();
        this.lOT = this.lOL.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.lOL != null && view != null && view.getDrawingCache() != null) {
            this.lOO = true;
            this.lOQ = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.lOL.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.lOQ.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.lOQ.rect = rect;
            this.lOQ.lPu = bundle;
            view.setVisibility(4);
            a(this.lOQ);
            this.lOL.setDragObject(this.lOQ);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.lOO) {
            this.lOO = false;
            this.lOQ = null;
            this.lOM.dlG();
            this.lOM.dlH();
            this.lOL.dlJ();
            this.lOL.invalidate();
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
        return this.lOO;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.lOO) {
            if (this.lOR == null) {
                this.lOR = new Rect();
                this.lOL.getDrawingRect(this.lOR);
                Rect rect = this.lOR;
                rect.top = (int) (rect.top - this.lOP);
                Rect rect2 = this.lOR;
                rect2.bottom = (int) (rect2.bottom + this.lOP);
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
                    this.lOQ.rect.offset((int) (x - this.cDf), 0);
                    a(this.lOQ);
                    dlC();
                    break;
            }
            return true;
        }
        return false;
    }

    public void dlC() {
        this.mTempRect.set(this.lOQ.rect);
        this.lOL.offsetRectIntoDescendantCoords((View) this.lOM, this.mTempRect);
        this.lOM.j(this.mTempRect);
        this.lOL.invalidate();
        if (this.lOQ.lPv) {
            this.lOM.dlE();
        } else if (this.lOQ.lPw) {
            this.lOM.dlF();
        } else {
            this.lOM.dlG();
        }
    }

    private void a(b bVar) {
        bVar.lPv = false;
        bVar.lPw = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.lOL.getWidth() - this.lOS) - this.lOT;
        if (rect.left < this.lOS) {
            rect.left = this.lOS;
            rect.right = rect.left + width;
        }
        if (rect.right > this.lOS + width2) {
            rect.right = this.lOS + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.lOS + this.lOP) {
            bVar.lPv = true;
            bVar.lPw = false;
        }
        if (rect.right > (this.lOS + width2) - this.lOP) {
            bVar.lPv = false;
            bVar.lPw = true;
        }
    }

    public void a(d dVar) {
        this.lOM = dVar;
    }

    public void a(c cVar) {
        this.lON = cVar;
        this.lON.setDragController(this);
    }
}
