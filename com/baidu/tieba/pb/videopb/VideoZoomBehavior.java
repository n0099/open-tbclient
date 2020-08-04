package com.baidu.tieba.pb.videopb;

import android.arch.lifecycle.p;
import android.arch.lifecycle.y;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes16.dex */
public class VideoZoomBehavior extends AppBarLayout.Behavior {
    private VideoContainerLayout kFR;
    private e kkm;

    public VideoZoomBehavior() {
    }

    public VideoZoomBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, @NonNull View view2, int i, int i2) {
        this.kFR = cv(appBarLayout);
        return (this.kFR == null || (i & 2) == 0) ? false : true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.HeaderBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    /* renamed from: a */
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, MotionEvent motionEvent) {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        this.kFR = cv(appBarLayout);
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.ViewOffsetBehavior
    public boolean setTopAndBottomOffset(int i) {
        ViewGroup.LayoutParams layoutParams;
        boolean topAndBottomOffset = super.setTopAndBottomOffset(i);
        if (topAndBottomOffset && this.kFR != null && (layoutParams = this.kFR.getLayoutParams()) != null) {
            int maxHeight = this.kFR.getMaxHeight() + i;
            if (layoutParams.height != maxHeight) {
                layoutParams.height = maxHeight;
                this.kFR.setLayoutParams(layoutParams);
            }
            if (this.kkm == null && (this.kFR.getContext() instanceof PbActivity)) {
                this.kkm = (e) y.b((PbActivity) this.kFR.getContext()).l(e.class);
            }
            if (this.kkm != null) {
                if (i > -5) {
                    p<Boolean> cTF = this.kkm.cTF();
                    if (cTF == null || cTF.getValue() == null || !cTF.getValue().booleanValue()) {
                        this.kkm.tx(true);
                    }
                } else {
                    p<Boolean> cTF2 = this.kkm.cTF();
                    if (cTF2 == null || cTF2.getValue() == null || cTF2.getValue().booleanValue()) {
                        this.kkm.tx(false);
                    }
                }
            }
        }
        return topAndBottomOffset;
    }

    private VideoContainerLayout cv(ViewGroup viewGroup) {
        VideoContainerLayout cv;
        if (viewGroup instanceof VideoContainerLayout) {
            return (VideoContainerLayout) viewGroup;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof ViewGroup) && (cv = cv((ViewGroup) childAt)) != null) {
                return cv;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
        super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5);
        a(i4, appBarLayout, view, i5);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        a(i2, appBarLayout, view, i3);
    }

    private void a(int i, AppBarLayout appBarLayout, View view, int i2) {
        if (i2 == 1) {
            int topAndBottomOffset = getTopAndBottomOffset();
            if ((i < 0 && topAndBottomOffset == 0) || (i > 0 && topAndBottomOffset == (-appBarLayout.getTotalScrollRange()))) {
                ViewCompat.stopNestedScroll(view, 1);
            }
        }
    }
}
