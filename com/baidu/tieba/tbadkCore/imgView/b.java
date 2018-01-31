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
    public float bFG;
    private DragLayer gZT;
    private Vibrator gZU;
    private e gZV;
    private d gZW;
    public boolean gZX;
    private float gZY;
    private c gZZ;
    private Rect haa;
    private int hab;
    private int hac;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.gZU = (Vibrator) context.getSystemService("vibrator");
        this.gZY = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.gZT = dragLayer;
        dragLayer.setDragController(this);
        this.hab = this.gZT.getPaddingLeft();
        this.hac = this.gZT.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.gZT != null && view != null && view.getDrawingCache() != null) {
            this.gZX = true;
            this.gZZ = new c(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.gZT.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.gZZ.bCz = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.gZZ.rect = rect;
            this.gZZ.haE = bundle;
            view.setVisibility(4);
            a(this.gZZ);
            this.gZT.setDragObject(this.gZZ);
            this.gZU.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.gZX) {
            this.gZX = false;
            this.gZZ = null;
            this.gZV.bwi();
            this.gZV.bwj();
            this.gZT.bwl();
            this.gZT.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.bFG = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.gZX;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gZX) {
            if (this.haa == null) {
                this.haa = new Rect();
                this.gZT.getDrawingRect(this.haa);
                Rect rect = this.haa;
                rect.top = (int) (rect.top - this.gZY);
                Rect rect2 = this.haa;
                rect2.bottom = (int) (rect2.bottom + this.gZY);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bFG = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.bFG = x;
                    this.gZZ.rect.offset((int) (x - this.bFG), 0);
                    a(this.gZZ);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.gZZ.rect);
        this.gZT.offsetRectIntoDescendantCoords((View) this.gZV, this.mTempRect);
        this.gZV.n(this.mTempRect);
        this.gZT.invalidate();
        if (this.gZZ.haF) {
            this.gZV.bwg();
        } else if (this.gZZ.haG) {
            this.gZV.bwh();
        } else {
            this.gZV.bwi();
        }
    }

    private void a(c cVar) {
        cVar.haF = false;
        cVar.haG = false;
        Rect rect = cVar.rect;
        int width = rect.width();
        int width2 = (this.gZT.getWidth() - this.hab) - this.hac;
        if (rect.left < this.hab) {
            rect.left = this.hab;
            rect.right = rect.left + width;
        }
        if (rect.right > this.hab + width2) {
            rect.right = this.hab + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.hab + this.gZY) {
            cVar.haF = true;
            cVar.haG = false;
        }
        if (rect.right > (this.hab + width2) - this.gZY) {
            cVar.haF = false;
            cVar.haG = true;
        }
    }

    public void a(e eVar) {
        this.gZV = eVar;
    }

    public void a(d dVar) {
        this.gZW = dVar;
        this.gZW.setDragController(this);
    }
}
