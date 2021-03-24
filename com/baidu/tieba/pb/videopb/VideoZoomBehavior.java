package com.baidu.tieba.pb.videopb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.google.android.material.appbar.AppBarLayout;
/* loaded from: classes5.dex */
public class VideoZoomBehavior extends AppBarLayout.Behavior {

    /* renamed from: a  reason: collision with root package name */
    public VideoContainerLayout f20067a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPbViewModel f20068b;

    public VideoZoomBehavior() {
    }

    public final VideoContainerLayout a(ViewGroup viewGroup) {
        VideoContainerLayout a2;
        if (viewGroup instanceof VideoContainerLayout) {
            return (VideoContainerLayout) viewGroup;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof ViewGroup) && (a2 = a((ViewGroup) childAt)) != null) {
                return a2;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: b */
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.ViewOffsetBehavior
    public boolean setTopAndBottomOffset(int i) {
        VideoContainerLayout videoContainerLayout;
        ViewGroup.LayoutParams layoutParams;
        boolean topAndBottomOffset = super.setTopAndBottomOffset(i);
        if (topAndBottomOffset && (videoContainerLayout = this.f20067a) != null && (layoutParams = videoContainerLayout.getLayoutParams()) != null) {
            int maxHeight = this.f20067a.getMaxHeight() + i;
            if (layoutParams.height != maxHeight) {
                layoutParams.height = maxHeight;
                this.f20067a.setLayoutParams(layoutParams);
            }
            if (this.f20068b == null && (this.f20067a.getContext() instanceof PbActivity)) {
                this.f20068b = (VideoPbViewModel) ViewModelProviders.of((PbActivity) this.f20067a.getContext()).get(VideoPbViewModel.class);
            }
            VideoPbViewModel videoPbViewModel = this.f20068b;
            if (videoPbViewModel != null) {
                if (i > -5) {
                    MutableLiveData<Boolean> e2 = videoPbViewModel.e();
                    if (e2 == null || e2.getValue() == null || !e2.getValue().booleanValue()) {
                        this.f20068b.t(true);
                    }
                } else {
                    MutableLiveData<Boolean> e3 = videoPbViewModel.e();
                    if (e3 == null || e3.getValue() == null || e3.getValue().booleanValue()) {
                        this.f20068b.t(false);
                    }
                }
            }
        }
        return topAndBottomOffset;
    }

    public final void stopNestedScrollIfNeeded(int i, AppBarLayout appBarLayout, View view, int i2) {
        if (i2 == 1) {
            int topAndBottomOffset = getTopAndBottomOffset();
            if ((i >= 0 || topAndBottomOffset != 0) && (i <= 0 || topAndBottomOffset != (-appBarLayout.getTotalScrollRange()))) {
                return;
            }
            ViewCompat.stopNestedScroll(view, 1);
        }
    }

    public VideoZoomBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        this.f20067a = a(appBarLayout);
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        stopNestedScrollIfNeeded(i2, appBarLayout, view, i3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
        super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5);
        stopNestedScrollIfNeeded(i4, appBarLayout, view, i5);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, @NonNull View view2, int i, int i2) {
        VideoContainerLayout a2 = a(appBarLayout);
        this.f20067a = a2;
        return (a2 == null || (i & 2) == 0) ? false : true;
    }
}
