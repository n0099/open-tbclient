package com.baidu.tieba.view;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements ViewPager.OnPageChangeListener {
    final /* synthetic */ MultiImageView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(MultiImageView multiImageView) {
        this.a = multiImageView;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.a.g;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.a.g;
            onPageChangeListener2.onPageScrollStateChanged(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.a.g;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.a.g;
            onPageChangeListener2.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        av avVar;
        av avVar2;
        boolean z;
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        av avVar3;
        boolean z2;
        av avVar4;
        w imageView;
        av avVar5;
        com.baidu.adp.lib.util.f.e(getClass().getName(), "onPageSelected", "postion = " + String.valueOf(i));
        avVar = this.a.e;
        View findViewWithTag = avVar.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof cx) && (imageView = ((cx) findViewWithTag).getImageView()) != null) {
            avVar5 = this.a.e;
            avVar5.setSelectedView(imageView);
            imageView.o();
        }
        avVar2 = this.a.e;
        int childCount = avVar2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            avVar4 = this.a.e;
            View childAt = avVar4.getChildAt(i2);
            if (childAt != null && (childAt instanceof cx)) {
                ((cx) childAt).e();
            }
        }
        UtilHelper.NetworkStateInfo h = UtilHelper.h(this.a.getContext());
        z = this.a.l;
        if (z && (h == UtilHelper.NetworkStateInfo.WIFI || h == UtilHelper.NetworkStateInfo.ThreeG)) {
            for (int i3 = 0; i3 < childCount; i3++) {
                avVar3 = this.a.e;
                View childAt2 = avVar3.getChildAt(i3);
                if (childAt2 != null && (childAt2 instanceof cx)) {
                    z2 = this.a.o;
                    ((cx) childAt2).a(z2);
                }
            }
        }
        onPageChangeListener = this.a.g;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.a.g;
            onPageChangeListener2.onPageSelected(i);
        }
    }
}
