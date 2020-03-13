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
    public float bLc;
    private DragLayer kiq;
    private d kir;
    private c kis;
    public boolean kit;
    private float kiu;
    private b kiv;
    private Rect kiw;
    private int kix;
    private int kiy;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.kiu = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.kiq = dragLayer;
        dragLayer.setDragController(this);
        this.kix = this.kiq.getPaddingLeft();
        this.kiy = this.kiq.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.kiq != null && view != null && view.getDrawingCache() != null) {
            this.kit = true;
            this.kiv = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.kiq.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.kiv.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.kiv.rect = rect;
            this.kiv.kiY = bundle;
            view.setVisibility(4);
            a(this.kiv);
            this.kiq.setDragObject(this.kiv);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.kit) {
            this.kit = false;
            this.kiv = null;
            this.kir.cLA();
            this.kir.cLB();
            this.kiq.cLD();
            this.kiq.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.bLc = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.kit;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.kit) {
            if (this.kiw == null) {
                this.kiw = new Rect();
                this.kiq.getDrawingRect(this.kiw);
                Rect rect = this.kiw;
                rect.top = (int) (rect.top - this.kiu);
                Rect rect2 = this.kiw;
                rect2.bottom = (int) (rect2.bottom + this.kiu);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bLc = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.bLc = x;
                    this.kiv.rect.offset((int) (x - this.bLc), 0);
                    a(this.kiv);
                    cLw();
                    break;
            }
            return true;
        }
        return false;
    }

    public void cLw() {
        this.mTempRect.set(this.kiv.rect);
        this.kiq.offsetRectIntoDescendantCoords((View) this.kir, this.mTempRect);
        this.kir.j(this.mTempRect);
        this.kiq.invalidate();
        if (this.kiv.kiZ) {
            this.kir.cLy();
        } else if (this.kiv.kja) {
            this.kir.cLz();
        } else {
            this.kir.cLA();
        }
    }

    private void a(b bVar) {
        bVar.kiZ = false;
        bVar.kja = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.kiq.getWidth() - this.kix) - this.kiy;
        if (rect.left < this.kix) {
            rect.left = this.kix;
            rect.right = rect.left + width;
        }
        if (rect.right > this.kix + width2) {
            rect.right = this.kix + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.kix + this.kiu) {
            bVar.kiZ = true;
            bVar.kja = false;
        }
        if (rect.right > (this.kix + width2) - this.kiu) {
            bVar.kiZ = false;
            bVar.kja = true;
        }
    }

    public void a(d dVar) {
        this.kir = dVar;
    }

    public void a(c cVar) {
        this.kis = cVar;
        this.kis.setDragController(this);
    }
}
