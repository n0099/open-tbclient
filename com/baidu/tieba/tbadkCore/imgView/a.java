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
    public float blI;
    private DragLayer dbF;
    private Vibrator dbG;
    private f dbH;
    private e dbI;
    public boolean dbJ;
    private float dbK;
    private d dbL;
    private Rect dbM;
    private int dbN;
    private int dbO;
    private Context mContext;
    private Rect mTempRect = new Rect();

    public a(Context context) {
        this.mContext = context;
        this.dbG = (Vibrator) context.getSystemService("vibrator");
        this.dbK = this.mContext.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a(DragLayer dragLayer) {
        this.dbF = dragLayer;
        dragLayer.setDragController(this);
        this.dbN = this.dbF.getPaddingLeft();
        this.dbO = this.dbF.getPaddingRight();
    }

    public void a(View view, Bundle bundle) {
        this.dbJ = true;
        this.dbL = new d(this.mContext);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.dbF.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.dbL.azy = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        this.dbL.aKf = rect;
        this.dbL.dcr = bundle;
        view.setVisibility(4);
        a(this.dbL);
        this.dbF.setDragObject(this.dbL);
        this.dbG.vibrate(300L);
    }

    public void endDrag() {
        if (this.dbJ) {
            this.dbJ = false;
            this.dbL = null;
            this.dbH.axQ();
            this.dbH.axR();
            this.dbF.axT();
            this.dbF.invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.blI = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                endDrag();
                break;
        }
        return this.dbJ;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dbJ) {
            if (this.dbM == null) {
                this.dbM = new Rect();
                this.dbF.getDrawingRect(this.dbM);
                Rect rect = this.dbM;
                rect.top = (int) (rect.top - this.dbK);
                Rect rect2 = this.dbM;
                rect2.bottom = (int) (rect2.bottom + this.dbK);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.blI = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    endDrag();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.blI = x;
                    this.dbL.aKf.offset((int) (x - this.blI), 0);
                    a(this.dbL);
                    axM();
                    break;
            }
            return true;
        }
        return false;
    }

    public void axM() {
        this.mTempRect.set(this.dbL.aKf);
        this.dbF.offsetRectIntoDescendantCoords((View) this.dbH, this.mTempRect);
        this.dbH.d(this.mTempRect);
        this.dbF.invalidate();
        if (this.dbL.dcs) {
            this.dbH.axO();
        } else if (this.dbL.dct) {
            this.dbH.axP();
        } else {
            this.dbH.axQ();
        }
    }

    private void a(d dVar) {
        dVar.dcs = false;
        dVar.dct = false;
        Rect rect = dVar.aKf;
        int width = rect.width();
        int width2 = (this.dbF.getWidth() - this.dbN) - this.dbO;
        if (rect.left < this.dbN) {
            rect.left = this.dbN;
            rect.right = rect.left + width;
        }
        if (rect.right > this.dbN + width2) {
            rect.right = this.dbN + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.dbN + this.dbK) {
            dVar.dcs = true;
            dVar.dct = false;
        }
        if (rect.right > (this.dbN + width2) - this.dbK) {
            dVar.dcs = false;
            dVar.dct = true;
        }
    }

    public void a(f fVar) {
        this.dbH = fVar;
    }

    public void a(e eVar) {
        this.dbI = eVar;
        this.dbI.setDragController(this);
    }
}
