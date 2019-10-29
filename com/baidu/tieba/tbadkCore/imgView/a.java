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
    public float bdr;
    private Vibrator brC;
    private DragLayer jjX;
    private d jjY;
    private c jjZ;
    public boolean jka;
    private float jkb;
    private b jkc;
    private Rect jkd;
    private int jke;
    private int jkf;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.brC = (Vibrator) context.getSystemService("vibrator");
        this.jkb = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.jjX = dragLayer;
        dragLayer.setDragController(this);
        this.jke = this.jjX.getPaddingLeft();
        this.jkf = this.jjX.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.jjX != null && view != null && view.getDrawingCache() != null) {
            this.jka = true;
            this.jkc = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.jjX.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.jkc.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.jkc.apc = rect;
            this.jkc.jkF = bundle;
            view.setVisibility(4);
            a(this.jkc);
            this.jjX.setDragObject(this.jkc);
            this.brC.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.jka) {
            this.jka = false;
            this.jkc = null;
            this.jjY.coP();
            this.jjY.coQ();
            this.jjX.coS();
            this.jjX.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.bdr = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.jka;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jka) {
            if (this.jkd == null) {
                this.jkd = new Rect();
                this.jjX.getDrawingRect(this.jkd);
                Rect rect = this.jkd;
                rect.top = (int) (rect.top - this.jkb);
                Rect rect2 = this.jkd;
                rect2.bottom = (int) (rect2.bottom + this.jkb);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bdr = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.bdr = x;
                    this.jkc.apc.offset((int) (x - this.bdr), 0);
                    a(this.jkc);
                    coL();
                    break;
            }
            return true;
        }
        return false;
    }

    public void coL() {
        this.mTempRect.set(this.jkc.apc);
        this.jjX.offsetRectIntoDescendantCoords((View) this.jjY, this.mTempRect);
        this.jjY.j(this.mTempRect);
        this.jjX.invalidate();
        if (this.jkc.jkG) {
            this.jjY.coN();
        } else if (this.jkc.jkH) {
            this.jjY.coO();
        } else {
            this.jjY.coP();
        }
    }

    private void a(b bVar) {
        bVar.jkG = false;
        bVar.jkH = false;
        Rect rect = bVar.apc;
        int width = rect.width();
        int width2 = (this.jjX.getWidth() - this.jke) - this.jkf;
        if (rect.left < this.jke) {
            rect.left = this.jke;
            rect.right = rect.left + width;
        }
        if (rect.right > this.jke + width2) {
            rect.right = this.jke + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.jke + this.jkb) {
            bVar.jkG = true;
            bVar.jkH = false;
        }
        if (rect.right > (this.jke + width2) - this.jkb) {
            bVar.jkG = false;
            bVar.jkH = true;
        }
    }

    public void a(d dVar) {
        this.jjY = dVar;
    }

    public void a(c cVar) {
        this.jjZ = cVar;
        this.jjZ.setDragController(this);
    }
}
