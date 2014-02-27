package com.baidu.tieba.img.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public final class a {
    public boolean a;
    public float b;
    private DragLayer c;
    private Context d;
    private Vibrator e;
    private g f;
    private f g;
    private float h;
    private e i;
    private Rect j = new Rect();
    private Rect k;
    private int l;
    private int m;

    public a(Context context) {
        this.d = context;
        this.e = (Vibrator) context.getSystemService("vibrator");
        this.h = this.d.getResources().getDisplayMetrics().density * 20.0f;
    }

    public final void a(DragLayer dragLayer) {
        this.c = dragLayer;
        dragLayer.setDragController(this);
        this.l = this.c.getPaddingLeft();
        this.m = this.c.getPaddingRight();
    }

    public final void a(View view, Bundle bundle) {
        this.a = true;
        this.i = new e(this.d);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.c.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.i.b = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        this.i.a = rect;
        this.i.c = null;
        view.setVisibility(4);
        a(this.i);
        this.c.setDragObject(this.i);
        this.e.vibrate(300L);
    }

    private void b() {
        if (this.a) {
            this.a = false;
            this.i = null;
            this.f.c();
            this.f.d();
            this.c.a();
            this.c.invalidate();
        }
    }

    public final boolean a(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.b = motionEvent.getX(0);
                break;
            case 1:
            case 3:
            case 4:
            case 6:
                b();
                break;
        }
        return this.a;
    }

    public final boolean b(MotionEvent motionEvent) {
        if (this.a) {
            if (this.k == null) {
                this.k = new Rect();
                this.c.getDrawingRect(this.k);
                Rect rect = this.k;
                rect.top = (int) (rect.top - this.h);
                Rect rect2 = this.k;
                rect2.bottom = (int) (rect2.bottom + this.h);
            }
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case 0:
                    this.b = motionEvent.getX(0);
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                    b();
                    break;
                case 2:
                    float x = motionEvent.getX(0);
                    this.b = x;
                    this.i.a.offset((int) (x - this.b), 0);
                    a(this.i);
                    a();
                    break;
            }
            return true;
        }
        return false;
    }

    public final void a() {
        this.j.set(this.i.a);
        this.c.offsetRectIntoDescendantCoords((View) this.f, this.j);
        this.f.a(this.j);
        this.c.invalidate();
        if (this.i.d) {
            this.f.a();
        } else if (this.i.e) {
            this.f.b();
        } else {
            this.f.c();
        }
    }

    private void a(e eVar) {
        eVar.d = false;
        eVar.e = false;
        Rect rect = eVar.a;
        int width = rect.width();
        int width2 = (this.c.getWidth() - this.l) - this.m;
        if (rect.left < this.l) {
            rect.left = this.l;
            rect.right = rect.left + width;
        }
        if (rect.right > this.l + width2) {
            rect.right = this.l + width2;
            rect.left = rect.right - width;
        }
        if (rect.left < this.l + this.h) {
            eVar.d = true;
            eVar.e = false;
        }
        if (rect.right > (this.l + width2) - this.h) {
            eVar.d = false;
            eVar.e = true;
        }
    }

    public final void a(g gVar) {
        this.f = gVar;
    }

    public final void a(f fVar) {
        this.g = fVar;
        this.g.setDragController(this);
    }
}
