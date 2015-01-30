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
    public float Mt;
    private e bZA;
    private Rect bZB;
    private int bZC;
    private int bZD;
    private DragLayer bZu;
    private Vibrator bZv;
    private g bZw;
    private f bZx;
    public boolean bZy;
    private float bZz;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.bZv = (Vibrator) context.getSystemService("vibrator");
        this.bZz = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.bZu = dragLayer;
        dragLayer.setDragController(this);
        this.bZC = this.bZu.getPaddingLeft();
        this.bZD = this.bZu.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        this.bZy = true;
        this.bZA = new e(this.mContext);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.bZu.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.bZA.aiU = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        this.bZA.Ya = rect;
        this.bZA.cah = bundle;
        view.setVisibility(4);
        a(this.bZA);
        this.bZu.setDragObject(this.bZA);
        this.bZv.vibrate(300L);
    }

    public void endDrag() {
        if (this.bZy) {
            this.bZy = false;
            this.bZA = null;
            this.bZw.ahU();
            this.bZw.ahV();
            this.bZu.ahX();
            this.bZu.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.Mt = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.bZy;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bZy) {
            if (this.bZB == null) {
                this.bZB = new Rect();
                this.bZu.getDrawingRect(this.bZB);
                Rect rect = this.bZB;
                rect.top = (int) (rect.top - this.bZz);
                Rect rect2 = this.bZB;
                rect2.bottom = (int) (rect2.bottom + this.bZz);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.Mt = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.Mt = x;
                    this.bZA.Ya.offset((int) (x - this.Mt), 0);
                    a(this.bZA);
                    ahQ();
                    break;
            }
            return true;
        }
        return false;
    }

    public void ahQ() {
        this.mTempRect.set(this.bZA.Ya);
        this.bZu.offsetRectIntoDescendantCoords((View) this.bZw, this.mTempRect);
        this.bZw.d(this.mTempRect);
        this.bZu.invalidate();
        if (this.bZA.cai) {
            this.bZw.ahS();
        } else if (this.bZA.caj) {
            this.bZw.ahT();
        } else {
            this.bZw.ahU();
        }
    }

    private void a(e eVar) {
        eVar.cai = false;
        eVar.caj = false;
        Rect rect = eVar.Ya;
        int width = rect.width();
        int width2 = (this.bZu.getWidth() - this.bZC) - this.bZD;
        if (rect.left < this.bZC) {
            rect.left = this.bZC;
            rect.right = rect.left + width;
        }
        if (rect.right > this.bZC + width2) {
            rect.right = this.bZC + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.bZC + this.bZz) {
            eVar.cai = true;
            eVar.caj = false;
        }
        if (rect.right > (this.bZC + width2) - this.bZz) {
            eVar.cai = false;
            eVar.caj = true;
        }
    }

    public void a(g gVar) {
        this.bZw = gVar;
    }

    public void a(f fVar) {
        this.bZx = fVar;
        this.bZx.setDragController(this);
    }
}
