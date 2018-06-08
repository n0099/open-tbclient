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
    public float aZV;
    private Vibrator cUi;
    private DragLayer gKq;
    private d gKr;
    private c gKs;
    public boolean gKt;
    private float gKu;
    private b gKv;
    private Rect gKw;
    private int gKx;
    private int gKy;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.cUi = (Vibrator) context.getSystemService("vibrator");
        this.gKu = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.gKq = dragLayer;
        dragLayer.setDragController(this);
        this.gKx = this.gKq.getPaddingLeft();
        this.gKy = this.gKq.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.gKq != null && view != null && view.getDrawingCache() != null) {
            this.gKt = true;
            this.gKv = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.gKq.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.gKv.aWN = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.gKv.rect = rect;
            this.gKv.gKZ = bundle;
            view.setVisibility(4);
            a(this.gKv);
            this.gKq.setDragObject(this.gKv);
            this.cUi.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.gKt) {
            this.gKt = false;
            this.gKv = null;
            this.gKr.bxy();
            this.gKr.bxz();
            this.gKq.bxB();
            this.gKq.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.aZV = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.gKt;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gKt) {
            if (this.gKw == null) {
                this.gKw = new Rect();
                this.gKq.getDrawingRect(this.gKw);
                Rect rect = this.gKw;
                rect.top = (int) (rect.top - this.gKu);
                Rect rect2 = this.gKw;
                rect2.bottom = (int) (rect2.bottom + this.gKu);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.aZV = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.aZV = x;
                    this.gKv.rect.offset((int) (x - this.aZV), 0);
                    a(this.gKv);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.gKv.rect);
        this.gKq.offsetRectIntoDescendantCoords((View) this.gKr, this.mTempRect);
        this.gKr.k(this.mTempRect);
        this.gKq.invalidate();
        if (this.gKv.gLa) {
            this.gKr.bxw();
        } else if (this.gKv.gLb) {
            this.gKr.bxx();
        } else {
            this.gKr.bxy();
        }
    }

    private void a(b bVar) {
        bVar.gLa = false;
        bVar.gLb = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.gKq.getWidth() - this.gKx) - this.gKy;
        if (rect.left < this.gKx) {
            rect.left = this.gKx;
            rect.right = rect.left + width;
        }
        if (rect.right > this.gKx + width2) {
            rect.right = this.gKx + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.gKx + this.gKu) {
            bVar.gLa = true;
            bVar.gLb = false;
        }
        if (rect.right > (this.gKx + width2) - this.gKu) {
            bVar.gLa = false;
            bVar.gLb = true;
        }
    }

    public void a(d dVar) {
        this.gKr = dVar;
    }

    public void a(c cVar) {
        this.gKs = cVar;
        this.gKs.setDragController(this);
    }
}
