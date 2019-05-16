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
    private DragLayer jai;
    private d jaj;
    private c jak;
    public boolean jal;
    private float jam;
    private b jan;
    private Rect jao;
    private int jap;
    private int jaq;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.aXs = (Vibrator) context.getSystemService("vibrator");
        this.jam = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.jai = dragLayer;
        dragLayer.setDragController(this);
        this.jap = this.jai.getPaddingLeft();
        this.jaq = this.jai.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.jai != null && view != null && view.getDrawingCache() != null) {
            this.jal = true;
            this.jan = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.jai.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.jan.cDg = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.jan.rect = rect;
            this.jan.jaQ = bundle;
            view.setVisibility(4);
            a(this.jan);
            this.jai.setDragObject(this.jan);
            this.aXs.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.jal) {
            this.jal = false;
            this.jan = null;
            this.jaj.cmS();
            this.jaj.cmT();
            this.jai.cmV();
            this.jai.invalidate();
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
        return this.jal;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jal) {
            if (this.jao == null) {
                this.jao = new Rect();
                this.jai.getDrawingRect(this.jao);
                Rect rect = this.jao;
                rect.top = (int) (rect.top - this.jam);
                Rect rect2 = this.jao;
                rect2.bottom = (int) (rect2.bottom + this.jam);
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
                    this.jan.rect.offset((int) (x - this.aIX), 0);
                    a(this.jan);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.jan.rect);
        this.jai.offsetRectIntoDescendantCoords((View) this.jaj, this.mTempRect);
        this.jaj.o(this.mTempRect);
        this.jai.invalidate();
        if (this.jan.jaR) {
            this.jaj.cmQ();
        } else if (this.jan.jaS) {
            this.jaj.cmR();
        } else {
            this.jaj.cmS();
        }
    }

    private void a(b bVar) {
        bVar.jaR = false;
        bVar.jaS = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.jai.getWidth() - this.jap) - this.jaq;
        if (rect.left < this.jap) {
            rect.left = this.jap;
            rect.right = rect.left + width;
        }
        if (rect.right > this.jap + width2) {
            rect.right = this.jap + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.jap + this.jam) {
            bVar.jaR = true;
            bVar.jaS = false;
        }
        if (rect.right > (this.jap + width2) - this.jam) {
            bVar.jaR = false;
            bVar.jaS = true;
        }
    }

    public void a(d dVar) {
        this.jaj = dVar;
    }

    public void a(c cVar) {
        this.jak = cVar;
        this.jak.setDragController(this);
    }
}
