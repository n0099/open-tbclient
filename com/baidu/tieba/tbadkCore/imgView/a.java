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
    public float bGl;
    private int kdA;
    private DragLayer kds;
    private d kdt;
    private c kdu;
    public boolean kdv;
    private float kdw;
    private b kdx;
    private Rect kdy;
    private int kdz;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.kdw = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.kds = dragLayer;
        dragLayer.setDragController(this);
        this.kdz = this.kds.getPaddingLeft();
        this.kdA = this.kds.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.kds != null && view != null && view.getDrawingCache() != null) {
            this.kdv = true;
            this.kdx = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.kds.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.kdx.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.kdx.rect = rect;
            this.kdx.kea = bundle;
            view.setVisibility(4);
            a(this.kdx);
            this.kds.setDragObject(this.kdx);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.kdv) {
            this.kdv = false;
            this.kdx = null;
            this.kdt.cIT();
            this.kdt.cIU();
            this.kds.cIW();
            this.kds.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.bGl = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.kdv;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.kdv) {
            if (this.kdy == null) {
                this.kdy = new Rect();
                this.kds.getDrawingRect(this.kdy);
                Rect rect = this.kdy;
                rect.top = (int) (rect.top - this.kdw);
                Rect rect2 = this.kdy;
                rect2.bottom = (int) (rect2.bottom + this.kdw);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bGl = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.bGl = x;
                    this.kdx.rect.offset((int) (x - this.bGl), 0);
                    a(this.kdx);
                    cIP();
                    break;
            }
            return true;
        }
        return false;
    }

    public void cIP() {
        this.mTempRect.set(this.kdx.rect);
        this.kds.offsetRectIntoDescendantCoords((View) this.kdt, this.mTempRect);
        this.kdt.j(this.mTempRect);
        this.kds.invalidate();
        if (this.kdx.keb) {
            this.kdt.cIR();
        } else if (this.kdx.kec) {
            this.kdt.cIS();
        } else {
            this.kdt.cIT();
        }
    }

    private void a(b bVar) {
        bVar.keb = false;
        bVar.kec = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.kds.getWidth() - this.kdz) - this.kdA;
        if (rect.left < this.kdz) {
            rect.left = this.kdz;
            rect.right = rect.left + width;
        }
        if (rect.right > this.kdz + width2) {
            rect.right = this.kdz + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.kdz + this.kdw) {
            bVar.keb = true;
            bVar.kec = false;
        }
        if (rect.right > (this.kdz + width2) - this.kdw) {
            bVar.keb = false;
            bVar.kec = true;
        }
    }

    public void a(d dVar) {
        this.kdt = dVar;
    }

    public void a(c cVar) {
        this.kdu = cVar;
        this.kdu.setDragController(this);
    }
}
