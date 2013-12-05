package com.baidu.tieba.view;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f2693a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.f2693a = lVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        o oVar;
        o oVar2;
        if (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f) {
            oVar = this.f2693a.u;
            oVar.a(f, f2);
            l lVar = this.f2693a;
            oVar2 = this.f2693a.u;
            lVar.startAnimation(oVar2);
        }
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        View.OnClickListener onClickListener;
        boolean z;
        View.OnClickListener onClickListener2;
        onClickListener = this.f2693a.r;
        if (onClickListener != null) {
            z = this.f2693a.z;
            if (!z) {
                onClickListener2 = this.f2693a.r;
                onClickListener2.onClick(this.f2693a);
            }
        }
        return super.onSingleTapUp(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        float f3;
        int i2;
        int scrollY;
        float f4;
        int i3;
        float f5;
        int i4;
        int i5;
        int i6;
        float f6;
        int i7;
        int i8;
        float f7;
        int i9;
        int i10;
        int i11;
        int i12;
        float f8;
        float f9;
        boolean z;
        this.f2693a.z = true;
        i = this.f2693a.p;
        if (i == 0) {
            z = this.f2693a.A;
            if (z) {
                return false;
            }
        }
        int scrollX = this.f2693a.getScrollX();
        f3 = this.f2693a.e;
        if (f3 >= this.f2693a.getWidth()) {
            scrollX = (int) (scrollX + f);
            i12 = this.f2693a.p;
            if (i12 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                f8 = this.f2693a.e;
                if (this.f2693a.getWidth() + i2 > f8) {
                    f9 = this.f2693a.e;
                    i2 = (int) (f9 - this.f2693a.getWidth());
                }
                scrollY = this.f2693a.getScrollY();
                f4 = this.f2693a.f;
                i3 = this.f2693a.I;
                f5 = f4 + i3;
                i4 = this.f2693a.J;
                if (f5 + i4 >= this.f2693a.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i5 = this.f2693a.p;
                    if (i5 == 0) {
                        i6 = this.f2693a.K;
                        if (scrollY < (-i6)) {
                            i11 = this.f2693a.K;
                            scrollY = -i11;
                        }
                        f6 = this.f2693a.f;
                        i7 = this.f2693a.J;
                        float f10 = f6 + i7;
                        i8 = this.f2693a.L;
                        if (this.f2693a.getHeight() + scrollY > f10 + i8) {
                            f7 = this.f2693a.f;
                            float height = f7 - this.f2693a.getHeight();
                            i9 = this.f2693a.J;
                            float f11 = height + i9;
                            i10 = this.f2693a.L;
                            scrollY = (int) (f11 + i10);
                        }
                    }
                }
                if (i2 == this.f2693a.getScrollX() || scrollY != this.f2693a.getScrollY()) {
                    this.f2693a.scrollTo(i2, scrollY);
                    this.f2693a.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.f2693a.getScrollY();
        f4 = this.f2693a.f;
        i3 = this.f2693a.I;
        f5 = f4 + i3;
        i4 = this.f2693a.J;
        if (f5 + i4 >= this.f2693a.getHeight()) {
        }
        if (i2 == this.f2693a.getScrollX()) {
        }
        this.f2693a.scrollTo(i2, scrollY);
        this.f2693a.invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View.OnLongClickListener onLongClickListener;
        boolean z;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.f2693a.s;
        if (onLongClickListener != null) {
            z = this.f2693a.z;
            if (!z) {
                onLongClickListener2 = this.f2693a.s;
                onLongClickListener2.onLongClick(this.f2693a);
            }
        }
        super.onLongPress(motionEvent);
    }
}
