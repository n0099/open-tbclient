package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    public float bHx;
    private DragLayer hbS;
    private Vibrator hbT;
    private e hbU;
    private d hbV;
    public boolean hbW;
    private float hbX;
    private c hbY;
    private Rect hbZ;
    private int hca;
    private int hcb;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.hbT = (Vibrator) context.getSystemService("vibrator");
        this.hbX = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.hbS = dragLayer;
        dragLayer.setDragController(this);
        this.hca = this.hbS.getPaddingLeft();
        this.hcb = this.hbS.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.hbS != null && view != null && view.getDrawingCache() != null) {
            this.hbW = true;
            this.hbY = new c(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.hbS.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.hbY.bEq = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.hbY.rect = rect;
            this.hbY.hcD = bundle;
            view.setVisibility(4);
            a(this.hbY);
            this.hbS.setDragObject(this.hbY);
            this.hbT.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.hbW) {
            this.hbW = false;
            this.hbY = null;
            this.hbU.bxq();
            this.hbU.bxr();
            this.hbS.bxt();
            this.hbS.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.bHx = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.hbW;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hbW) {
            if (this.hbZ == null) {
                this.hbZ = new Rect();
                this.hbS.getDrawingRect(this.hbZ);
                Rect rect = this.hbZ;
                rect.top = (int) (rect.top - this.hbX);
                Rect rect2 = this.hbZ;
                rect2.bottom = (int) (rect2.bottom + this.hbX);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bHx = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.bHx = x;
                    this.hbY.rect.offset((int) (x - this.bHx), 0);
                    a(this.hbY);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.hbY.rect);
        this.hbS.offsetRectIntoDescendantCoords((View) this.hbU, this.mTempRect);
        this.hbU.o(this.mTempRect);
        this.hbS.invalidate();
        if (this.hbY.hcE) {
            this.hbU.bxo();
        } else if (this.hbY.hcF) {
            this.hbU.bxp();
        } else {
            this.hbU.bxq();
        }
    }

    private void a(c cVar) {
        cVar.hcE = false;
        cVar.hcF = false;
        Rect rect = cVar.rect;
        int width = rect.width();
        int width2 = (this.hbS.getWidth() - this.hca) - this.hcb;
        if (rect.left < this.hca) {
            rect.left = this.hca;
            rect.right = rect.left + width;
        }
        if (rect.right > this.hca + width2) {
            rect.right = this.hca + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.hca + this.hbX) {
            cVar.hcE = true;
            cVar.hcF = false;
        }
        if (rect.right > (this.hca + width2) - this.hbX) {
            cVar.hcE = false;
            cVar.hcF = true;
        }
    }

    public void a(e eVar) {
        this.hbU = eVar;
    }

    public void a(d dVar) {
        this.hbV = dVar;
        this.hbV.setDragController(this);
    }
}
