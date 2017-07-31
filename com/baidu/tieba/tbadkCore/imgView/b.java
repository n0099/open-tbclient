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
    public float fCS;
    private DragLayer gjd;
    private Vibrator gje;
    private e gjf;
    private d gjg;
    public boolean gjh;
    private float gji;
    private c gjj;
    private Rect gjk;
    private int gjl;
    private int gjm;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.gje = (Vibrator) context.getSystemService("vibrator");
        this.gji = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.gjd = dragLayer;
        dragLayer.setDragController(this);
        this.gjl = this.gjd.getPaddingLeft();
        this.gjm = this.gjd.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.gjd != null && view != null && view.getDrawingCache() != null) {
            this.gjh = true;
            this.gjj = new c(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.gjd.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.gjj.aNS = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.gjj.rect = rect;
            this.gjj.gjO = bundle;
            view.setVisibility(4);
            a(this.gjj);
            this.gjd.setDragObject(this.gjj);
            this.gje.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.gjh) {
            this.gjh = false;
            this.gjj = null;
            this.gjf.bsV();
            this.gjf.bsW();
            this.gjd.bsY();
            this.gjd.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.fCS = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.gjh;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gjh) {
            if (this.gjk == null) {
                this.gjk = new Rect();
                this.gjd.getDrawingRect(this.gjk);
                Rect rect = this.gjk;
                rect.top = (int) (rect.top - this.gji);
                Rect rect2 = this.gjk;
                rect2.bottom = (int) (rect2.bottom + this.gji);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.fCS = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.fCS = x;
                    this.gjj.rect.offset((int) (x - this.fCS), 0);
                    a(this.gjj);
                    bsR();
                    break;
            }
            return true;
        }
        return false;
    }

    public void bsR() {
        this.mTempRect.set(this.gjj.rect);
        this.gjd.offsetRectIntoDescendantCoords((View) this.gjf, this.mTempRect);
        this.gjf.e(this.mTempRect);
        this.gjd.invalidate();
        if (this.gjj.gjP) {
            this.gjf.bsT();
        } else if (this.gjj.gjQ) {
            this.gjf.bsU();
        } else {
            this.gjf.bsV();
        }
    }

    private void a(c cVar) {
        cVar.gjP = false;
        cVar.gjQ = false;
        Rect rect = cVar.rect;
        int width = rect.width();
        int width2 = (this.gjd.getWidth() - this.gjl) - this.gjm;
        if (rect.left < this.gjl) {
            rect.left = this.gjl;
            rect.right = rect.left + width;
        }
        if (rect.right > this.gjl + width2) {
            rect.right = this.gjl + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.gjl + this.gji) {
            cVar.gjP = true;
            cVar.gjQ = false;
        }
        if (rect.right > (this.gjl + width2) - this.gji) {
            cVar.gjP = false;
            cVar.gjQ = true;
        }
    }

    public void a(e eVar) {
        this.gjf = eVar;
    }

    public void a(d dVar) {
        this.gjg = dVar;
        this.gjg.setDragController(this);
    }
}
