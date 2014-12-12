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
    private DragLayer bXB;
    private Vibrator bXC;
    private g bXD;
    private f bXE;
    public boolean bXF;
    private float bXG;
    private e bXH;
    private Rect bXI;
    private int bXJ;
    private int bXK;
    private Context mContext;
    public float mStartX;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.bXC = (Vibrator) context.getSystemService("vibrator");
        this.bXG = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.bXB = dragLayer;
        dragLayer.setDragController(this);
        this.bXJ = this.bXB.getPaddingLeft();
        this.bXK = this.bXB.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        this.bXF = true;
        this.bXH = new e(this.mContext);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.bXB.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.bXH.air = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        this.bXH.Xu = rect;
        this.bXH.bYo = bundle;
        view.setVisibility(4);
        a(this.bXH);
        this.bXB.setDragObject(this.bXH);
        this.bXC.vibrate(300L);
    }

    public void endDrag() {
        if (this.bXF) {
            this.bXF = false;
            this.bXH = null;
            this.bXD.ahq();
            this.bXD.ahr();
            this.bXB.aht();
            this.bXB.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.mStartX = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.bXF;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bXF) {
            if (this.bXI == null) {
                this.bXI = new Rect();
                this.bXB.getDrawingRect(this.bXI);
                Rect rect = this.bXI;
                rect.top = (int) (rect.top - this.bXG);
                Rect rect2 = this.bXI;
                rect2.bottom = (int) (rect2.bottom + this.bXG);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.mStartX = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.mStartX = x;
                    this.bXH.Xu.offset((int) (x - this.mStartX), 0);
                    a(this.bXH);
                    ahm();
                    break;
            }
            return true;
        }
        return false;
    }

    public void ahm() {
        this.mTempRect.set(this.bXH.Xu);
        this.bXB.offsetRectIntoDescendantCoords((View) this.bXD, this.mTempRect);
        this.bXD.d(this.mTempRect);
        this.bXB.invalidate();
        if (this.bXH.bYp) {
            this.bXD.aho();
        } else if (this.bXH.bYq) {
            this.bXD.ahp();
        } else {
            this.bXD.ahq();
        }
    }

    private void a(e eVar) {
        eVar.bYp = false;
        eVar.bYq = false;
        Rect rect = eVar.Xu;
        int width = rect.width();
        int width2 = (this.bXB.getWidth() - this.bXJ) - this.bXK;
        if (rect.left < this.bXJ) {
            rect.left = this.bXJ;
            rect.right = rect.left + width;
        }
        if (rect.right > this.bXJ + width2) {
            rect.right = this.bXJ + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.bXJ + this.bXG) {
            eVar.bYp = true;
            eVar.bYq = false;
        }
        if (rect.right > (this.bXJ + width2) - this.bXG) {
            eVar.bYp = false;
            eVar.bYq = true;
        }
    }

    public void a(g gVar) {
        this.bXD = gVar;
    }

    public void a(f fVar) {
        this.bXE = fVar;
        this.bXE.setDragController(this);
    }
}
