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
    public float Ym;
    private DragLayer csO;
    private Vibrator csP;
    private g csQ;
    private f csR;
    public boolean csS;
    private float csT;
    private e csU;
    private Rect csV;
    private int csW;
    private int csX;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.csP = (Vibrator) context.getSystemService("vibrator");
        this.csT = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.csO = dragLayer;
        dragLayer.setDragController(this);
        this.csW = this.csO.getPaddingLeft();
        this.csX = this.csO.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        this.csS = true;
        this.csU = new e(this.mContext);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.csO.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.csU.ate = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        this.csU.aji = rect;
        this.csU.ctA = bundle;
        view.setVisibility(4);
        a(this.csU);
        this.csO.setDragObject(this.csU);
        this.csP.vibrate(300L);
    }

    public void endDrag() {
        if (this.csS) {
            this.csS = false;
            this.csU = null;
            this.csQ.aoW();
            this.csQ.aoX();
            this.csO.aoZ();
            this.csO.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.Ym = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.csS;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.csS) {
            if (this.csV == null) {
                this.csV = new Rect();
                this.csO.getDrawingRect(this.csV);
                Rect rect = this.csV;
                rect.top = (int) (rect.top - this.csT);
                Rect rect2 = this.csV;
                rect2.bottom = (int) (rect2.bottom + this.csT);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.Ym = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.Ym = x;
                    this.csU.aji.offset((int) (x - this.Ym), 0);
                    a(this.csU);
                    aoS();
                    break;
            }
            return true;
        }
        return false;
    }

    public void aoS() {
        this.mTempRect.set(this.csU.aji);
        this.csO.offsetRectIntoDescendantCoords((View) this.csQ, this.mTempRect);
        this.csQ.d(this.mTempRect);
        this.csO.invalidate();
        if (this.csU.ctB) {
            this.csQ.aoU();
        } else if (this.csU.ctC) {
            this.csQ.aoV();
        } else {
            this.csQ.aoW();
        }
    }

    private void a(e eVar) {
        eVar.ctB = false;
        eVar.ctC = false;
        Rect rect = eVar.aji;
        int width = rect.width();
        int width2 = (this.csO.getWidth() - this.csW) - this.csX;
        if (rect.left < this.csW) {
            rect.left = this.csW;
            rect.right = rect.left + width;
        }
        if (rect.right > this.csW + width2) {
            rect.right = this.csW + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.csW + this.csT) {
            eVar.ctB = true;
            eVar.ctC = false;
        }
        if (rect.right > (this.csW + width2) - this.csT) {
            eVar.ctB = false;
            eVar.ctC = true;
        }
    }

    public void a(g gVar) {
        this.csQ = gVar;
    }

    public void a(f fVar) {
        this.csR = fVar;
        this.csR.setDragController(this);
    }
}
