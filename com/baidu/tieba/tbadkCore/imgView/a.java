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
    private DragLayer hmH;
    private d hmI;
    private c hmJ;
    public boolean hmK;
    private float hmL;
    private b hmM;
    private Rect hmN;
    private int hmO;
    private int hmP;
    private Context mContext;
    public float mStartX;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.hmL = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.hmH = dragLayer;
        dragLayer.setDragController(this);
        this.hmO = this.hmH.getPaddingLeft();
        this.hmP = this.hmH.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.hmH != null && view != null && view.getDrawingCache() != null) {
            this.hmK = true;
            this.hmM = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.hmH.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.hmM.bjV = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.hmM.rect = rect;
            this.hmM.hnp = bundle;
            view.setVisibility(4);
            a(this.hmM);
            this.hmH.setDragObject(this.hmM);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.hmK) {
            this.hmK = false;
            this.hmM = null;
            this.hmI.bDP();
            this.hmI.bDQ();
            this.hmH.bDS();
            this.hmH.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.mStartX = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.hmK;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hmK) {
            if (this.hmN == null) {
                this.hmN = new Rect();
                this.hmH.getDrawingRect(this.hmN);
                Rect rect = this.hmN;
                rect.top = (int) (rect.top - this.hmL);
                Rect rect2 = this.hmN;
                rect2.bottom = (int) (rect2.bottom + this.hmL);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.mStartX = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.mStartX = x;
                    this.hmM.rect.offset((int) (x - this.mStartX), 0);
                    a(this.hmM);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.hmM.rect);
        this.hmH.offsetRectIntoDescendantCoords((View) this.hmI, this.mTempRect);
        this.hmI.m(this.mTempRect);
        this.hmH.invalidate();
        if (this.hmM.hnq) {
            this.hmI.bDN();
        } else if (this.hmM.hnr) {
            this.hmI.bDO();
        } else {
            this.hmI.bDP();
        }
    }

    private void a(b bVar) {
        bVar.hnq = false;
        bVar.hnr = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.hmH.getWidth() - this.hmO) - this.hmP;
        if (rect.left < this.hmO) {
            rect.left = this.hmO;
            rect.right = rect.left + width;
        }
        if (rect.right > this.hmO + width2) {
            rect.right = this.hmO + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.hmO + this.hmL) {
            bVar.hnq = true;
            bVar.hnr = false;
        }
        if (rect.right > (this.hmO + width2) - this.hmL) {
            bVar.hnq = false;
            bVar.hnr = true;
        }
    }

    public void a(d dVar) {
        this.hmI = dVar;
    }

    public void a(c cVar) {
        this.hmJ = cVar;
        this.hmJ.setDragController(this);
    }
}
