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
public class a {
    public float adk;
    private int cJA;
    private DragLayer cJr;
    private Vibrator cJs;
    private f cJt;
    private e cJu;
    public boolean cJv;
    private float cJw;
    private d cJx;
    private Rect cJy;
    private int cJz;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.cJs = (Vibrator) context.getSystemService("vibrator");
        this.cJw = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.cJr = dragLayer;
        dragLayer.setDragController(this);
        this.cJz = this.cJr.getPaddingLeft();
        this.cJA = this.cJr.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        this.cJv = true;
        this.cJx = new d(this.mContext);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.cJr.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.cJx.aAn = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        this.cJx.aps = rect;
        this.cJx.cKd = bundle;
        view.setVisibility(4);
        a(this.cJx);
        this.cJr.setDragObject(this.cJx);
        this.cJs.vibrate(300L);
    }

    public void endDrag() {
        if (this.cJv) {
            this.cJv = false;
            this.cJx = null;
            this.cJt.aqr();
            this.cJt.aqs();
            this.cJr.aqu();
            this.cJr.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.adk = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.cJv;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cJv) {
            if (this.cJy == null) {
                this.cJy = new Rect();
                this.cJr.getDrawingRect(this.cJy);
                Rect rect = this.cJy;
                rect.top = (int) (rect.top - this.cJw);
                Rect rect2 = this.cJy;
                rect2.bottom = (int) (rect2.bottom + this.cJw);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.adk = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.adk = x;
                    this.cJx.aps.offset((int) (x - this.adk), 0);
                    a(this.cJx);
                    aqn();
                    break;
            }
            return true;
        }
        return false;
    }

    public void aqn() {
        this.mTempRect.set(this.cJx.aps);
        this.cJr.offsetRectIntoDescendantCoords((View) this.cJt, this.mTempRect);
        this.cJt.d(this.mTempRect);
        this.cJr.invalidate();
        if (this.cJx.cKe) {
            this.cJt.aqp();
        } else if (this.cJx.cKf) {
            this.cJt.aqq();
        } else {
            this.cJt.aqr();
        }
    }

    private void a(d dVar) {
        dVar.cKe = false;
        dVar.cKf = false;
        Rect rect = dVar.aps;
        int width = rect.width();
        int width2 = (this.cJr.getWidth() - this.cJz) - this.cJA;
        if (rect.left < this.cJz) {
            rect.left = this.cJz;
            rect.right = rect.left + width;
        }
        if (rect.right > this.cJz + width2) {
            rect.right = this.cJz + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.cJz + this.cJw) {
            dVar.cKe = true;
            dVar.cKf = false;
        }
        if (rect.right > (this.cJz + width2) - this.cJw) {
            dVar.cKe = false;
            dVar.cKf = true;
        }
    }

    public void a(f fVar) {
        this.cJt = fVar;
    }

    public void a(e eVar) {
        this.cJu = eVar;
        this.cJu.setDragController(this);
    }
}
