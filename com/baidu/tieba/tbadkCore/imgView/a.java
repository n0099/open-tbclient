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
    public float bcZ;
    private Vibrator bqL;
    private DragLayer jjg;
    private d jjh;
    private c jji;
    public boolean jjj;
    private float jjk;
    private b jjl;
    private Rect jjm;
    private int jjn;
    private int jjo;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.bqL = (Vibrator) context.getSystemService("vibrator");
        this.jjk = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.jjg = dragLayer;
        dragLayer.setDragController(this);
        this.jjn = this.jjg.getPaddingLeft();
        this.jjo = this.jjg.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.jjg != null && view != null && view.getDrawingCache() != null) {
            this.jjj = true;
            this.jjl = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.jjg.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.jjl.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.jjl.aoK = rect;
            this.jjl.jjO = bundle;
            view.setVisibility(4);
            a(this.jjl);
            this.jjg.setDragObject(this.jjl);
            this.bqL.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.jjj) {
            this.jjj = false;
            this.jjl = null;
            this.jjh.coN();
            this.jjh.coO();
            this.jjg.coQ();
            this.jjg.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.bcZ = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.jjj;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jjj) {
            if (this.jjm == null) {
                this.jjm = new Rect();
                this.jjg.getDrawingRect(this.jjm);
                Rect rect = this.jjm;
                rect.top = (int) (rect.top - this.jjk);
                Rect rect2 = this.jjm;
                rect2.bottom = (int) (rect2.bottom + this.jjk);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bcZ = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.bcZ = x;
                    this.jjl.aoK.offset((int) (x - this.bcZ), 0);
                    a(this.jjl);
                    coJ();
                    break;
            }
            return true;
        }
        return false;
    }

    public void coJ() {
        this.mTempRect.set(this.jjl.aoK);
        this.jjg.offsetRectIntoDescendantCoords((View) this.jjh, this.mTempRect);
        this.jjh.j(this.mTempRect);
        this.jjg.invalidate();
        if (this.jjl.jjP) {
            this.jjh.coL();
        } else if (this.jjl.jjQ) {
            this.jjh.coM();
        } else {
            this.jjh.coN();
        }
    }

    private void a(b bVar) {
        bVar.jjP = false;
        bVar.jjQ = false;
        Rect rect = bVar.aoK;
        int width = rect.width();
        int width2 = (this.jjg.getWidth() - this.jjn) - this.jjo;
        if (rect.left < this.jjn) {
            rect.left = this.jjn;
            rect.right = rect.left + width;
        }
        if (rect.right > this.jjn + width2) {
            rect.right = this.jjn + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.jjn + this.jjk) {
            bVar.jjP = true;
            bVar.jjQ = false;
        }
        if (rect.right > (this.jjn + width2) - this.jjk) {
            bVar.jjP = false;
            bVar.jjQ = true;
        }
    }

    public void a(d dVar) {
        this.jjh = dVar;
    }

    public void a(c cVar) {
        this.jji = cVar;
        this.jji.setDragController(this);
    }
}
