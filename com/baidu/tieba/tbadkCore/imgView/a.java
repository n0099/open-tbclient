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
public class a {
    public float Mq;
    private Rect bZA;
    private int bZB;
    private int bZC;
    private DragLayer bZt;
    private Vibrator bZu;
    private g bZv;
    private f bZw;
    public boolean bZx;
    private float bZy;
    private e bZz;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.bZu = (Vibrator) context.getSystemService("vibrator");
        this.bZy = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.bZt = dragLayer;
        dragLayer.setDragController(this);
        this.bZB = this.bZt.getPaddingLeft();
        this.bZC = this.bZt.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        this.bZx = true;
        this.bZz = new e(this.mContext);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.bZt.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.bZz.aiR = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        this.bZz.XX = rect;
        this.bZz.cag = bundle;
        view.setVisibility(4);
        a(this.bZz);
        this.bZt.setDragObject(this.bZz);
        this.bZu.vibrate(300L);
    }

    public void endDrag() {
        if (this.bZx) {
            this.bZx = false;
            this.bZz = null;
            this.bZv.ahP();
            this.bZv.ahQ();
            this.bZt.ahS();
            this.bZt.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.Mq = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.bZx;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bZx) {
            if (this.bZA == null) {
                this.bZA = new Rect();
                this.bZt.getDrawingRect(this.bZA);
                Rect rect = this.bZA;
                rect.top = (int) (rect.top - this.bZy);
                Rect rect2 = this.bZA;
                rect2.bottom = (int) (rect2.bottom + this.bZy);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.Mq = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.Mq = x;
                    this.bZz.XX.offset((int) (x - this.Mq), 0);
                    a(this.bZz);
                    ahL();
                    break;
            }
            return true;
        }
        return false;
    }

    public void ahL() {
        this.mTempRect.set(this.bZz.XX);
        this.bZt.offsetRectIntoDescendantCoords((View) this.bZv, this.mTempRect);
        this.bZv.d(this.mTempRect);
        this.bZt.invalidate();
        if (this.bZz.cah) {
            this.bZv.ahN();
        } else if (this.bZz.cai) {
            this.bZv.ahO();
        } else {
            this.bZv.ahP();
        }
    }

    private void a(e eVar) {
        eVar.cah = false;
        eVar.cai = false;
        Rect rect = eVar.XX;
        int width = rect.width();
        int width2 = (this.bZt.getWidth() - this.bZB) - this.bZC;
        if (rect.left < this.bZB) {
            rect.left = this.bZB;
            rect.right = rect.left + width;
        }
        if (rect.right > this.bZB + width2) {
            rect.right = this.bZB + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.bZB + this.bZy) {
            eVar.cah = true;
            eVar.cai = false;
        }
        if (rect.right > (this.bZB + width2) - this.bZy) {
            eVar.cah = false;
            eVar.cai = true;
        }
    }

    public void a(g gVar) {
        this.bZv = gVar;
    }

    public void a(f fVar) {
        this.bZw = fVar;
        this.bZw.setDragController(this);
    }
}
