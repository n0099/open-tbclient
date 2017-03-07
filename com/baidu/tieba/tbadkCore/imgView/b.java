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
    public float eZF;
    private DragLayer fvo;
    private Vibrator fvp;
    private g fvq;
    private f fvr;
    public boolean fvs;
    private float fvt;
    private e fvu;
    private Rect fvv;
    private int fvw;
    private int fvx;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.fvp = (Vibrator) context.getSystemService("vibrator");
        this.fvt = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.fvo = dragLayer;
        dragLayer.setDragController(this);
        this.fvw = this.fvo.getPaddingLeft();
        this.fvx = this.fvo.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.fvo != null && view != null && view.getDrawingCache() != null) {
            this.fvs = true;
            this.fvu = new e(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.fvo.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.fvu.aJT = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.fvu.rect = rect;
            this.fvu.fvY = bundle;
            view.setVisibility(4);
            a(this.fvu);
            this.fvo.setDragObject(this.fvu);
            this.fvp.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.fvs) {
            this.fvs = false;
            this.fvu = null;
            this.fvq.bia();
            this.fvq.bib();
            this.fvo.bid();
            this.fvo.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.eZF = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.fvs;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.fvs) {
            if (this.fvv == null) {
                this.fvv = new Rect();
                this.fvo.getDrawingRect(this.fvv);
                Rect rect = this.fvv;
                rect.top = (int) (rect.top - this.fvt);
                Rect rect2 = this.fvv;
                rect2.bottom = (int) (rect2.bottom + this.fvt);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.eZF = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.eZF = x;
                    this.fvu.rect.offset((int) (x - this.eZF), 0);
                    a(this.fvu);
                    bhW();
                    break;
            }
            return true;
        }
        return false;
    }

    public void bhW() {
        this.mTempRect.set(this.fvu.rect);
        this.fvo.offsetRectIntoDescendantCoords((View) this.fvq, this.mTempRect);
        this.fvq.e(this.mTempRect);
        this.fvo.invalidate();
        if (this.fvu.fvZ) {
            this.fvq.bhY();
        } else if (this.fvu.fwa) {
            this.fvq.bhZ();
        } else {
            this.fvq.bia();
        }
    }

    private void a(e eVar) {
        eVar.fvZ = false;
        eVar.fwa = false;
        Rect rect = eVar.rect;
        int width = rect.width();
        int width2 = (this.fvo.getWidth() - this.fvw) - this.fvx;
        if (rect.left < this.fvw) {
            rect.left = this.fvw;
            rect.right = rect.left + width;
        }
        if (rect.right > this.fvw + width2) {
            rect.right = this.fvw + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.fvw + this.fvt) {
            eVar.fvZ = true;
            eVar.fwa = false;
        }
        if (rect.right > (this.fvw + width2) - this.fvt) {
            eVar.fvZ = false;
            eVar.fwa = true;
        }
    }

    public void a(g gVar) {
        this.fvq = gVar;
    }

    public void a(f fVar) {
        this.fvr = fVar;
        this.fvr.setDragController(this);
    }
}
