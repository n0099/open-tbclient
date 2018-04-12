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
    public float aSa;
    private Vibrator cJW;
    private DragLayer gxN;
    private d gxO;
    private c gxP;
    public boolean gxQ;
    private float gxR;
    private b gxS;
    private Rect gxT;
    private int gxU;
    private int gxV;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.cJW = (Vibrator) context.getSystemService("vibrator");
        this.gxR = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.gxN = dragLayer;
        dragLayer.setDragController(this);
        this.gxU = this.gxN.getPaddingLeft();
        this.gxV = this.gxN.getPaddingRight();
    }

    public void b(View view2, Bundle bundle) {
        if (this.gxN != null && view2 != null && view2.getDrawingCache() != null) {
            this.gxQ = true;
            this.gxS = new b(this.mContext);
            Rect rect = new Rect();
            view2.getDrawingRect(rect);
            this.gxN.offsetDescendantRectToMyCoords(view2, rect);
            view2.setDrawingCacheEnabled(true);
            view2.buildDrawingCache();
            this.gxS.aOQ = Bitmap.createBitmap(view2.getDrawingCache());
            view2.destroyDrawingCache();
            view2.setDrawingCacheEnabled(false);
            this.gxS.rect = rect;
            this.gxS.gyw = bundle;
            view2.setVisibility(4);
            a(this.gxS);
            this.gxN.setDragObject(this.gxS);
            this.cJW.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.gxQ) {
            this.gxQ = false;
            this.gxS = null;
            this.gxO.bsv();
            this.gxO.bsw();
            this.gxN.bsy();
            this.gxN.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.aSa = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.gxQ;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gxQ) {
            if (this.gxT == null) {
                this.gxT = new Rect();
                this.gxN.getDrawingRect(this.gxT);
                Rect rect = this.gxT;
                rect.top = (int) (rect.top - this.gxR);
                Rect rect2 = this.gxT;
                rect2.bottom = (int) (rect2.bottom + this.gxR);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.aSa = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.aSa = x;
                    this.gxS.rect.offset((int) (x - this.aSa), 0);
                    a(this.gxS);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.gxS.rect);
        this.gxN.offsetRectIntoDescendantCoords((View) this.gxO, this.mTempRect);
        this.gxO.k(this.mTempRect);
        this.gxN.invalidate();
        if (this.gxS.gyx) {
            this.gxO.bst();
        } else if (this.gxS.gyy) {
            this.gxO.bsu();
        } else {
            this.gxO.bsv();
        }
    }

    private void a(b bVar) {
        bVar.gyx = false;
        bVar.gyy = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.gxN.getWidth() - this.gxU) - this.gxV;
        if (rect.left < this.gxU) {
            rect.left = this.gxU;
            rect.right = rect.left + width;
        }
        if (rect.right > this.gxU + width2) {
            rect.right = this.gxU + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.gxU + this.gxR) {
            bVar.gyx = true;
            bVar.gyy = false;
        }
        if (rect.right > (this.gxU + width2) - this.gxR) {
            bVar.gyx = false;
            bVar.gyy = true;
        }
    }

    public void a(d dVar) {
        this.gxO = dVar;
    }

    public void a(c cVar) {
        this.gxP = cVar;
        this.gxP.setDragController(this);
    }
}
