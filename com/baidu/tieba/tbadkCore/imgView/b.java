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
    private DragLayer ghZ;
    private Vibrator gia;
    private e gib;
    private d gic;
    public boolean gie;
    private float gif;
    private c gig;
    private Rect gih;
    private int gii;
    private int gij;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.gia = (Vibrator) context.getSystemService("vibrator");
        this.gif = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.ghZ = dragLayer;
        dragLayer.setDragController(this);
        this.gii = this.ghZ.getPaddingLeft();
        this.gij = this.ghZ.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.ghZ != null && view != null && view.getDrawingCache() != null) {
            this.gie = true;
            this.gig = new c(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.ghZ.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.gig.aNp = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.gig.rect = rect;
            this.gig.giL = bundle;
            view.setVisibility(4);
            a(this.gig);
            this.ghZ.setDragObject(this.gig);
            this.gia.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.gie) {
            this.gie = false;
            this.gig = null;
            this.gib.brU();
            this.gib.brV();
            this.ghZ.brX();
            this.ghZ.invalidate();
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
        return this.gie;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gie) {
            if (this.gih == null) {
                this.gih = new Rect();
                this.ghZ.getDrawingRect(this.gih);
                Rect rect = this.gih;
                rect.top = (int) (rect.top - this.gif);
                Rect rect2 = this.gih;
                rect2.bottom = (int) (rect2.bottom + this.gif);
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
                    this.gig.rect.offset((int) (x - this.aOy), 0);
                    a(this.gig);
                    brQ();
                    break;
            }
            return true;
        }
        return false;
    }

    public void brQ() {
        this.mTempRect.set(this.gig.rect);
        this.ghZ.offsetRectIntoDescendantCoords((View) this.gib, this.mTempRect);
        this.gib.i(this.mTempRect);
        this.ghZ.invalidate();
        if (this.gig.giM) {
            this.gib.brS();
        } else if (this.gig.giN) {
            this.gib.brT();
        } else {
            this.gib.brU();
        }
    }

    private void a(c cVar) {
        cVar.giM = false;
        cVar.giN = false;
        Rect rect = cVar.rect;
        int width = rect.width();
        int width2 = (this.ghZ.getWidth() - this.gii) - this.gij;
        if (rect.left < this.gii) {
            rect.left = this.gii;
            rect.right = rect.left + width;
        }
        if (rect.right > this.gii + width2) {
            rect.right = this.gii + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.gii + this.gif) {
            cVar.giM = true;
            cVar.giN = false;
        }
        if (rect.right > (this.gii + width2) - this.gif) {
            cVar.giM = false;
            cVar.giN = true;
        }
    }

    public void a(e eVar) {
        this.gib = eVar;
    }

    public void a(d dVar) {
        this.gic = dVar;
        this.gic.setDragController(this);
    }
}
