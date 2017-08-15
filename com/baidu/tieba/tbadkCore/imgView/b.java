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
    public float fEL;
    private DragLayer gkV;
    private Vibrator gkW;
    private e gkX;
    private d gkY;
    public boolean gkZ;
    private float gla;
    private c glb;
    private Rect glc;
    private int gld;
    private int gle;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.gkW = (Vibrator) context.getSystemService("vibrator");
        this.gla = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.gkV = dragLayer;
        dragLayer.setDragController(this);
        this.gld = this.gkV.getPaddingLeft();
        this.gle = this.gkV.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.gkV != null && view != null && view.getDrawingCache() != null) {
            this.gkZ = true;
            this.glb = new c(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.gkV.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.glb.aNT = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.glb.rect = rect;
            this.glb.glG = bundle;
            view.setVisibility(4);
            a(this.glb);
            this.gkV.setDragObject(this.glb);
            this.gkW.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.gkZ) {
            this.gkZ = false;
            this.glb = null;
            this.gkX.btD();
            this.gkX.btE();
            this.gkV.btG();
            this.gkV.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.fEL = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.gkZ;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gkZ) {
            if (this.glc == null) {
                this.glc = new Rect();
                this.gkV.getDrawingRect(this.glc);
                Rect rect = this.glc;
                rect.top = (int) (rect.top - this.gla);
                Rect rect2 = this.glc;
                rect2.bottom = (int) (rect2.bottom + this.gla);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.fEL = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.fEL = x;
                    this.glb.rect.offset((int) (x - this.fEL), 0);
                    a(this.glb);
                    btz();
                    break;
            }
            return true;
        }
        return false;
    }

    public void btz() {
        this.mTempRect.set(this.glb.rect);
        this.gkV.offsetRectIntoDescendantCoords((View) this.gkX, this.mTempRect);
        this.gkX.e(this.mTempRect);
        this.gkV.invalidate();
        if (this.glb.glH) {
            this.gkX.btB();
        } else if (this.glb.glI) {
            this.gkX.btC();
        } else {
            this.gkX.btD();
        }
    }

    private void a(c cVar) {
        cVar.glH = false;
        cVar.glI = false;
        Rect rect = cVar.rect;
        int width = rect.width();
        int width2 = (this.gkV.getWidth() - this.gld) - this.gle;
        if (rect.left < this.gld) {
            rect.left = this.gld;
            rect.right = rect.left + width;
        }
        if (rect.right > this.gld + width2) {
            rect.right = this.gld + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.gld + this.gla) {
            cVar.glH = true;
            cVar.glI = false;
        }
        if (rect.right > (this.gld + width2) - this.gla) {
            cVar.glH = false;
            cVar.glI = true;
        }
    }

    public void a(e eVar) {
        this.gkX = eVar;
    }

    public void a(d dVar) {
        this.gkY = dVar;
        this.gkY.setDragController(this);
    }
}
