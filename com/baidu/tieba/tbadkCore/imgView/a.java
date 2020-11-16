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
    public float dmq;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;
    private int mZA;
    private DragLayer mZs;
    private d mZt;
    private c mZu;
    public boolean mZv;
    private float mZw;
    private b mZx;
    private Rect mZy;
    private int mZz;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.mZw = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.mZs = dragLayer;
        dragLayer.setDragController(this);
        this.mZz = this.mZs.getPaddingLeft();
        this.mZA = this.mZs.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.mZs != null && view != null && view.getDrawingCache() != null) {
            this.mZv = true;
            this.mZx = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.mZs.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.mZx.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.mZx.bCa = rect;
            this.mZx.nab = bundle;
            view.setVisibility(4);
            a(this.mZx);
            this.mZs.setDragObject(this.mZx);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.mZv) {
            this.mZv = false;
            this.mZx = null;
            this.mZt.dKo();
            this.mZt.dKp();
            this.mZs.dKr();
            this.mZs.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.dmq = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.mZv;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mZv) {
            if (this.mZy == null) {
                this.mZy = new Rect();
                this.mZs.getDrawingRect(this.mZy);
                Rect rect = this.mZy;
                rect.top = (int) (rect.top - this.mZw);
                Rect rect2 = this.mZy;
                rect2.bottom = (int) (rect2.bottom + this.mZw);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.dmq = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.dmq = x;
                    this.mZx.bCa.offset((int) (x - this.dmq), 0);
                    a(this.mZx);
                    dKk();
                    break;
            }
            return true;
        }
        return false;
    }

    public void dKk() {
        this.mTempRect.set(this.mZx.bCa);
        this.mZs.offsetRectIntoDescendantCoords((View) this.mZt, this.mTempRect);
        this.mZt.j(this.mTempRect);
        this.mZs.invalidate();
        if (this.mZx.nac) {
            this.mZt.dKm();
        } else if (this.mZx.nad) {
            this.mZt.dKn();
        } else {
            this.mZt.dKo();
        }
    }

    private void a(b bVar) {
        bVar.nac = false;
        bVar.nad = false;
        Rect rect = bVar.bCa;
        int width = rect.width();
        int width2 = (this.mZs.getWidth() - this.mZz) - this.mZA;
        if (rect.left < this.mZz) {
            rect.left = this.mZz;
            rect.right = rect.left + width;
        }
        if (rect.right > this.mZz + width2) {
            rect.right = this.mZz + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.mZz + this.mZw) {
            bVar.nac = true;
            bVar.nad = false;
        }
        if (rect.right > (this.mZz + width2) - this.mZw) {
            bVar.nac = false;
            bVar.nad = true;
        }
    }

    public void a(d dVar) {
        this.mZt = dVar;
    }

    public void a(c cVar) {
        this.mZu = cVar;
        this.mZu.setDragController(this);
    }
}
