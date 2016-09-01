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
    public float cqK;
    private DragLayer ftM;
    private Vibrator ftN;
    private f ftO;
    private e ftP;
    public boolean ftQ;
    private float ftR;
    private d ftS;
    private Rect ftT;
    private int ftU;
    private int ftV;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.ftN = (Vibrator) context.getSystemService("vibrator");
        this.ftR = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.ftM = dragLayer;
        dragLayer.setDragController(this);
        this.ftU = this.ftM.getPaddingLeft();
        this.ftV = this.ftM.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.ftM != null && view != null && view.getDrawingCache() != null) {
            this.ftQ = true;
            this.ftS = new d(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.ftM.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.ftS.aFY = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.ftS.rect = rect;
            this.ftS.fuw = bundle;
            view.setVisibility(4);
            a(this.ftS);
            this.ftM.setDragObject(this.ftS);
            this.ftN.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.ftQ) {
            this.ftQ = false;
            this.ftS = null;
            this.ftO.bjE();
            this.ftO.bjF();
            this.ftM.bjH();
            this.ftM.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.cqK = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.ftQ;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ftQ) {
            if (this.ftT == null) {
                this.ftT = new Rect();
                this.ftM.getDrawingRect(this.ftT);
                Rect rect = this.ftT;
                rect.top = (int) (rect.top - this.ftR);
                Rect rect2 = this.ftT;
                rect2.bottom = (int) (rect2.bottom + this.ftR);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.cqK = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.cqK = x;
                    this.ftS.rect.offset((int) (x - this.cqK), 0);
                    a(this.ftS);
                    bjA();
                    break;
            }
            return true;
        }
        return false;
    }

    public void bjA() {
        this.mTempRect.set(this.ftS.rect);
        this.ftM.offsetRectIntoDescendantCoords((View) this.ftO, this.mTempRect);
        this.ftO.d(this.mTempRect);
        this.ftM.invalidate();
        if (this.ftS.fux) {
            this.ftO.bjC();
        } else if (this.ftS.fuy) {
            this.ftO.bjD();
        } else {
            this.ftO.bjE();
        }
    }

    private void a(d dVar) {
        dVar.fux = false;
        dVar.fuy = false;
        Rect rect = dVar.rect;
        int width = rect.width();
        int width2 = (this.ftM.getWidth() - this.ftU) - this.ftV;
        if (rect.left < this.ftU) {
            rect.left = this.ftU;
            rect.right = rect.left + width;
        }
        if (rect.right > this.ftU + width2) {
            rect.right = this.ftU + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.ftU + this.ftR) {
            dVar.fux = true;
            dVar.fuy = false;
        }
        if (rect.right > (this.ftU + width2) - this.ftR) {
            dVar.fux = false;
            dVar.fuy = true;
        }
    }

    public void a(f fVar) {
        this.ftO = fVar;
    }

    public void a(e eVar) {
        this.ftP = eVar;
        this.ftP.setDragController(this);
    }
}
