package com.baidu.tieba.pb;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements GestureDetector.OnGestureListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
        if (r0 == null) goto L38;
     */
    @Override // android.view.GestureDetector.OnGestureListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        TranslateAnimation translateAnimation;
        int i;
        TranslateAnimation translateAnimation2;
        boolean z;
        boolean z2;
        LinearLayout linearLayout;
        TranslateAnimation translateAnimation3;
        TranslateAnimation translateAnimation4;
        boolean z3;
        boolean z4;
        ListView listView;
        ListView listView2;
        LinearLayout linearLayout2;
        TranslateAnimation translateAnimation5;
        TranslateAnimation translateAnimation6;
        translateAnimation = this.a.at;
        if (translateAnimation != null) {
            translateAnimation6 = this.a.au;
        }
        this.a.q();
        int i2 = f2 > 0.0f ? 0 : 1;
        i = this.a.ay;
        if (i2 == i) {
            if (f2 > 3.0f && f2 < 50.0f) {
                translateAnimation4 = this.a.at;
                if (translateAnimation4 != null) {
                    z3 = this.a.aw;
                    if (!z3) {
                        z4 = this.a.ax;
                        if (z4) {
                            listView = this.a.d;
                            int lastVisiblePosition = listView.getLastVisiblePosition();
                            listView2 = this.a.d;
                            if (lastVisiblePosition != listView2.getCount() - 1) {
                                linearLayout2 = this.a.B;
                                translateAnimation5 = this.a.at;
                                linearLayout2.startAnimation(translateAnimation5);
                            }
                        }
                    }
                }
            } else if (f2 < -3.0f && f2 > -50.0f) {
                translateAnimation2 = this.a.au;
                if (translateAnimation2 != null) {
                    z = this.a.aw;
                    if (!z) {
                        z2 = this.a.ax;
                        if (!z2) {
                            linearLayout = this.a.B;
                            translateAnimation3 = this.a.au;
                            linearLayout.startAnimation(translateAnimation3);
                        }
                    }
                }
            }
        }
        this.a.ay = i2;
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }
}
