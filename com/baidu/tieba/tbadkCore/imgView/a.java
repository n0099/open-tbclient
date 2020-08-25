package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes2.dex */
public class a {
    public float cLu;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;
    private b mgA;
    private Rect mgB;
    private int mgC;
    private int mgD;
    private DragLayer mgv;
    private d mgw;
    private c mgx;
    public boolean mgy;
    private float mgz;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.mgz = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.mgv = dragLayer;
        dragLayer.setDragController(this);
        this.mgC = this.mgv.getPaddingLeft();
        this.mgD = this.mgv.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.mgv != null && view != null && view.getDrawingCache() != null) {
            this.mgy = true;
            this.mgA = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.mgv.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.mgA.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.mgA.rect = rect;
            this.mgA.mhe = bundle;
            view.setVisibility(4);
            a(this.mgA);
            this.mgv.setDragObject(this.mgA);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.mgy) {
            this.mgy = false;
            this.mgA = null;
            this.mgw.dxd();
            this.mgw.dxe();
            this.mgv.dxg();
            this.mgv.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.cLu = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.mgy;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mgy) {
            if (this.mgB == null) {
                this.mgB = new Rect();
                this.mgv.getDrawingRect(this.mgB);
                Rect rect = this.mgB;
                rect.top = (int) (rect.top - this.mgz);
                Rect rect2 = this.mgB;
                rect2.bottom = (int) (rect2.bottom + this.mgz);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.cLu = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.cLu = x;
                    this.mgA.rect.offset((int) (x - this.cLu), 0);
                    a(this.mgA);
                    dwZ();
                    break;
            }
            return true;
        }
        return false;
    }

    public void dwZ() {
        this.mTempRect.set(this.mgA.rect);
        this.mgv.offsetRectIntoDescendantCoords((View) this.mgw, this.mTempRect);
        this.mgw.j(this.mTempRect);
        this.mgv.invalidate();
        if (this.mgA.mhf) {
            this.mgw.dxb();
        } else if (this.mgA.mhg) {
            this.mgw.dxc();
        } else {
            this.mgw.dxd();
        }
    }

    private void a(b bVar) {
        bVar.mhf = false;
        bVar.mhg = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.mgv.getWidth() - this.mgC) - this.mgD;
        if (rect.left < this.mgC) {
            rect.left = this.mgC;
            rect.right = rect.left + width;
        }
        if (rect.right > this.mgC + width2) {
            rect.right = this.mgC + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.mgC + this.mgz) {
            bVar.mhf = true;
            bVar.mhg = false;
        }
        if (rect.right > (this.mgC + width2) - this.mgz) {
            bVar.mhf = false;
            bVar.mhg = true;
        }
    }

    public void a(d dVar) {
        this.mgw = dVar;
    }

    public void a(c cVar) {
        this.mgx = cVar;
        this.mgx.setDragController(this);
    }
}
