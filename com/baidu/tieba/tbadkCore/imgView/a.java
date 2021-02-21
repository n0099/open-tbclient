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
    private Vibrator dNn;
    public float dwp;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private DragLayer nyK;
    private d nyL;
    private c nyM;
    public boolean nyN;
    private float nyO;
    private b nyP;
    private Rect nyQ;
    private int nyR;
    private int nyS;

    public a(Context context) {
        this.mContext = context;
        this.dNn = (Vibrator) context.getSystemService("vibrator");
        this.nyO = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.nyK = dragLayer;
        dragLayer.setDragController(this);
        this.nyR = this.nyK.getPaddingLeft();
        this.nyS = this.nyK.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.nyK != null && view != null && view.getDrawingCache() != null) {
            this.nyN = true;
            this.nyP = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.nyK.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.nyP.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.nyP.rect = rect;
            this.nyP.nzr = bundle;
            view.setVisibility(4);
            a(this.nyP);
            this.nyK.setDragObject(this.nyP);
            this.dNn.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.nyN) {
            this.nyN = false;
            this.nyP = null;
            this.nyL.dOd();
            this.nyL.dOe();
            this.nyK.dOg();
            this.nyK.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.dwp = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.nyN;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nyN) {
            if (this.nyQ == null) {
                this.nyQ = new Rect();
                this.nyK.getDrawingRect(this.nyQ);
                Rect rect = this.nyQ;
                rect.top = (int) (rect.top - this.nyO);
                Rect rect2 = this.nyQ;
                rect2.bottom = (int) (rect2.bottom + this.nyO);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.dwp = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.dwp = x;
                    this.nyP.rect.offset((int) (x - this.dwp), 0);
                    a(this.nyP);
                    dNZ();
                    break;
            }
            return true;
        }
        return false;
    }

    public void dNZ() {
        this.mTempRect.set(this.nyP.rect);
        this.nyK.offsetRectIntoDescendantCoords((View) this.nyL, this.mTempRect);
        this.nyL.i(this.mTempRect);
        this.nyK.invalidate();
        if (this.nyP.nzs) {
            this.nyL.dOb();
        } else if (this.nyP.nzt) {
            this.nyL.dOc();
        } else {
            this.nyL.dOd();
        }
    }

    private void a(b bVar) {
        bVar.nzs = false;
        bVar.nzt = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.nyK.getWidth() - this.nyR) - this.nyS;
        if (rect.left < this.nyR) {
            rect.left = this.nyR;
            rect.right = rect.left + width;
        }
        if (rect.right > this.nyR + width2) {
            rect.right = this.nyR + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.nyR + this.nyO) {
            bVar.nzs = true;
            bVar.nzt = false;
        }
        if (rect.right > (this.nyR + width2) - this.nyO) {
            bVar.nzs = false;
            bVar.nzt = true;
        }
    }

    public void a(d dVar) {
        this.nyL = dVar;
    }

    public void a(c cVar) {
        this.nyM = cVar;
        this.nyM.setDragController(this);
    }
}
