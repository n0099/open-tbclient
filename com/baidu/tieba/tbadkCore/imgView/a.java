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
    public float aSb;
    private Vibrator cLc;
    private DragLayer gyO;
    private d gyP;
    private c gyQ;
    public boolean gyR;
    private float gyS;
    private b gyT;
    private Rect gyU;
    private int gyV;
    private int gyW;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.cLc = (Vibrator) context.getSystemService("vibrator");
        this.gyS = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.gyO = dragLayer;
        dragLayer.setDragController(this);
        this.gyV = this.gyO.getPaddingLeft();
        this.gyW = this.gyO.getPaddingRight();
    }

    public void b(View view2, Bundle bundle) {
        if (this.gyO != null && view2 != null && view2.getDrawingCache() != null) {
            this.gyR = true;
            this.gyT = new b(this.mContext);
            Rect rect = new Rect();
            view2.getDrawingRect(rect);
            this.gyO.offsetDescendantRectToMyCoords(view2, rect);
            view2.setDrawingCacheEnabled(true);
            view2.buildDrawingCache();
            this.gyT.aOR = Bitmap.createBitmap(view2.getDrawingCache());
            view2.destroyDrawingCache();
            view2.setDrawingCacheEnabled(false);
            this.gyT.rect = rect;
            this.gyT.gzx = bundle;
            view2.setVisibility(4);
            a(this.gyT);
            this.gyO.setDragObject(this.gyT);
            this.cLc.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.gyR) {
            this.gyR = false;
            this.gyT = null;
            this.gyP.bst();
            this.gyP.bsu();
            this.gyO.bsw();
            this.gyO.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.aSb = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.gyR;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gyR) {
            if (this.gyU == null) {
                this.gyU = new Rect();
                this.gyO.getDrawingRect(this.gyU);
                Rect rect = this.gyU;
                rect.top = (int) (rect.top - this.gyS);
                Rect rect2 = this.gyU;
                rect2.bottom = (int) (rect2.bottom + this.gyS);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.aSb = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.aSb = x;
                    this.gyT.rect.offset((int) (x - this.aSb), 0);
                    a(this.gyT);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.gyT.rect);
        this.gyO.offsetRectIntoDescendantCoords((View) this.gyP, this.mTempRect);
        this.gyP.k(this.mTempRect);
        this.gyO.invalidate();
        if (this.gyT.gzy) {
            this.gyP.bsr();
        } else if (this.gyT.gzz) {
            this.gyP.bss();
        } else {
            this.gyP.bst();
        }
    }

    private void a(b bVar) {
        bVar.gzy = false;
        bVar.gzz = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.gyO.getWidth() - this.gyV) - this.gyW;
        if (rect.left < this.gyV) {
            rect.left = this.gyV;
            rect.right = rect.left + width;
        }
        if (rect.right > this.gyV + width2) {
            rect.right = this.gyV + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.gyV + this.gyS) {
            bVar.gzy = true;
            bVar.gzz = false;
        }
        if (rect.right > (this.gyV + width2) - this.gyS) {
            bVar.gzy = false;
            bVar.gzz = true;
        }
    }

    public void a(d dVar) {
        this.gyP = dVar;
    }

    public void a(c cVar) {
        this.gyQ = cVar;
        this.gyQ.setDragController(this);
    }
}
