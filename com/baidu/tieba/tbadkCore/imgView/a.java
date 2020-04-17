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
    public float cjX;
    private DragLayer kTY;
    private d kTZ;
    private c kUa;
    public boolean kUb;
    private float kUc;
    private b kUd;
    private Rect kUe;
    private int kUf;
    private int kUg;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.kUc = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.kTY = dragLayer;
        dragLayer.setDragController(this);
        this.kUf = this.kTY.getPaddingLeft();
        this.kUg = this.kTY.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.kTY != null && view != null && view.getDrawingCache() != null) {
            this.kUb = true;
            this.kUd = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.kTY.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.kUd.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.kUd.rect = rect;
            this.kUd.kUG = bundle;
            view.setVisibility(4);
            a(this.kUd);
            this.kTY.setDragObject(this.kUd);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.kUb) {
            this.kUb = false;
            this.kUd = null;
            this.kTZ.cWQ();
            this.kTZ.cWR();
            this.kTY.cWT();
            this.kTY.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.cjX = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.kUb;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.kUb) {
            if (this.kUe == null) {
                this.kUe = new Rect();
                this.kTY.getDrawingRect(this.kUe);
                Rect rect = this.kUe;
                rect.top = (int) (rect.top - this.kUc);
                Rect rect2 = this.kUe;
                rect2.bottom = (int) (rect2.bottom + this.kUc);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.cjX = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.cjX = x;
                    this.kUd.rect.offset((int) (x - this.cjX), 0);
                    a(this.kUd);
                    cWM();
                    break;
            }
            return true;
        }
        return false;
    }

    public void cWM() {
        this.mTempRect.set(this.kUd.rect);
        this.kTY.offsetRectIntoDescendantCoords((View) this.kTZ, this.mTempRect);
        this.kTZ.j(this.mTempRect);
        this.kTY.invalidate();
        if (this.kUd.kUH) {
            this.kTZ.cWO();
        } else if (this.kUd.kUI) {
            this.kTZ.cWP();
        } else {
            this.kTZ.cWQ();
        }
    }

    private void a(b bVar) {
        bVar.kUH = false;
        bVar.kUI = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.kTY.getWidth() - this.kUf) - this.kUg;
        if (rect.left < this.kUf) {
            rect.left = this.kUf;
            rect.right = rect.left + width;
        }
        if (rect.right > this.kUf + width2) {
            rect.right = this.kUf + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.kUf + this.kUc) {
            bVar.kUH = true;
            bVar.kUI = false;
        }
        if (rect.right > (this.kUf + width2) - this.kUc) {
            bVar.kUH = false;
            bVar.kUI = true;
        }
    }

    public void a(d dVar) {
        this.kTZ = dVar;
    }

    public void a(c cVar) {
        this.kUa = cVar;
        this.kUa.setDragController(this);
    }
}
