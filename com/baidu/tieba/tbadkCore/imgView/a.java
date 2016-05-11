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
    public float bFU;
    private DragLayer etZ;
    private Vibrator eua;
    private f eub;
    private e euc;
    public boolean eud;
    private float eue;
    private d euf;
    private Rect eug;
    private int euh;
    private int eui;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.eua = (Vibrator) context.getSystemService("vibrator");
        this.eue = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.etZ = dragLayer;
        dragLayer.setDragController(this);
        this.euh = this.etZ.getPaddingLeft();
        this.eui = this.etZ.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.etZ != null && view != null && view.getDrawingCache() != null) {
            this.eud = true;
            this.euf = new d(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.etZ.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.euf.aBB = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.euf.rect = rect;
            this.euf.euJ = bundle;
            view.setVisibility(4);
            a(this.euf);
            this.etZ.setDragObject(this.euf);
            this.eua.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.eud) {
            this.eud = false;
            this.euf = null;
            this.eub.aUu();
            this.eub.aUv();
            this.etZ.aUx();
            this.etZ.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.bFU = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.eud;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.eud) {
            if (this.eug == null) {
                this.eug = new Rect();
                this.etZ.getDrawingRect(this.eug);
                Rect rect = this.eug;
                rect.top = (int) (rect.top - this.eue);
                Rect rect2 = this.eug;
                rect2.bottom = (int) (rect2.bottom + this.eue);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.bFU = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.bFU = x;
                    this.euf.rect.offset((int) (x - this.bFU), 0);
                    a(this.euf);
                    aUq();
                    break;
            }
            return true;
        }
        return false;
    }

    public void aUq() {
        this.mTempRect.set(this.euf.rect);
        this.etZ.offsetRectIntoDescendantCoords((View) this.eub, this.mTempRect);
        this.eub.d(this.mTempRect);
        this.etZ.invalidate();
        if (this.euf.euK) {
            this.eub.aUs();
        } else if (this.euf.euL) {
            this.eub.aUt();
        } else {
            this.eub.aUu();
        }
    }

    private void a(d dVar) {
        dVar.euK = false;
        dVar.euL = false;
        Rect rect = dVar.rect;
        int width = rect.width();
        int width2 = (this.etZ.getWidth() - this.euh) - this.eui;
        if (rect.left < this.euh) {
            rect.left = this.euh;
            rect.right = rect.left + width;
        }
        if (rect.right > this.euh + width2) {
            rect.right = this.euh + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.euh + this.eue) {
            dVar.euK = true;
            dVar.euL = false;
        }
        if (rect.right > (this.euh + width2) - this.eue) {
            dVar.euK = false;
            dVar.euL = true;
        }
    }

    public void a(f fVar) {
        this.eub = fVar;
    }

    public void a(e eVar) {
        this.euc = eVar;
        this.euc.setDragController(this);
    }
}
