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
    public float bLa;
    private DragLayer kib;
    private d kic;
    private c kie;
    public boolean kif;
    private float kig;
    private b kih;
    private Rect kii;
    private int kij;
    private int kik;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.kig = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.kib = dragLayer;
        dragLayer.setDragController(this);
        this.kij = this.kib.getPaddingLeft();
        this.kik = this.kib.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.kib != null && view != null && view.getDrawingCache() != null) {
            this.kif = true;
            this.kih = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.kib.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.kih.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.kih.rect = rect;
            this.kih.kiK = bundle;
            view.setVisibility(4);
            a(this.kih);
            this.kib.setDragObject(this.kih);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.kif) {
            this.kif = false;
            this.kih = null;
            this.kic.cLx();
            this.kic.cLy();
            this.kib.cLA();
            this.kib.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.bLa = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.kif;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.kif) {
            if (this.kii == null) {
                this.kii = new Rect();
                this.kib.getDrawingRect(this.kii);
                Rect rect = this.kii;
                rect.top = (int) (rect.top - this.kig);
                Rect rect2 = this.kii;
                rect2.bottom = (int) (rect2.bottom + this.kig);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bLa = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.bLa = x;
                    this.kih.rect.offset((int) (x - this.bLa), 0);
                    a(this.kih);
                    cLt();
                    break;
            }
            return true;
        }
        return false;
    }

    public void cLt() {
        this.mTempRect.set(this.kih.rect);
        this.kib.offsetRectIntoDescendantCoords((View) this.kic, this.mTempRect);
        this.kic.j(this.mTempRect);
        this.kib.invalidate();
        if (this.kih.kiL) {
            this.kic.cLv();
        } else if (this.kih.kiM) {
            this.kic.cLw();
        } else {
            this.kic.cLx();
        }
    }

    private void a(b bVar) {
        bVar.kiL = false;
        bVar.kiM = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.kib.getWidth() - this.kij) - this.kik;
        if (rect.left < this.kij) {
            rect.left = this.kij;
            rect.right = rect.left + width;
        }
        if (rect.right > this.kij + width2) {
            rect.right = this.kij + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.kij + this.kig) {
            bVar.kiL = true;
            bVar.kiM = false;
        }
        if (rect.right > (this.kij + width2) - this.kig) {
            bVar.kiL = false;
            bVar.kiM = true;
        }
    }

    public void a(d dVar) {
        this.kic = dVar;
    }

    public void a(c cVar) {
        this.kie = cVar;
        this.kie.setDragController(this);
    }
}
