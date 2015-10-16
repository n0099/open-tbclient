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
    public float ble;
    private DragLayer cZV;
    private Vibrator cZW;
    private f cZX;
    private e cZY;
    public boolean cZZ;
    private float daa;
    private d dab;
    private Rect dac;
    private int dad;
    private int dae;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.cZW = (Vibrator) context.getSystemService("vibrator");
        this.daa = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.cZV = dragLayer;
        dragLayer.setDragController(this);
        this.dad = this.cZV.getPaddingLeft();
        this.dae = this.cZV.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        this.cZZ = true;
        this.dab = new d(this.mContext);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.cZV.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.dab.aAK = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        this.dab.apD = rect;
        this.dab.daJ = bundle;
        view.setVisibility(4);
        a(this.dab);
        this.cZV.setDragObject(this.dab);
        this.cZW.vibrate(300L);
    }

    public void endDrag() {
        if (this.cZZ) {
            this.cZZ = false;
            this.dab = null;
            this.cZX.axe();
            this.cZX.axf();
            this.cZV.axh();
            this.cZV.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.ble = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.cZZ;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cZZ) {
            if (this.dac == null) {
                this.dac = new Rect();
                this.cZV.getDrawingRect(this.dac);
                Rect rect = this.dac;
                rect.top = (int) (rect.top - this.daa);
                Rect rect2 = this.dac;
                rect2.bottom = (int) (rect2.bottom + this.daa);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.ble = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.ble = x;
                    this.dab.apD.offset((int) (x - this.ble), 0);
                    a(this.dab);
                    axa();
                    break;
            }
            return true;
        }
        return false;
    }

    public void axa() {
        this.mTempRect.set(this.dab.apD);
        this.cZV.offsetRectIntoDescendantCoords((View) this.cZX, this.mTempRect);
        this.cZX.d(this.mTempRect);
        this.cZV.invalidate();
        if (this.dab.daK) {
            this.cZX.axc();
        } else if (this.dab.daL) {
            this.cZX.axd();
        } else {
            this.cZX.axe();
        }
    }

    private void a(d dVar) {
        dVar.daK = false;
        dVar.daL = false;
        Rect rect = dVar.apD;
        int width = rect.width();
        int width2 = (this.cZV.getWidth() - this.dad) - this.dae;
        if (rect.left < this.dad) {
            rect.left = this.dad;
            rect.right = rect.left + width;
        }
        if (rect.right > this.dad + width2) {
            rect.right = this.dad + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.dad + this.daa) {
            dVar.daK = true;
            dVar.daL = false;
        }
        if (rect.right > (this.dad + width2) - this.daa) {
            dVar.daK = false;
            dVar.daL = true;
        }
    }

    public void a(f fVar) {
        this.cZX = fVar;
    }

    public void a(e eVar) {
        this.cZY = eVar;
        this.cZY.setDragController(this);
    }
}
