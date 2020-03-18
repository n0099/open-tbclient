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
    public float bLn;
    private DragLayer kjS;
    private d kjT;
    private c kjU;
    public boolean kjV;
    private float kjW;
    private b kjX;
    private Rect kjY;
    private int kjZ;
    private int kka;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.kjW = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.kjS = dragLayer;
        dragLayer.setDragController(this);
        this.kjZ = this.kjS.getPaddingLeft();
        this.kka = this.kjS.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.kjS != null && view != null && view.getDrawingCache() != null) {
            this.kjV = true;
            this.kjX = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.kjS.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.kjX.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.kjX.rect = rect;
            this.kjX.kkA = bundle;
            view.setVisibility(4);
            a(this.kjX);
            this.kjS.setDragObject(this.kjX);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.kjV) {
            this.kjV = false;
            this.kjX = null;
            this.kjT.cLU();
            this.kjT.cLV();
            this.kjS.cLX();
            this.kjS.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.bLn = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.kjV;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.kjV) {
            if (this.kjY == null) {
                this.kjY = new Rect();
                this.kjS.getDrawingRect(this.kjY);
                Rect rect = this.kjY;
                rect.top = (int) (rect.top - this.kjW);
                Rect rect2 = this.kjY;
                rect2.bottom = (int) (rect2.bottom + this.kjW);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bLn = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.bLn = x;
                    this.kjX.rect.offset((int) (x - this.bLn), 0);
                    a(this.kjX);
                    cLQ();
                    break;
            }
            return true;
        }
        return false;
    }

    public void cLQ() {
        this.mTempRect.set(this.kjX.rect);
        this.kjS.offsetRectIntoDescendantCoords((View) this.kjT, this.mTempRect);
        this.kjT.j(this.mTempRect);
        this.kjS.invalidate();
        if (this.kjX.kkB) {
            this.kjT.cLS();
        } else if (this.kjX.kkC) {
            this.kjT.cLT();
        } else {
            this.kjT.cLU();
        }
    }

    private void a(b bVar) {
        bVar.kkB = false;
        bVar.kkC = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.kjS.getWidth() - this.kjZ) - this.kka;
        if (rect.left < this.kjZ) {
            rect.left = this.kjZ;
            rect.right = rect.left + width;
        }
        if (rect.right > this.kjZ + width2) {
            rect.right = this.kjZ + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.kjZ + this.kjW) {
            bVar.kkB = true;
            bVar.kkC = false;
        }
        if (rect.right > (this.kjZ + width2) - this.kjW) {
            bVar.kkB = false;
            bVar.kkC = true;
        }
    }

    public void a(d dVar) {
        this.kjT = dVar;
    }

    public void a(c cVar) {
        this.kjU = cVar;
        this.kjU.setDragController(this);
    }
}
