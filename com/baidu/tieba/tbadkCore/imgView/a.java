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
    public float aIX;
    private Vibrator aXs;
    private DragLayer jao;
    private d jap;
    private c jaq;
    public boolean jar;
    private float jas;
    private b jat;
    private Rect jau;
    private int jav;
    private int jaw;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.aXs = (Vibrator) context.getSystemService("vibrator");
        this.jas = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.jao = dragLayer;
        dragLayer.setDragController(this);
        this.jav = this.jao.getPaddingLeft();
        this.jaw = this.jao.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.jao != null && view != null && view.getDrawingCache() != null) {
            this.jar = true;
            this.jat = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.jao.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.jat.cDh = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.jat.rect = rect;
            this.jat.jaW = bundle;
            view.setVisibility(4);
            a(this.jat);
            this.jao.setDragObject(this.jat);
            this.aXs.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.jar) {
            this.jar = false;
            this.jat = null;
            this.jap.cmV();
            this.jap.cmW();
            this.jao.cmY();
            this.jao.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.aIX = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.jar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jar) {
            if (this.jau == null) {
                this.jau = new Rect();
                this.jao.getDrawingRect(this.jau);
                Rect rect = this.jau;
                rect.top = (int) (rect.top - this.jas);
                Rect rect2 = this.jau;
                rect2.bottom = (int) (rect2.bottom + this.jas);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.aIX = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.aIX = x;
                    this.jat.rect.offset((int) (x - this.aIX), 0);
                    a(this.jat);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.jat.rect);
        this.jao.offsetRectIntoDescendantCoords((View) this.jap, this.mTempRect);
        this.jap.o(this.mTempRect);
        this.jao.invalidate();
        if (this.jat.jaX) {
            this.jap.cmT();
        } else if (this.jat.jaY) {
            this.jap.cmU();
        } else {
            this.jap.cmV();
        }
    }

    private void a(b bVar) {
        bVar.jaX = false;
        bVar.jaY = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.jao.getWidth() - this.jav) - this.jaw;
        if (rect.left < this.jav) {
            rect.left = this.jav;
            rect.right = rect.left + width;
        }
        if (rect.right > this.jav + width2) {
            rect.right = this.jav + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.jav + this.jas) {
            bVar.jaX = true;
            bVar.jaY = false;
        }
        if (rect.right > (this.jav + width2) - this.jas) {
            bVar.jaX = false;
            bVar.jaY = true;
        }
    }

    public void a(d dVar) {
        this.jap = dVar;
    }

    public void a(c cVar) {
        this.jaq = cVar;
        this.jaq.setDragController(this);
    }
}
