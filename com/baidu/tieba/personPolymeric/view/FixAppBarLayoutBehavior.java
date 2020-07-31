package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes18.dex */
public class FixAppBarLayoutBehavior extends AppBarLayout.Behavior {
    public FixAppBarLayoutBehavior() {
    }

    public FixAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
