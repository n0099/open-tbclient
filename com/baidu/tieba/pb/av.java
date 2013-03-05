package com.baidu.tieba.pb;

import android.os.Handler;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements AbsListView.OnScrollListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.a.t;
        runnable = this.a.az;
        handler.removeCallbacks(runnable);
        handler2 = this.a.t;
        runnable2 = this.a.az;
        handler2.postDelayed(runnable2, 300L);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        boolean z;
        boolean z2;
        LinearLayout linearLayout;
        TranslateAnimation translateAnimation;
        boolean z3;
        boolean z4;
        LinearLayout linearLayout2;
        TranslateAnimation translateAnimation2;
        LinearLayout linearLayout3;
        if (i == 0) {
            if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                z3 = this.a.aw;
                if (!z3) {
                    z4 = this.a.av;
                    if (z4) {
                        linearLayout3 = this.a.C;
                        linearLayout3.clearAnimation();
                    }
                    linearLayout2 = this.a.C;
                    translateAnimation2 = this.a.at;
                    linearLayout2.startAnimation(translateAnimation2);
                    return;
                }
            }
            if (absListView.getFirstVisiblePosition() == 0) {
                z = this.a.aw;
                if (!z) {
                    z2 = this.a.av;
                    if (!z2) {
                        linearLayout = this.a.C;
                        translateAnimation = this.a.at;
                        linearLayout.startAnimation(translateAnimation);
                    }
                }
            }
        }
    }
}
