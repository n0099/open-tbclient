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
    public float bLb;
    private DragLayer kie;
    private d kif;
    private c kig;
    public boolean kih;
    private float kii;
    private b kij;
    private Rect kik;
    private int kil;
    private int kim;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.kii = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.kie = dragLayer;
        dragLayer.setDragController(this);
        this.kil = this.kie.getPaddingLeft();
        this.kim = this.kie.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.kie != null && view != null && view.getDrawingCache() != null) {
            this.kih = true;
            this.kij = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.kie.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.kij.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.kij.rect = rect;
            this.kij.kiM = bundle;
            view.setVisibility(4);
            a(this.kij);
            this.kie.setDragObject(this.kij);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.kih) {
            this.kih = false;
            this.kij = null;
            this.kif.cLz();
            this.kif.cLA();
            this.kie.cLC();
            this.kie.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.bLb = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.kih;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.kih) {
            if (this.kik == null) {
                this.kik = new Rect();
                this.kie.getDrawingRect(this.kik);
                Rect rect = this.kik;
                rect.top = (int) (rect.top - this.kii);
                Rect rect2 = this.kik;
                rect2.bottom = (int) (rect2.bottom + this.kii);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bLb = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.bLb = x;
                    this.kij.rect.offset((int) (x - this.bLb), 0);
                    a(this.kij);
                    cLv();
                    break;
            }
            return true;
        }
        return false;
    }

    public void cLv() {
        this.mTempRect.set(this.kij.rect);
        this.kie.offsetRectIntoDescendantCoords((View) this.kif, this.mTempRect);
        this.kif.j(this.mTempRect);
        this.kie.invalidate();
        if (this.kij.kiN) {
            this.kif.cLx();
        } else if (this.kij.kiO) {
            this.kif.cLy();
        } else {
            this.kif.cLz();
        }
    }

    private void a(b bVar) {
        bVar.kiN = false;
        bVar.kiO = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.kie.getWidth() - this.kil) - this.kim;
        if (rect.left < this.kil) {
            rect.left = this.kil;
            rect.right = rect.left + width;
        }
        if (rect.right > this.kil + width2) {
            rect.right = this.kil + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.kil + this.kii) {
            bVar.kiN = true;
            bVar.kiO = false;
        }
        if (rect.right > (this.kil + width2) - this.kii) {
            bVar.kiN = false;
            bVar.kiO = true;
        }
    }

    public void a(d dVar) {
        this.kif = dVar;
    }

    public void a(c cVar) {
        this.kig = cVar;
        this.kig.setDragController(this);
    }
}
