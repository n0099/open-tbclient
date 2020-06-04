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
    public float cvH;
    private DragLayer lnG;
    private d lnH;
    private c lnI;
    public boolean lnJ;
    private float lnK;
    private b lnL;
    private Rect lnM;
    private int lnN;
    private int lnO;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.lnK = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.lnG = dragLayer;
        dragLayer.setDragController(this);
        this.lnN = this.lnG.getPaddingLeft();
        this.lnO = this.lnG.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.lnG != null && view != null && view.getDrawingCache() != null) {
            this.lnJ = true;
            this.lnL = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.lnG.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.lnL.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.lnL.rect = rect;
            this.lnL.los = bundle;
            view.setVisibility(4);
            a(this.lnL);
            this.lnG.setDragObject(this.lnL);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.lnJ) {
            this.lnJ = false;
            this.lnL = null;
            this.lnH.dek();
            this.lnH.del();
            this.lnG.den();
            this.lnG.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.cvH = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.lnJ;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.lnJ) {
            if (this.lnM == null) {
                this.lnM = new Rect();
                this.lnG.getDrawingRect(this.lnM);
                Rect rect = this.lnM;
                rect.top = (int) (rect.top - this.lnK);
                Rect rect2 = this.lnM;
                rect2.bottom = (int) (rect2.bottom + this.lnK);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.cvH = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.cvH = x;
                    this.lnL.rect.offset((int) (x - this.cvH), 0);
                    a(this.lnL);
                    deg();
                    break;
            }
            return true;
        }
        return false;
    }

    public void deg() {
        this.mTempRect.set(this.lnL.rect);
        this.lnG.offsetRectIntoDescendantCoords((View) this.lnH, this.mTempRect);
        this.lnH.j(this.mTempRect);
        this.lnG.invalidate();
        if (this.lnL.lot) {
            this.lnH.dei();
        } else if (this.lnL.lou) {
            this.lnH.dej();
        } else {
            this.lnH.dek();
        }
    }

    private void a(b bVar) {
        bVar.lot = false;
        bVar.lou = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.lnG.getWidth() - this.lnN) - this.lnO;
        if (rect.left < this.lnN) {
            rect.left = this.lnN;
            rect.right = rect.left + width;
        }
        if (rect.right > this.lnN + width2) {
            rect.right = this.lnN + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.lnN + this.lnK) {
            bVar.lot = true;
            bVar.lou = false;
        }
        if (rect.right > (this.lnN + width2) - this.lnK) {
            bVar.lot = false;
            bVar.lou = true;
        }
    }

    public void a(d dVar) {
        this.lnH = dVar;
    }

    public void a(c cVar) {
        this.lnI = cVar;
        this.lnI.setDragController(this);
    }
}
