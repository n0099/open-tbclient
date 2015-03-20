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
    public float Xx;
    private f coA;
    public boolean coB;
    private float coC;
    private e coD;
    private Rect coE;
    private int coF;
    private int coG;
    private DragLayer cox;
    private Vibrator coy;
    private g coz;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.coy = (Vibrator) context.getSystemService("vibrator");
        this.coC = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.cox = dragLayer;
        dragLayer.setDragController(this);
        this.coF = this.cox.getPaddingLeft();
        this.coG = this.cox.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        this.coB = true;
        this.coD = new e(this.mContext);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.cox.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.coD.art = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        this.coD.aia = rect;
        this.coD.cpj = bundle;
        view.setVisibility(4);
        a(this.coD);
        this.cox.setDragObject(this.coD);
        this.coy.vibrate(300L);
    }

    public void endDrag() {
        if (this.coB) {
            this.coB = false;
            this.coD = null;
            this.coz.amQ();
            this.coz.amR();
            this.cox.amT();
            this.cox.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.Xx = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.coB;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.coB) {
            if (this.coE == null) {
                this.coE = new Rect();
                this.cox.getDrawingRect(this.coE);
                Rect rect = this.coE;
                rect.top = (int) (rect.top - this.coC);
                Rect rect2 = this.coE;
                rect2.bottom = (int) (rect2.bottom + this.coC);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.Xx = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.Xx = x;
                    this.coD.aia.offset((int) (x - this.Xx), 0);
                    a(this.coD);
                    amM();
                    break;
            }
            return true;
        }
        return false;
    }

    public void amM() {
        this.mTempRect.set(this.coD.aia);
        this.cox.offsetRectIntoDescendantCoords((View) this.coz, this.mTempRect);
        this.coz.d(this.mTempRect);
        this.cox.invalidate();
        if (this.coD.cpk) {
            this.coz.amO();
        } else if (this.coD.cpl) {
            this.coz.amP();
        } else {
            this.coz.amQ();
        }
    }

    private void a(e eVar) {
        eVar.cpk = false;
        eVar.cpl = false;
        Rect rect = eVar.aia;
        int width = rect.width();
        int width2 = (this.cox.getWidth() - this.coF) - this.coG;
        if (rect.left < this.coF) {
            rect.left = this.coF;
            rect.right = rect.left + width;
        }
        if (rect.right > this.coF + width2) {
            rect.right = this.coF + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.coF + this.coC) {
            eVar.cpk = true;
            eVar.cpl = false;
        }
        if (rect.right > (this.coF + width2) - this.coC) {
            eVar.cpk = false;
            eVar.cpl = true;
        }
    }

    public void a(g gVar) {
        this.coz = gVar;
    }

    public void a(f fVar) {
        this.coA = fVar;
        this.coA.setDragController(this);
    }
}
