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
    public float beq;
    private Vibrator daL;
    private DragLayer gWV;
    private d gWW;
    private c gWX;
    public boolean gWY;
    private float gWZ;
    private b gXa;
    private Rect gXb;
    private int gXc;
    private int gXd;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.daL = (Vibrator) context.getSystemService("vibrator");
        this.gWZ = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.gWV = dragLayer;
        dragLayer.setDragController(this);
        this.gXc = this.gWV.getPaddingLeft();
        this.gXd = this.gWV.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.gWV != null && view != null && view.getDrawingCache() != null) {
            this.gWY = true;
            this.gXa = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.gWV.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.gXa.bbh = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.gXa.rect = rect;
            this.gXa.gXE = bundle;
            view.setVisibility(4);
            a(this.gXa);
            this.gWV.setDragObject(this.gXa);
            this.daL.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.gWY) {
            this.gWY = false;
            this.gXa = null;
            this.gWW.bzj();
            this.gWW.bzk();
            this.gWV.bzm();
            this.gWV.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.beq = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.gWY;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gWY) {
            if (this.gXb == null) {
                this.gXb = new Rect();
                this.gWV.getDrawingRect(this.gXb);
                Rect rect = this.gXb;
                rect.top = (int) (rect.top - this.gWZ);
                Rect rect2 = this.gXb;
                rect2.bottom = (int) (rect2.bottom + this.gWZ);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.beq = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.beq = x;
                    this.gXa.rect.offset((int) (x - this.beq), 0);
                    a(this.gXa);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.gXa.rect);
        this.gWV.offsetRectIntoDescendantCoords((View) this.gWW, this.mTempRect);
        this.gWW.m(this.mTempRect);
        this.gWV.invalidate();
        if (this.gXa.gXF) {
            this.gWW.bzh();
        } else if (this.gXa.gXG) {
            this.gWW.bzi();
        } else {
            this.gWW.bzj();
        }
    }

    private void a(b bVar) {
        bVar.gXF = false;
        bVar.gXG = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.gWV.getWidth() - this.gXc) - this.gXd;
        if (rect.left < this.gXc) {
            rect.left = this.gXc;
            rect.right = rect.left + width;
        }
        if (rect.right > this.gXc + width2) {
            rect.right = this.gXc + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.gXc + this.gWZ) {
            bVar.gXF = true;
            bVar.gXG = false;
        }
        if (rect.right > (this.gXc + width2) - this.gWZ) {
            bVar.gXF = false;
            bVar.gXG = true;
        }
    }

    public void a(d dVar) {
        this.gWW = dVar;
    }

    public void a(c cVar) {
        this.gWX = cVar;
        this.gWX.setDragController(this);
    }
}
