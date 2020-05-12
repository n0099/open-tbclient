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
    public float ckd;
    private DragLayer kUc;
    private d kUd;
    private c kUe;
    public boolean kUf;
    private float kUg;
    private b kUh;
    private Rect kUi;
    private int kUj;
    private int kUk;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.kUg = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.kUc = dragLayer;
        dragLayer.setDragController(this);
        this.kUj = this.kUc.getPaddingLeft();
        this.kUk = this.kUc.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.kUc != null && view != null && view.getDrawingCache() != null) {
            this.kUf = true;
            this.kUh = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.kUc.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.kUh.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.kUh.rect = rect;
            this.kUh.kUK = bundle;
            view.setVisibility(4);
            a(this.kUh);
            this.kUc.setDragObject(this.kUh);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.kUf) {
            this.kUf = false;
            this.kUh = null;
            this.kUd.cWO();
            this.kUd.cWP();
            this.kUc.cWR();
            this.kUc.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.ckd = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.kUf;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.kUf) {
            if (this.kUi == null) {
                this.kUi = new Rect();
                this.kUc.getDrawingRect(this.kUi);
                Rect rect = this.kUi;
                rect.top = (int) (rect.top - this.kUg);
                Rect rect2 = this.kUi;
                rect2.bottom = (int) (rect2.bottom + this.kUg);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.ckd = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.ckd = x;
                    this.kUh.rect.offset((int) (x - this.ckd), 0);
                    a(this.kUh);
                    cWK();
                    break;
            }
            return true;
        }
        return false;
    }

    public void cWK() {
        this.mTempRect.set(this.kUh.rect);
        this.kUc.offsetRectIntoDescendantCoords((View) this.kUd, this.mTempRect);
        this.kUd.j(this.mTempRect);
        this.kUc.invalidate();
        if (this.kUh.kUL) {
            this.kUd.cWM();
        } else if (this.kUh.kUM) {
            this.kUd.cWN();
        } else {
            this.kUd.cWO();
        }
    }

    private void a(b bVar) {
        bVar.kUL = false;
        bVar.kUM = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.kUc.getWidth() - this.kUj) - this.kUk;
        if (rect.left < this.kUj) {
            rect.left = this.kUj;
            rect.right = rect.left + width;
        }
        if (rect.right > this.kUj + width2) {
            rect.right = this.kUj + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.kUj + this.kUg) {
            bVar.kUL = true;
            bVar.kUM = false;
        }
        if (rect.right > (this.kUj + width2) - this.kUg) {
            bVar.kUL = false;
            bVar.kUM = true;
        }
    }

    public void a(d dVar) {
        this.kUd = dVar;
    }

    public void a(c cVar) {
        this.kUe = cVar;
        this.kUe.setDragController(this);
    }
}
