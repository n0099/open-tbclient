package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a {
    public float aJF;
    private Vibrator aYc;
    private DragLayer jhM;
    private d jhN;
    private c jhO;
    public boolean jhP;
    private float jhQ;
    private b jhR;
    private Rect jhS;
    private int jhT;
    private int jhU;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.aYc = (Vibrator) context.getSystemService("vibrator");
        this.jhQ = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.jhM = dragLayer;
        dragLayer.setDragController(this);
        this.jhT = this.jhM.getPaddingLeft();
        this.jhU = this.jhM.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.jhM != null && view != null && view.getDrawingCache() != null) {
            this.jhP = true;
            this.jhR = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.jhM.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.jhR.cEF = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.jhR.cxj = rect;
            this.jhR.jiv = bundle;
            view.setVisibility(4);
            a(this.jhR);
            this.jhM.setDragObject(this.jhR);
            this.aYc.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.jhP) {
            this.jhP = false;
            this.jhR = null;
            this.jhN.cqk();
            this.jhN.cql();
            this.jhM.cqn();
            this.jhM.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.aJF = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.jhP;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jhP) {
            if (this.jhS == null) {
                this.jhS = new Rect();
                this.jhM.getDrawingRect(this.jhS);
                Rect rect = this.jhS;
                rect.top = (int) (rect.top - this.jhQ);
                Rect rect2 = this.jhS;
                rect2.bottom = (int) (rect2.bottom + this.jhQ);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.aJF = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.aJF = x;
                    this.jhR.cxj.offset((int) (x - this.aJF), 0);
                    a(this.jhR);
                    cqg();
                    break;
            }
            return true;
        }
        return false;
    }

    public void cqg() {
        this.mTempRect.set(this.jhR.cxj);
        this.jhM.offsetRectIntoDescendantCoords((View) this.jhN, this.mTempRect);
        this.jhN.p(this.mTempRect);
        this.jhM.invalidate();
        if (this.jhR.jiw) {
            this.jhN.cqi();
        } else if (this.jhR.jix) {
            this.jhN.cqj();
        } else {
            this.jhN.cqk();
        }
    }

    private void a(b bVar) {
        bVar.jiw = false;
        bVar.jix = false;
        Rect rect = bVar.cxj;
        int width = rect.width();
        int width2 = (this.jhM.getWidth() - this.jhT) - this.jhU;
        if (rect.left < this.jhT) {
            rect.left = this.jhT;
            rect.right = rect.left + width;
        }
        if (rect.right > this.jhT + width2) {
            rect.right = this.jhT + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.jhT + this.jhQ) {
            bVar.jiw = true;
            bVar.jix = false;
        }
        if (rect.right > (this.jhT + width2) - this.jhQ) {
            bVar.jiw = false;
            bVar.jix = true;
        }
    }

    public void a(d dVar) {
        this.jhN = dVar;
    }

    public void a(c cVar) {
        this.jhO = cVar;
        this.jhO.setDragController(this);
    }
}
