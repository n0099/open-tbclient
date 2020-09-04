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
    public float cLy;
    private Context mContext;
    private Rect mTempRect = new Rect();
    private Vibrator mVibrator;
    private DragLayer mgK;
    private d mgL;
    private c mgM;
    public boolean mgN;
    private float mgO;
    private b mgP;
    private Rect mgQ;
    private int mgR;
    private int mgS;

    public a(Context context) {
        this.mContext = context;
        this.mVibrator = (Vibrator) context.getSystemService("vibrator");
        this.mgO = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.mgK = dragLayer;
        dragLayer.setDragController(this);
        this.mgR = this.mgK.getPaddingLeft();
        this.mgS = this.mgK.getPaddingRight();
    }

    public void b(View view, Bundle bundle) {
        if (this.mgK != null && view != null && view.getDrawingCache() != null) {
            this.mgN = true;
            this.mgP = new b(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.mgK.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.mgP.bm = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.mgP.rect = rect;
            this.mgP.mht = bundle;
            view.setVisibility(4);
            a(this.mgP);
            this.mgK.setDragObject(this.mgP);
            this.mVibrator.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.mgN) {
            this.mgN = false;
            this.mgP = null;
            this.mgL.dxi();
            this.mgL.dxj();
            this.mgK.dxl();
            this.mgK.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.cLy = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.mgN;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mgN) {
            if (this.mgQ == null) {
                this.mgQ = new Rect();
                this.mgK.getDrawingRect(this.mgQ);
                Rect rect = this.mgQ;
                rect.top = (int) (rect.top - this.mgO);
                Rect rect2 = this.mgQ;
                rect2.bottom = (int) (rect2.bottom + this.mgO);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.cLy = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.cLy = x;
                    this.mgP.rect.offset((int) (x - this.cLy), 0);
                    a(this.mgP);
                    dxe();
                    break;
            }
            return true;
        }
        return false;
    }

    public void dxe() {
        this.mTempRect.set(this.mgP.rect);
        this.mgK.offsetRectIntoDescendantCoords((View) this.mgL, this.mTempRect);
        this.mgL.j(this.mTempRect);
        this.mgK.invalidate();
        if (this.mgP.mhu) {
            this.mgL.dxg();
        } else if (this.mgP.mhv) {
            this.mgL.dxh();
        } else {
            this.mgL.dxi();
        }
    }

    private void a(b bVar) {
        bVar.mhu = false;
        bVar.mhv = false;
        Rect rect = bVar.rect;
        int width = rect.width();
        int width2 = (this.mgK.getWidth() - this.mgR) - this.mgS;
        if (rect.left < this.mgR) {
            rect.left = this.mgR;
            rect.right = rect.left + width;
        }
        if (rect.right > this.mgR + width2) {
            rect.right = this.mgR + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.mgR + this.mgO) {
            bVar.mhu = true;
            bVar.mhv = false;
        }
        if (rect.right > (this.mgR + width2) - this.mgO) {
            bVar.mhu = false;
            bVar.mhv = true;
        }
    }

    public void a(d dVar) {
        this.mgL = dVar;
    }

    public void a(c cVar) {
        this.mgM = cVar;
        this.mgM.setDragController(this);
    }
}
