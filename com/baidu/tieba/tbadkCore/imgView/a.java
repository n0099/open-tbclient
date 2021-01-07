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
    private Vibrator dPV;
    public float dyT;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private DragLayer ntf;
    private d ntg;
    private c nth;
    public boolean nti;
    private float ntj;
    private b ntk;
    private Rect ntl;
    private int ntm;
    private int ntn;

    public a(Context context) {
        this.mContext = context;
        this.dPV = (Vibrator) context.getSystemService("vibrator");
        this.ntj = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.ntf = dragLayer;
        dragLayer.setDragController(this);
        this.ntm = this.ntf.getPaddingLeft();
        this.ntn = this.ntf.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.ntf != null && view != null && view.getDrawingCache() != null) {
            this.nti = true;
            this.ntk = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.ntf.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.ntk.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.ntk.rect = rect;
            this.ntk.ntM = bundle;
            view.setVisibility(4);
            a(this.ntk);
            this.ntf.setDragObject(this.ntk);
            this.dPV.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.nti) {
            this.nti = false;
            this.ntk = null;
            this.ntg.dPC();
            this.ntg.dPD();
            this.ntf.dPF();
            this.ntf.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.dyT = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.nti;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nti) {
            if (this.ntl == null) {
                this.ntl = new Rect();
                this.ntf.getDrawingRect(this.ntl);
                Rect rect = this.ntl;
                rect.top = (int) (rect.top - this.ntj);
                Rect rect2 = this.ntl;
                rect2.bottom = (int) (rect2.bottom + this.ntj);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.dyT = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.dyT = x;
                    this.ntk.rect.offset((int) (x - this.dyT), 0);
                    a(this.ntk);
                    dPy();
                    break;
            }
            return true;
        }
        return false;
    }

    public void dPy() {
        this.mTempRect.set(this.ntk.rect);
        this.ntf.offsetRectIntoDescendantCoords((View) this.ntg, this.mTempRect);
        this.ntg.i(this.mTempRect);
        this.ntf.invalidate();
        if (this.ntk.ntN) {
            this.ntg.dPA();
        } else if (this.ntk.ntO) {
            this.ntg.dPB();
        } else {
            this.ntg.dPC();
        }
    }

    private void a(b bVar) {
        bVar.ntN = false;
        bVar.ntO = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.ntf.getWidth() - this.ntm) - this.ntn;
        if (rect.left < this.ntm) {
            rect.left = this.ntm;
            rect.right = rect.left + width;
        }
        if (rect.right > this.ntm + width2) {
            rect.right = this.ntm + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.ntm + this.ntj) {
            bVar.ntN = true;
            bVar.ntO = false;
        }
        if (rect.right > (this.ntm + width2) - this.ntj) {
            bVar.ntN = false;
            bVar.ntO = true;
        }
    }

    public void a(d dVar) {
        this.ntg = dVar;
    }

    public void a(c cVar) {
        this.nth = cVar;
        this.nth.setDragController(this);
    }
}
