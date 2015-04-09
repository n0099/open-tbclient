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
    public float Xz;
    private DragLayer coN;
    private Vibrator coO;
    private g coP;
    private f coQ;
    public boolean coR;
    private float coS;
    private e coT;
    private Rect coU;
    private int coV;
    private int coW;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.coO = (Vibrator) context.getSystemService("vibrator");
        this.coS = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.coN = dragLayer;
        dragLayer.setDragController(this);
        this.coV = this.coN.getPaddingLeft();
        this.coW = this.coN.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        this.coR = true;
        this.coT = new e(this.mContext);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.coN.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.coT.arB = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        this.coT.aii = rect;
        this.coT.cpz = bundle;
        view.setVisibility(4);
        a(this.coT);
        this.coN.setDragObject(this.coT);
        this.coO.vibrate(300L);
    }

    public void endDrag() {
        if (this.coR) {
            this.coR = false;
            this.coT = null;
            this.coP.anf();
            this.coP.ang();
            this.coN.ani();
            this.coN.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.Xz = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.coR;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.coR) {
            if (this.coU == null) {
                this.coU = new Rect();
                this.coN.getDrawingRect(this.coU);
                Rect rect = this.coU;
                rect.top = (int) (rect.top - this.coS);
                Rect rect2 = this.coU;
                rect2.bottom = (int) (rect2.bottom + this.coS);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.Xz = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.Xz = x;
                    this.coT.aii.offset((int) (x - this.Xz), 0);
                    a(this.coT);
                    anb();
                    break;
            }
            return true;
        }
        return false;
    }

    public void anb() {
        this.mTempRect.set(this.coT.aii);
        this.coN.offsetRectIntoDescendantCoords((View) this.coP, this.mTempRect);
        this.coP.d(this.mTempRect);
        this.coN.invalidate();
        if (this.coT.cpA) {
            this.coP.and();
        } else if (this.coT.cpB) {
            this.coP.ane();
        } else {
            this.coP.anf();
        }
    }

    private void a(e eVar) {
        eVar.cpA = false;
        eVar.cpB = false;
        Rect rect = eVar.aii;
        int width = rect.width();
        int width2 = (this.coN.getWidth() - this.coV) - this.coW;
        if (rect.left < this.coV) {
            rect.left = this.coV;
            rect.right = rect.left + width;
        }
        if (rect.right > this.coV + width2) {
            rect.right = this.coV + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.coV + this.coS) {
            eVar.cpA = true;
            eVar.cpB = false;
        }
        if (rect.right > (this.coV + width2) - this.coS) {
            eVar.cpA = false;
            eVar.cpB = true;
        }
    }

    public void a(g gVar) {
        this.coP = gVar;
    }

    public void a(f fVar) {
        this.coQ = fVar;
        this.coQ.setDragController(this);
    }
}
