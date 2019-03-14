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
    public float aHa;
    private Vibrator aUs;
    private DragLayer iHD;
    private d iHE;
    private c iHF;
    public boolean iHG;
    private float iHH;
    private b iHI;
    private Rect iHJ;
    private int iHK;
    private int iHL;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.aUs = (Vibrator) context.getSystemService("vibrator");
        this.iHH = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.iHD = dragLayer;
        dragLayer.setDragController(this);
        this.iHK = this.iHD.getPaddingLeft();
        this.iHL = this.iHD.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.iHD != null && view != null && view.getDrawingCache() != null) {
            this.iHG = true;
            this.iHI = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.iHD.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.iHI.cuU = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.iHI.rect = rect;
            this.iHI.iIl = bundle;
            view.setVisibility(4);
            a(this.iHI);
            this.iHD.setDragObject(this.iHI);
            this.aUs.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.iHG) {
            this.iHG = false;
            this.iHI = null;
            this.iHE.ceR();
            this.iHE.ceS();
            this.iHD.ceU();
            this.iHD.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.aHa = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.iHG;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.iHG) {
            if (this.iHJ == null) {
                this.iHJ = new Rect();
                this.iHD.getDrawingRect(this.iHJ);
                Rect rect = this.iHJ;
                rect.top = (int) (rect.top - this.iHH);
                Rect rect2 = this.iHJ;
                rect2.bottom = (int) (rect2.bottom + this.iHH);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.aHa = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.aHa = x;
                    this.iHI.rect.offset((int) (x - this.aHa), 0);
                    a(this.iHI);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.iHI.rect);
        this.iHD.offsetRectIntoDescendantCoords((View) this.iHE, this.mTempRect);
        this.iHE.n(this.mTempRect);
        this.iHD.invalidate();
        if (this.iHI.iIm) {
            this.iHE.ceP();
        } else if (this.iHI.iIn) {
            this.iHE.ceQ();
        } else {
            this.iHE.ceR();
        }
    }

    private void a(b bVar) {
        bVar.iIm = false;
        bVar.iIn = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.iHD.getWidth() - this.iHK) - this.iHL;
        if (rect.left < this.iHK) {
            rect.left = this.iHK;
            rect.right = rect.left + width;
        }
        if (rect.right > this.iHK + width2) {
            rect.right = this.iHK + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.iHK + this.iHH) {
            bVar.iIm = true;
            bVar.iIn = false;
        }
        if (rect.right > (this.iHK + width2) - this.iHH) {
            bVar.iIm = false;
            bVar.iIn = true;
        }
    }

    public void a(d dVar) {
        this.iHE = dVar;
    }

    public void a(c cVar) {
        this.iHF = cVar;
        this.iHF.setDragController(this);
    }
}
