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
public class b {
    public float aOy;
    private DragLayer gia;
    private Vibrator gib;
    private e gic;
    private d gie;
    public boolean gif;
    private float gig;
    private c gih;
    private Rect gii;
    private int gij;
    private int gik;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.gib = (Vibrator) context.getSystemService("vibrator");
        this.gig = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.gia = dragLayer;
        dragLayer.setDragController(this);
        this.gij = this.gia.getPaddingLeft();
        this.gik = this.gia.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.gia != null && view != null && view.getDrawingCache() != null) {
            this.gif = true;
            this.gih = new c(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.gia.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.gih.aNp = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.gih.rect = rect;
            this.gih.giM = bundle;
            view.setVisibility(4);
            a(this.gih);
            this.gia.setDragObject(this.gih);
            this.gib.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.gif) {
            this.gif = false;
            this.gih = null;
            this.gic.brV();
            this.gic.brW();
            this.gia.brY();
            this.gia.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.aOy = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.gif;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gif) {
            if (this.gii == null) {
                this.gii = new Rect();
                this.gia.getDrawingRect(this.gii);
                Rect rect = this.gii;
                rect.top = (int) (rect.top - this.gig);
                Rect rect2 = this.gii;
                rect2.bottom = (int) (rect2.bottom + this.gig);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.aOy = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.aOy = x;
                    this.gih.rect.offset((int) (x - this.aOy), 0);
                    a(this.gih);
                    brR();
                    break;
            }
            return true;
        }
        return false;
    }

    public void brR() {
        this.mTempRect.set(this.gih.rect);
        this.gia.offsetRectIntoDescendantCoords((View) this.gic, this.mTempRect);
        this.gic.i(this.mTempRect);
        this.gia.invalidate();
        if (this.gih.giN) {
            this.gic.brT();
        } else if (this.gih.giO) {
            this.gic.brU();
        } else {
            this.gic.brV();
        }
    }

    private void a(c cVar) {
        cVar.giN = false;
        cVar.giO = false;
        Rect rect = cVar.rect;
        int width = rect.width();
        int width2 = (this.gia.getWidth() - this.gij) - this.gik;
        if (rect.left < this.gij) {
            rect.left = this.gij;
            rect.right = rect.left + width;
        }
        if (rect.right > this.gij + width2) {
            rect.right = this.gij + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.gij + this.gig) {
            cVar.giN = true;
            cVar.giO = false;
        }
        if (rect.right > (this.gij + width2) - this.gig) {
            cVar.giN = false;
            cVar.giO = true;
        }
    }

    public void a(e eVar) {
        this.gic = eVar;
    }

    public void a(d dVar) {
        this.gie = dVar;
        this.gie.setDragController(this);
    }
}
