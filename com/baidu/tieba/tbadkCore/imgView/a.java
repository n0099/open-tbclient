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
    private DragLayer iHK;
    private d iHL;
    private c iHM;
    public boolean iHN;
    private float iHO;
    private b iHP;
    private Rect iHQ;
    private int iHR;
    private int iHS;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.aUr = (Vibrator) context.getSystemService("vibrator");
        this.iHO = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.iHK = dragLayer;
        dragLayer.setDragController(this);
        this.iHR = this.iHK.getPaddingLeft();
        this.iHS = this.iHK.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.iHK != null && view != null && view.getDrawingCache() != null) {
            this.iHN = true;
            this.iHP = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.iHK.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.iHP.cuX = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.iHP.rect = rect;
            this.iHP.iIs = bundle;
            view.setVisibility(4);
            a(this.iHP);
            this.iHK.setDragObject(this.iHP);
            this.aUr.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.iHN) {
            this.iHN = false;
            this.iHP = null;
            this.iHL.ceO();
            this.iHL.ceP();
            this.iHK.ceR();
            this.iHK.invalidate();
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
        return this.iHN;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.iHN) {
            if (this.iHQ == null) {
                this.iHQ = new Rect();
                this.iHK.getDrawingRect(this.iHQ);
                Rect rect = this.iHQ;
                rect.top = (int) (rect.top - this.iHO);
                Rect rect2 = this.iHQ;
                rect2.bottom = (int) (rect2.bottom + this.iHO);
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
                    this.iHP.rect.offset((int) (x - this.aGZ), 0);
                    a(this.iHP);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.iHP.rect);
        this.iHK.offsetRectIntoDescendantCoords((View) this.iHL, this.mTempRect);
        this.iHL.n(this.mTempRect);
        this.iHK.invalidate();
        if (this.iHP.iIt) {
            this.iHL.ceM();
        } else if (this.iHP.iIu) {
            this.iHL.ceN();
        } else {
            this.iHL.ceO();
        }
    }

    private void a(b bVar) {
        bVar.iIt = false;
        bVar.iIu = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.iHK.getWidth() - this.iHR) - this.iHS;
        if (rect.left < this.iHR) {
            rect.left = this.iHR;
            rect.right = rect.left + width;
        }
        if (rect.right > this.iHR + width2) {
            rect.right = this.iHR + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.iHR + this.iHO) {
            bVar.iIt = true;
            bVar.iIu = false;
        }
        if (rect.right > (this.iHR + width2) - this.iHO) {
            bVar.iIt = false;
            bVar.iIu = true;
        }
    }

    public void a(d dVar) {
        this.iHL = dVar;
    }

    public void a(c cVar) {
        this.iHM = cVar;
        this.iHM.setDragController(this);
    }
}
