package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    public float bHK;
    private DragLayer hch;
    private Vibrator hci;
    private e hcj;
    private d hck;
    public boolean hcl;
    private float hcm;
    private c hcn;
    private Rect hco;
    private int hcp;
    private int hcq;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public b(Context context) {
        this.mContext = context;
        this.hci = (Vibrator) context.getSystemService("vibrator");
        this.hcm = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.hch = dragLayer;
        dragLayer.setDragController(this);
        this.hcp = this.hch.getPaddingLeft();
        this.hcq = this.hch.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        if (this.hch != null && view != null && view.getDrawingCache() != null) {
            this.hcl = true;
            this.hcn = new c(this.mContext);
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.hch.offsetDescendantRectToMyCoords(view, rect);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            this.hcn.bED = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
            this.hcn.rect = rect;
            this.hcn.hcS = bundle;
            view.setVisibility(4);
            a(this.hcn);
            this.hch.setDragObject(this.hcn);
            this.hci.vibrate(300L);
        }
    }

    public void endDrag() {
        if (this.hcl) {
            this.hcl = false;
            this.hcn = null;
            this.hcj.bxr();
            this.hcj.bxs();
            this.hch.bxu();
            this.hch.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.bHK = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.hcl;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hcl) {
            if (this.hco == null) {
                this.hco = new Rect();
                this.hch.getDrawingRect(this.hco);
                Rect rect = this.hco;
                rect.top = (int) (rect.top - this.hcm);
                Rect rect2 = this.hco;
                rect2.bottom = (int) (rect2.bottom + this.hcm);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bHK = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.bHK = x;
                    this.hcn.rect.offset((int) (x - this.bHK), 0);
                    a(this.hcn);
                    swap();
                    break;
            }
            return true;
        }
        return false;
    }

    public void swap() {
        this.mTempRect.set(this.hcn.rect);
        this.hch.offsetRectIntoDescendantCoords((View) this.hcj, this.mTempRect);
        this.hcj.o(this.mTempRect);
        this.hch.invalidate();
        if (this.hcn.hcT) {
            this.hcj.bxp();
        } else if (this.hcn.hcU) {
            this.hcj.bxq();
        } else {
            this.hcj.bxr();
        }
    }

    private void a(c cVar) {
        cVar.hcT = false;
        cVar.hcU = false;
        Rect rect = cVar.rect;
        int width = rect.width();
        int width2 = (this.hch.getWidth() - this.hcp) - this.hcq;
        if (rect.left < this.hcp) {
            rect.left = this.hcp;
            rect.right = rect.left + width;
        }
        if (rect.right > this.hcp + width2) {
            rect.right = this.hcp + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.hcp + this.hcm) {
            cVar.hcT = true;
            cVar.hcU = false;
        }
        if (rect.right > (this.hcp + width2) - this.hcm) {
            cVar.hcT = false;
            cVar.hcU = true;
        }
    }

    public void a(e eVar) {
        this.hcj = eVar;
    }

    public void a(d dVar) {
        this.hck = dVar;
        this.hck.setDragController(this);
    }
}
