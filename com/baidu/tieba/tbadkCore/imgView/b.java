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
    public float aOs;
    private d gqA;
    public boolean gqB;
    private float gqC;
    private c gqD;
    private Rect gqE;
    private int gqF;
    private int gqG;
    private DragLayer gqx;
    private Vibrator gqy;
    private e gqz;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.gqy = (Vibrator) context.getSystemService("vibrator");
        this.gqC = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.gqx = dragLayer;
        dragLayer.setDragController(this);
        this.gqF = this.gqx.getPaddingLeft();
        this.gqG = this.gqx.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.gqx != null && view != null && view.getDrawingCache() != null) {
            this.gqB = true;
            this.gqD = new c(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.gqx.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.gqD.aNG = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.gqD.rect = rect;
            this.gqD.gri = bundle;
            view.setVisibility(4);
            a(this.gqD);
            this.gqx.setDragObject(this.gqD);
            this.gqy.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.gqB) {
            this.gqB = false;
            this.gqD = null;
            this.gqz.buR();
            this.gqz.buS();
            this.gqx.buU();
            this.gqx.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.aOs = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.gqB;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gqB) {
            if (this.gqE == null) {
                this.gqE = new Rect();
                this.gqx.getDrawingRect(this.gqE);
                Rect rect = this.gqE;
                rect.top = (int) (rect.top - this.gqC);
                Rect rect2 = this.gqE;
                rect2.bottom = (int) (rect2.bottom + this.gqC);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.aOs = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.aOs = x;
                    this.gqD.rect.offset((int) (x - this.aOs), 0);
                    a(this.gqD);
                    buN();
                    break;
            }
            return true;
        }
        return false;
    }

    public void buN() {
        this.mTempRect.set(this.gqD.rect);
        this.gqx.offsetRectIntoDescendantCoords((View) this.gqz, this.mTempRect);
        this.gqz.j(this.mTempRect);
        this.gqx.invalidate();
        if (this.gqD.grj) {
            this.gqz.buP();
        } else if (this.gqD.grk) {
            this.gqz.buQ();
        } else {
            this.gqz.buR();
        }
    }

    private void a(c cVar) {
        cVar.grj = false;
        cVar.grk = false;
        Rect rect = cVar.rect;
        int width = rect.width();
        int width2 = (this.gqx.getWidth() - this.gqF) - this.gqG;
        if (rect.left < this.gqF) {
            rect.left = this.gqF;
            rect.right = rect.left + width;
        }
        if (rect.right > this.gqF + width2) {
            rect.right = this.gqF + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.gqF + this.gqC) {
            cVar.grj = true;
            cVar.grk = false;
        }
        if (rect.right > (this.gqF + width2) - this.gqC) {
            cVar.grj = false;
            cVar.grk = true;
        }
    }

    public void a(e eVar) {
        this.gqz = eVar;
    }

    public void a(d dVar) {
        this.gqA = dVar;
        this.gqA.setDragController(this);
    }
}
