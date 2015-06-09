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
    private DragLayer csP;
    private Vibrator csQ;
    private g csR;
    private f csS;
    public boolean csT;
    private float csU;
    private e csV;
    private Rect csW;
    private int csX;
    private int csY;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.csQ = (Vibrator) context.getSystemService("vibrator");
        this.csU = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.csP = dragLayer;
        dragLayer.setDragController(this);
        this.csX = this.csP.getPaddingLeft();
        this.csY = this.csP.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        this.csT = true;
        this.csV = new e(this.mContext);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.csP.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.csV.ate = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        this.csV.aji = rect;
        this.csV.ctB = bundle;
        view.setVisibility(4);
        a(this.csV);
        this.csP.setDragObject(this.csV);
        this.csQ.vibrate(300L);
    }

    public void endDrag() {
        if (this.csT) {
            this.csT = false;
            this.csV = null;
            this.csR.aoX();
            this.csR.aoY();
            this.csP.apa();
            this.csP.invalidate();
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
        return this.csT;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.csT) {
            if (this.csW == null) {
                this.csW = new Rect();
                this.csP.getDrawingRect(this.csW);
                Rect rect = this.csW;
                rect.top = (int) (rect.top - this.csU);
                Rect rect2 = this.csW;
                rect2.bottom = (int) (rect2.bottom + this.csU);
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
                    this.csV.aji.offset((int) (x - this.Ym), 0);
                    a(this.csV);
                    aoT();
                    break;
            }
            return true;
        }
        return false;
    }

    public void aoT() {
        this.mTempRect.set(this.csV.aji);
        this.csP.offsetRectIntoDescendantCoords((View) this.csR, this.mTempRect);
        this.csR.d(this.mTempRect);
        this.csP.invalidate();
        if (this.csV.ctC) {
            this.csR.aoV();
        } else if (this.csV.ctD) {
            this.csR.aoW();
        } else {
            this.csR.aoX();
        }
    }

    private void a(e eVar) {
        eVar.ctC = false;
        eVar.ctD = false;
        Rect rect = eVar.aji;
        int width = rect.width();
        int width2 = (this.csP.getWidth() - this.csX) - this.csY;
        if (rect.left < this.csX) {
            rect.left = this.csX;
            rect.right = rect.left + width;
        }
        if (rect.right > this.csX + width2) {
            rect.right = this.csX + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.csX + this.csU) {
            eVar.ctC = true;
            eVar.ctD = false;
        }
        if (rect.right > (this.csX + width2) - this.csU) {
            eVar.ctC = false;
            eVar.ctD = true;
        }
    }

    public void a(g gVar) {
        this.csR = gVar;
    }

    public void a(f fVar) {
        this.csS = fVar;
        this.csS.setDragController(this);
    }
}
