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
/* loaded from: classes2.dex */
public class VideoZoomBehavior extends AppBarLayout.Behavior {
    private VideoPbViewModel lNx;
    private VideoContainerLayout mkp;

    public VideoZoomBehavior() {
    }

    public VideoZoomBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, @NonNull View view2, int i, int i2) {
        this.mkp = cJ(appBarLayout);
        return (this.mkp == null || (i & 2) == 0) ? false : true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: a */
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, MotionEvent motionEvent) {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        this.mkp = cJ(appBarLayout);
        return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.ViewOffsetBehavior
    public boolean setTopAndBottomOffset(int i) {
        ViewGroup.LayoutParams layoutParams;
        boolean topAndBottomOffset = super.setTopAndBottomOffset(i);
        if (topAndBottomOffset && this.mkp != null && (layoutParams = this.mkp.getLayoutParams()) != null) {
            int maxHeight = this.mkp.getMaxHeight() + i;
            if (layoutParams.height != maxHeight) {
                layoutParams.height = maxHeight;
                this.mkp.setLayoutParams(layoutParams);
            }
            if (this.lNx == null && (this.mkp.getContext() instanceof PbActivity)) {
                this.lNx = (VideoPbViewModel) ViewModelProviders.of((PbActivity) this.mkp.getContext()).get(VideoPbViewModel.class);
            }
            if (this.lNx != null) {
                if (i > -5) {
                    MutableLiveData<Boolean> duG = this.lNx.duG();
                    if (duG == null || duG.getValue() == null || !duG.getValue().booleanValue()) {
                        this.lNx.wr(true);
                    }
                } else {
                    MutableLiveData<Boolean> duG2 = this.lNx.duG();
                    if (duG2 == null || duG2.getValue() == null || duG2.getValue().booleanValue()) {
                        this.lNx.wr(false);
                    }
                }
            }
        }
        return topAndBottomOffset;
    }

    private VideoContainerLayout cJ(ViewGroup viewGroup) {
        VideoContainerLayout cJ;
        if (viewGroup instanceof VideoContainerLayout) {
            return (VideoContainerLayout) viewGroup;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof ViewGroup) && (cJ = cJ((ViewGroup) childAt)) != null) {
                return cJ;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
        super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5);
        stopNestedScrollIfNeeded(i4, appBarLayout, view, i5);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        stopNestedScrollIfNeeded(i2, appBarLayout, view, i3);
    }

    private void stopNestedScrollIfNeeded(int i, AppBarLayout appBarLayout, View view, int i2) {
        if (i2 == 1) {
            int topAndBottomOffset = getTopAndBottomOffset();
            if ((i < 0 && topAndBottomOffset == 0) || (i > 0 && topAndBottomOffset == (-appBarLayout.getTotalScrollRange()))) {
                ViewCompat.stopNestedScroll(view, 1);
            }
        }
    }
}
