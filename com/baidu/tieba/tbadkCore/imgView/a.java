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
    private DragLayer jak;
    private d jal;
    private c jam;
    public boolean jan;
    private float jao;
    private b jap;
    private Rect jaq;
    private int jar;
    private int jas;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.aXs = (Vibrator) context.getSystemService("vibrator");
        this.jao = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.jak = dragLayer;
        dragLayer.setDragController(this);
        this.jar = this.jak.getPaddingLeft();
        this.jas = this.jak.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.jak != null && view != null && view.getDrawingCache() != null) {
            this.jan = true;
            this.jap = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.jak.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.jap.cDg = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.jap.rect = rect;
            this.jap.jaS = bundle;
            view.setVisibility(4);
            a(this.jap);
            this.jak.setDragObject(this.jap);
            this.aXs.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.jan) {
            this.jan = false;
            this.jap = null;
            this.jal.cmU();
            this.jal.cmV();
            this.jak.cmX();
            this.jak.invalidate();
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
        return this.jan;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jan) {
            if (this.jaq == null) {
                this.jaq = new Rect();
                this.jak.getDrawingRect(this.jaq);
                Rect rect = this.jaq;
                rect.top = (int) (rect.top - this.jao);
                Rect rect2 = this.jaq;
                rect2.bottom = (int) (rect2.bottom + this.jao);
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
                    this.jap.rect.offset((int) (x - this.aIX), 0);
                    a(this.jap);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.jap.rect);
        this.jak.offsetRectIntoDescendantCoords((View) this.jal, this.mTempRect);
        this.jal.o(this.mTempRect);
        this.jak.invalidate();
        if (this.jap.jaT) {
            this.jal.cmS();
        } else if (this.jap.jaU) {
            this.jal.cmT();
        } else {
            this.jal.cmU();
        }
    }

    private void a(b bVar) {
        bVar.jaT = false;
        bVar.jaU = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.jak.getWidth() - this.jar) - this.jas;
        if (rect.left < this.jar) {
            rect.left = this.jar;
            rect.right = rect.left + width;
        }
        if (rect.right > this.jar + width2) {
            rect.right = this.jar + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.jar + this.jao) {
            bVar.jaT = true;
            bVar.jaU = false;
        }
        if (rect.right > (this.jar + width2) - this.jao) {
            bVar.jaT = false;
            bVar.jaU = true;
        }
    }

    public void a(d dVar) {
        this.jal = dVar;
    }

    public void a(c cVar) {
        this.jam = cVar;
        this.jam.setDragController(this);
    }
}
