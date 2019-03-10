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
    public float aGZ;
    private Vibrator aUr;
    private DragLayer iHL;
    private d iHM;
    private c iHN;
    public boolean iHO;
    private float iHP;
    private b iHQ;
    private Rect iHR;
    private int iHS;
    private int iHT;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.aUr = (Vibrator) context.getSystemService("vibrator");
        this.iHP = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.iHL = dragLayer;
        dragLayer.setDragController(this);
        this.iHS = this.iHL.getPaddingLeft();
        this.iHT = this.iHL.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.iHL != null && view != null && view.getDrawingCache() != null) {
            this.iHO = true;
            this.iHQ = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.iHL.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.iHQ.cuX = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.iHQ.rect = rect;
            this.iHQ.iIt = bundle;
            view.setVisibility(4);
            a(this.iHQ);
            this.iHL.setDragObject(this.iHQ);
            this.aUr.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.iHO) {
            this.iHO = false;
            this.iHQ = null;
            this.iHM.ceP();
            this.iHM.ceQ();
            this.iHL.ceS();
            this.iHL.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.aGZ = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.iHO;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.iHO) {
            if (this.iHR == null) {
                this.iHR = new Rect();
                this.iHL.getDrawingRect(this.iHR);
                Rect rect = this.iHR;
                rect.top = (int) (rect.top - this.iHP);
                Rect rect2 = this.iHR;
                rect2.bottom = (int) (rect2.bottom + this.iHP);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.aGZ = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.aGZ = x;
                    this.iHQ.rect.offset((int) (x - this.aGZ), 0);
                    a(this.iHQ);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.iHQ.rect);
        this.iHL.offsetRectIntoDescendantCoords((View) this.iHM, this.mTempRect);
        this.iHM.n(this.mTempRect);
        this.iHL.invalidate();
        if (this.iHQ.iIu) {
            this.iHM.ceN();
        } else if (this.iHQ.iIv) {
            this.iHM.ceO();
        } else {
            this.iHM.ceP();
        }
    }

    private void a(b bVar) {
        bVar.iIu = false;
        bVar.iIv = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.iHL.getWidth() - this.iHS) - this.iHT;
        if (rect.left < this.iHS) {
            rect.left = this.iHS;
            rect.right = rect.left + width;
        }
        if (rect.right > this.iHS + width2) {
            rect.right = this.iHS + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.iHS + this.iHP) {
            bVar.iIu = true;
            bVar.iIv = false;
        }
        if (rect.right > (this.iHS + width2) - this.iHP) {
            bVar.iIu = false;
            bVar.iIv = true;
        }
    }

    public void a(d dVar) {
        this.iHM = dVar;
    }

    public void a(c cVar) {
        this.iHN = cVar;
        this.iHN.setDragController(this);
    }
}
