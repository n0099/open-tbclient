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
    private Vibrator cJT;
    private DragLayer gxK;
    private d gxL;
    private c gxM;
    public boolean gxN;
    private float gxO;
    private b gxP;
    private Rect gxQ;
    private int gxR;
    private int gxS;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.cJT = (Vibrator) context.getSystemService("vibrator");
        this.gxO = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.gxK = dragLayer;
        dragLayer.setDragController(this);
        this.gxR = this.gxK.getPaddingLeft();
        this.gxS = this.gxK.getPaddingRight();
    }

    public void b(View view2, Bundle bundle) {
        if (this.gxK != null && view2 != null && view2.getDrawingCache() != null) {
            this.gxN = true;
            this.gxP = new b(this.mContext);
            Rect rect = new Rect();
            view2.getDrawingRect(rect);
            this.gxK.offsetDescendantRectToMyCoords(view2, rect);
            view2.setDrawingCacheEnabled(true);
            view2.buildDrawingCache();
            this.gxP.aOQ = Bitmap.createBitmap(view2.getDrawingCache());
            view2.destroyDrawingCache();
            view2.setDrawingCacheEnabled(false);
            this.gxP.rect = rect;
            this.gxP.gyt = bundle;
            view2.setVisibility(4);
            a(this.gxP);
            this.gxK.setDragObject(this.gxP);
            this.cJT.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.gxN) {
            this.gxN = false;
            this.gxP = null;
            this.gxL.bsv();
            this.gxL.bsw();
            this.gxK.bsy();
            this.gxK.invalidate();
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
        return this.gxN;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gxN) {
            if (this.gxQ == null) {
                this.gxQ = new Rect();
                this.gxK.getDrawingRect(this.gxQ);
                Rect rect = this.gxQ;
                rect.top = (int) (rect.top - this.gxO);
                Rect rect2 = this.gxQ;
                rect2.bottom = (int) (rect2.bottom + this.gxO);
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
                    this.gxP.rect.offset((int) (x - this.aSa), 0);
                    a(this.gxP);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.gxP.rect);
        this.gxK.offsetRectIntoDescendantCoords((View) this.gxL, this.mTempRect);
        this.gxL.k(this.mTempRect);
        this.gxK.invalidate();
        if (this.gxP.gyu) {
            this.gxL.bst();
        } else if (this.gxP.gyv) {
            this.gxL.bsu();
        } else {
            this.gxL.bsv();
        }
    }

    private void a(b bVar) {
        bVar.gyu = false;
        bVar.gyv = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.gxK.getWidth() - this.gxR) - this.gxS;
        if (rect.left < this.gxR) {
            rect.left = this.gxR;
            rect.right = rect.left + width;
        }
        if (rect.right > this.gxR + width2) {
            rect.right = this.gxR + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.gxR + this.gxO) {
            bVar.gyu = true;
            bVar.gyv = false;
        }
        if (rect.right > (this.gxR + width2) - this.gxO) {
            bVar.gyu = false;
            bVar.gyv = true;
        }
    }

    public void a(d dVar) {
        this.gxL = dVar;
    }

    public void a(c cVar) {
        this.gxM = cVar;
        this.gxM.setDragController(this);
    }
}
