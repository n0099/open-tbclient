package com.baidu.tieba.view;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f2592a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.f2592a = kVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        n nVar;
        n nVar2;
        if (Math.abs(f) > 200.0f || Math.abs(f2) > 200.0f) {
            nVar = this.f2592a.t;
            nVar.a(f, f2);
            k kVar = this.f2592a;
            nVar2 = this.f2592a.t;
            kVar.startAnimation(nVar2);
        }
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        View.OnClickListener onClickListener;
        boolean z;
        View.OnClickListener onClickListener2;
        onClickListener = this.f2592a.r;
        if (onClickListener != null) {
            z = this.f2592a.y;
            if (!z) {
                onClickListener2 = this.f2592a.r;
                onClickListener2.onClick(this.f2592a);
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
        this.f2592a.y = true;
        i = this.f2592a.p;
        if (i == 0) {
            z = this.f2592a.z;
            if (z) {
                return false;
            }
        }
        int scrollX = this.f2592a.getScrollX();
        f3 = this.f2592a.e;
        if (f3 >= this.f2592a.getWidth()) {
            scrollX = (int) (scrollX + f);
            i12 = this.f2592a.p;
            if (i12 == 0) {
                i2 = scrollX >= 0 ? scrollX : 0;
                f8 = this.f2592a.e;
                if (this.f2592a.getWidth() + i2 > f8) {
                    f9 = this.f2592a.e;
                    i2 = (int) (f9 - this.f2592a.getWidth());
                }
                scrollY = this.f2592a.getScrollY();
                f4 = this.f2592a.f;
                i3 = this.f2592a.H;
                f5 = f4 + i3;
                i4 = this.f2592a.I;
                if (f5 + i4 >= this.f2592a.getHeight()) {
                    scrollY = (int) (scrollY + f2);
                    i5 = this.f2592a.p;
                    if (i5 == 0) {
                        i6 = this.f2592a.J;
                        if (scrollY < (-i6)) {
                            i11 = this.f2592a.J;
                            scrollY = -i11;
                        }
                        f6 = this.f2592a.f;
                        i7 = this.f2592a.I;
                        float f10 = f6 + i7;
                        i8 = this.f2592a.K;
                        if (this.f2592a.getHeight() + scrollY > f10 + i8) {
                            f7 = this.f2592a.f;
                            float height = f7 - this.f2592a.getHeight();
                            i9 = this.f2592a.I;
                            float f11 = height + i9;
                            i10 = this.f2592a.K;
                            scrollY = (int) (f11 + i10);
                        }
                    }
                }
                if (i2 == this.f2592a.getScrollX() || scrollY != this.f2592a.getScrollY()) {
                    this.f2592a.scrollTo(i2, scrollY);
                    this.f2592a.invalidate();
                }
                return true;
            }
        }
        i2 = scrollX;
        scrollY = this.f2592a.getScrollY();
        f4 = this.f2592a.f;
        i3 = this.f2592a.H;
        f5 = f4 + i3;
        i4 = this.f2592a.I;
        if (f5 + i4 >= this.f2592a.getHeight()) {
        }
        if (i2 == this.f2592a.getScrollX()) {
        }
        this.f2592a.scrollTo(i2, scrollY);
        this.f2592a.invalidate();
        return true;
    }
}
