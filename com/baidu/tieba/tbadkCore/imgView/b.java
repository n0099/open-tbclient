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
    public float aRA;
    private DragLayer gDf;
    private Vibrator gDg;
    private e gDh;
    private d gDi;
    public boolean gDj;
    private float gDk;
    private c gDl;
    private Rect gDm;
    private int gDn;
    private int gDo;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.gDg = (Vibrator) context.getSystemService("vibrator");
        this.gDk = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.gDf = dragLayer;
        dragLayer.setDragController(this);
        this.gDn = this.gDf.getPaddingLeft();
        this.gDo = this.gDf.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.gDf != null && view != null && view.getDrawingCache() != null) {
            this.gDj = true;
            this.gDl = new c(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.gDf.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.gDl.aOs = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.gDl.rect = rect;
            this.gDl.gDQ = bundle;
            view.setVisibility(4);
            a(this.gDl);
            this.gDf.setDragObject(this.gDl);
            this.gDg.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.gDj) {
            this.gDj = false;
            this.gDl = null;
            this.gDh.bxu();
            this.gDh.bxv();
            this.gDf.bxx();
            this.gDf.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.aRA = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.gDj;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gDj) {
            if (this.gDm == null) {
                this.gDm = new Rect();
                this.gDf.getDrawingRect(this.gDm);
                Rect rect = this.gDm;
                rect.top = (int) (rect.top - this.gDk);
                Rect rect2 = this.gDm;
                rect2.bottom = (int) (rect2.bottom + this.gDk);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.aRA = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.aRA = x;
                    this.gDl.rect.offset((int) (x - this.aRA), 0);
                    a(this.gDl);
                    bxq();
                    break;
            }
            return true;
        }
        return false;
    }

    public void bxq() {
        this.mTempRect.set(this.gDl.rect);
        this.gDf.offsetRectIntoDescendantCoords((View) this.gDh, this.mTempRect);
        this.gDh.j(this.mTempRect);
        this.gDf.invalidate();
        if (this.gDl.gDR) {
            this.gDh.bxs();
        } else if (this.gDl.gDS) {
            this.gDh.bxt();
        } else {
            this.gDh.bxu();
        }
    }

    private void a(c cVar) {
        cVar.gDR = false;
        cVar.gDS = false;
        Rect rect = cVar.rect;
        int width = rect.width();
        int width2 = (this.gDf.getWidth() - this.gDn) - this.gDo;
        if (rect.left < this.gDn) {
            rect.left = this.gDn;
            rect.right = rect.left + width;
        }
        if (rect.right > this.gDn + width2) {
            rect.right = this.gDn + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.gDn + this.gDk) {
            cVar.gDR = true;
            cVar.gDS = false;
        }
        if (rect.right > (this.gDn + width2) - this.gDk) {
            cVar.gDR = false;
            cVar.gDS = true;
        }
    }

    public void a(e eVar) {
        this.gDh = eVar;
    }

    public void a(d dVar) {
        this.gDi = dVar;
        this.gDi.setDragController(this);
    }
}
