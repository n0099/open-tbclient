package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    public float aOl;
    private DragLayer ghL;
    private Vibrator ghM;
    private e ghN;
    private d ghO;
    public boolean ghP;
    private float ghQ;
    private c ghR;
    private Rect ghS;
    private int ghT;
    private int ghU;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.ghM = (Vibrator) context.getSystemService("vibrator");
        this.ghQ = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.ghL = dragLayer;
        dragLayer.setDragController(this);
        this.ghT = this.ghL.getPaddingLeft();
        this.ghU = this.ghL.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.ghL != null && view != null && view.getDrawingCache() != null) {
            this.ghP = true;
            this.ghR = new c(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.ghL.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.ghR.aNc = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.ghR.rect = rect;
            this.ghR.gix = bundle;
            view.setVisibility(4);
            a(this.ghR);
            this.ghL.setDragObject(this.ghR);
            this.ghM.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.ghP) {
            this.ghP = false;
            this.ghR = null;
            this.ghN.brN();
            this.ghN.brO();
            this.ghL.brQ();
            this.ghL.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.aOl = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.ghP;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ghP) {
            if (this.ghS == null) {
                this.ghS = new Rect();
                this.ghL.getDrawingRect(this.ghS);
                Rect rect = this.ghS;
                rect.top = (int) (rect.top - this.ghQ);
                Rect rect2 = this.ghS;
                rect2.bottom = (int) (rect2.bottom + this.ghQ);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.aOl = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.aOl = x;
                    this.ghR.rect.offset((int) (x - this.aOl), 0);
                    a(this.ghR);
                    brJ();
                    break;
            }
            return true;
        }
        return false;
    }

    public void brJ() {
        this.mTempRect.set(this.ghR.rect);
        this.ghL.offsetRectIntoDescendantCoords((View) this.ghN, this.mTempRect);
        this.ghN.i(this.mTempRect);
        this.ghL.invalidate();
        if (this.ghR.giy) {
            this.ghN.brL();
        } else if (this.ghR.giz) {
            this.ghN.brM();
        } else {
            this.ghN.brN();
        }
    }

    private void a(c cVar) {
        cVar.giy = false;
        cVar.giz = false;
        Rect rect = cVar.rect;
        int width = rect.width();
        int width2 = (this.ghL.getWidth() - this.ghT) - this.ghU;
        if (rect.left < this.ghT) {
            rect.left = this.ghT;
            rect.right = rect.left + width;
        }
        if (rect.right > this.ghT + width2) {
            rect.right = this.ghT + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.ghT + this.ghQ) {
            cVar.giy = true;
            cVar.giz = false;
        }
        if (rect.right > (this.ghT + width2) - this.ghQ) {
            cVar.giy = false;
            cVar.giz = true;
        }
    }

    public void a(e eVar) {
        this.ghN = eVar;
    }

    public void a(d dVar) {
        this.ghO = dVar;
        this.ghO.setDragController(this);
    }
}
