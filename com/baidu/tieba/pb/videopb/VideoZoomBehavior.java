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
    public VideoContainerLayout f19536a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPbViewModel f19537b;

    public VideoZoomBehavior() {
    }

    public final VideoContainerLayout a(ViewGroup viewGroup) {
        VideoContainerLayout a2;
        if (viewGroup instanceof VideoContainerLayout) {
            return (VideoContainerLayout) viewGroup;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: c */
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int i4, int i5, int i6) {
        super.onNestedScroll(coordinatorLayout, appBarLayout, view, i2, i3, i4, i5, i6);
        d(i5, appBarLayout, view, i6);
    }

    public final void d(int i2, AppBarLayout appBarLayout, View view, int i3) {
        if (i3 == 1) {
            int topAndBottomOffset = getTopAndBottomOffset();
            if ((i2 >= 0 || topAndBottomOffset != 0) && (i2 <= 0 || topAndBottomOffset != (-appBarLayout.getTotalScrollRange()))) {
                return;
            }
            ViewCompat.stopNestedScroll(view, 1);
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.ViewOffsetBehavior
    public boolean setTopAndBottomOffset(int i2) {
        VideoContainerLayout videoContainerLayout;
        ViewGroup.LayoutParams layoutParams;
        boolean topAndBottomOffset = super.setTopAndBottomOffset(i2);
        if (topAndBottomOffset && (videoContainerLayout = this.f19536a) != null && (layoutParams = videoContainerLayout.getLayoutParams()) != null) {
            int maxHeight = this.f19536a.getMaxHeight() + i2;
            if (layoutParams.height != maxHeight) {
                layoutParams.height = maxHeight;
                this.f19536a.setLayoutParams(layoutParams);
            }
            if (this.f19537b == null && (this.f19536a.getContext() instanceof PbActivity)) {
                this.f19537b = (VideoPbViewModel) ViewModelProviders.of((PbActivity) this.f19536a.getContext()).get(VideoPbViewModel.class);
            }
            VideoPbViewModel videoPbViewModel = this.f19537b;
            if (videoPbViewModel != null) {
                if (i2 > -5) {
                    MutableLiveData<Boolean> e2 = videoPbViewModel.e();
                    if (e2 == null || e2.getValue() == null || !e2.getValue().booleanValue()) {
                        this.f19537b.t(true);
                    }
                } else {
                    MutableLiveData<Boolean> e3 = videoPbViewModel.e();
                    if (e3 == null || e3.getValue() == null || e3.getValue().booleanValue()) {
                        this.f19537b.t(false);
                    }
                }
            }
        }
        return topAndBottomOffset;
    }

    public VideoZoomBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2) {
        this.f19536a = a(appBarLayout);
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int[] iArr, int i4) {
        super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i2, i3, iArr, i4);
        d(i3, appBarLayout, view, i4);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, @NonNull View view2, int i2, int i3) {
        VideoContainerLayout a2 = a(appBarLayout);
        this.f19536a = a2;
        return (a2 == null || (i2 & 2) == 0) ? false : true;
    }
}
