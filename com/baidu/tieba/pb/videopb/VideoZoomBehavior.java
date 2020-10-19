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
/* loaded from: classes22.dex */
public class VideoZoomBehavior extends AppBarLayout.Behavior {
    private e kXt;
    private VideoContainerLayout ltB;

    public VideoZoomBehavior() {
    }

    public VideoZoomBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, @NonNull View view2, int i, int i2) {
        this.ltB = cu(appBarLayout);
        return (this.ltB == null || (i & 2) == 0) ? false : true;
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
        this.ltB = cu(appBarLayout);
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    @Override // android.support.design.widget.AppBarLayout.Behavior, android.support.design.widget.ViewOffsetBehavior
    public boolean setTopAndBottomOffset(int i) {
        ViewGroup.LayoutParams layoutParams;
        boolean topAndBottomOffset = super.setTopAndBottomOffset(i);
        if (topAndBottomOffset && this.ltB != null && (layoutParams = this.ltB.getLayoutParams()) != null) {
            int maxHeight = this.ltB.getMaxHeight() + i;
            if (layoutParams.height != maxHeight) {
                layoutParams.height = maxHeight;
                this.ltB.setLayoutParams(layoutParams);
            }
            if (this.kXt == null && (this.ltB.getContext() instanceof PbActivity)) {
                this.kXt = (e) y.b((PbActivity) this.ltB.getContext()).l(e.class);
            }
            if (this.kXt != null) {
                if (i > -5) {
                    p<Boolean> dlL = this.kXt.dlL();
                    if (dlL == null || dlL.getValue() == null || !dlL.getValue().booleanValue()) {
                        this.kXt.uX(true);
                    }
                } else {
                    p<Boolean> dlL2 = this.kXt.dlL();
                    if (dlL2 == null || dlL2.getValue() == null || dlL2.getValue().booleanValue()) {
                        this.kXt.uX(false);
                    }
                }
            }
        }
        return topAndBottomOffset;
    }

    private VideoContainerLayout cu(ViewGroup viewGroup) {
        VideoContainerLayout cu;
        if (viewGroup instanceof VideoContainerLayout) {
            return (VideoContainerLayout) viewGroup;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof ViewGroup) && (cu = cu((ViewGroup) childAt)) != null) {
                return cu;
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
