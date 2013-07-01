package com.baidu.tieba.view;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1523a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.f1523a = hVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        k kVar;
        k kVar2;
        if (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f) {
            kVar = this.f1523a.t;
            kVar.a(f, f2);
            h hVar = this.f1523a;
            kVar2 = this.f1523a.t;
            hVar.startAnimation(kVar2);
        }
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        View.OnClickListener onClickListener;
        boolean z;
        View.OnClickListener onClickListener2;
        onClickListener = this.f1523a.r;
        if (onClickListener != null) {
            z = this.f1523a.y;
            if (!z) {
                onClickListener2 = this.f1523a.r;
                onClickListener2.onClick(this.f1523a);
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
        this.f1523a.y = true;
        i = this.f1523a.p;
        if (i == 0) {
            z = this.f1523a.z;
            if (z) {
                return false;
            }
        }
        int scrollX = this.f1523a.getScrollX();
        f3 = this.f1523a.e;
        if (f3 >= this.f1523a.getWidth()) {
            scrollX = (int) (scrollX + f);
            i12 = this.f1523a.p;
            if (i12 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                f8 = this.f1523a.e;
                if (this.f1523a.getWidth() + i2 > f8) {
                    f9 = this.f1523a.e;
                    i2 = (int) (f9 - this.f1523a.getWidth());
                }
                scrollY = this.f1523a.getScrollY();
                f4 = this.f1523a.f;
                i3 = this.f1523a.H;
                f5 = f4 + i3;
                i4 = this.f1523a.I;
                if (f5 + i4 >= this.f1523a.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i5 = this.f1523a.p;
                    if (i5 == 0) {
                        i6 = this.f1523a.J;
                        if (scrollY < (-i6)) {
                            i11 = this.f1523a.J;
                            scrollY = -i11;
                        }
                        f6 = this.f1523a.f;
                        i7 = this.f1523a.I;
                        float f10 = f6 + i7;
                        i8 = this.f1523a.K;
                        if (this.f1523a.getHeight() + scrollY > f10 + i8) {
                            f7 = this.f1523a.f;
                            float height = f7 - this.f1523a.getHeight();
                            i9 = this.f1523a.I;
                            float f11 = height + i9;
                            i10 = this.f1523a.K;
                            scrollY = (int) (f11 + i10);
                        }
                    }
                }
                if (i2 == this.f1523a.getScrollX() || scrollY != this.f1523a.getScrollY()) {
                    this.f1523a.scrollTo(i2, scrollY);
                    this.f1523a.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.f1523a.getScrollY();
        f4 = this.f1523a.f;
        i3 = this.f1523a.H;
        f5 = f4 + i3;
        i4 = this.f1523a.I;
        if (f5 + i4 >= this.f1523a.getHeight()) {
        }
        if (i2 == this.f1523a.getScrollX()) {
        }
        this.f1523a.scrollTo(i2, scrollY);
        this.f1523a.invalidate();
        return true;
    }
}
