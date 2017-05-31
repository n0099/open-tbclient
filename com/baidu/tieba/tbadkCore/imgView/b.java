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
    private DragLayer fDo;
    private Vibrator fDp;
    private g fDq;
    private f fDr;
    public boolean fDs;
    private float fDt;
    private e fDu;
    private Rect fDv;
    private int fDw;
    private int fDx;
    public float feC;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.fDp = (Vibrator) context.getSystemService("vibrator");
        this.fDt = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.fDo = dragLayer;
        dragLayer.setDragController(this);
        this.fDw = this.fDo.getPaddingLeft();
        this.fDx = this.fDo.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.fDo != null && view != null && view.getDrawingCache() != null) {
            this.fDs = true;
            this.fDu = new e(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.fDo.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.fDu.aKh = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.fDu.rect = rect;
            this.fDu.fDZ = bundle;
            view.setVisibility(4);
            a(this.fDu);
            this.fDo.setDragObject(this.fDu);
            this.fDp.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.fDs) {
            this.fDs = false;
            this.fDu = null;
            this.fDq.biD();
            this.fDq.biE();
            this.fDo.biG();
            this.fDo.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.feC = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.fDs;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.fDs) {
            if (this.fDv == null) {
                this.fDv = new Rect();
                this.fDo.getDrawingRect(this.fDv);
                Rect rect = this.fDv;
                rect.top = (int) (rect.top - this.fDt);
                Rect rect2 = this.fDv;
                rect2.bottom = (int) (rect2.bottom + this.fDt);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.feC = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.feC = x;
                    this.fDu.rect.offset((int) (x - this.feC), 0);
                    a(this.fDu);
                    biz();
                    break;
            }
            return true;
        }
        return false;
    }

    public void biz() {
        this.mTempRect.set(this.fDu.rect);
        this.fDo.offsetRectIntoDescendantCoords((View) this.fDq, this.mTempRect);
        this.fDq.e(this.mTempRect);
        this.fDo.invalidate();
        if (this.fDu.fEa) {
            this.fDq.biB();
        } else if (this.fDu.fEb) {
            this.fDq.biC();
        } else {
            this.fDq.biD();
        }
    }

    private void a(e eVar) {
        eVar.fEa = false;
        eVar.fEb = false;
        Rect rect = eVar.rect;
        int width = rect.width();
        int width2 = (this.fDo.getWidth() - this.fDw) - this.fDx;
        if (rect.left < this.fDw) {
            rect.left = this.fDw;
            rect.right = rect.left + width;
        }
        if (rect.right > this.fDw + width2) {
            rect.right = this.fDw + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.fDw + this.fDt) {
            eVar.fEa = true;
            eVar.fEb = false;
        }
        if (rect.right > (this.fDw + width2) - this.fDt) {
            eVar.fEa = false;
            eVar.fEb = true;
        }
    }

    public void a(g gVar) {
        this.fDq = gVar;
    }

    public void a(f fVar) {
        this.fDr = fVar;
        this.fDr.setDragController(this);
    }
}
