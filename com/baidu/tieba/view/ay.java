package com.baidu.tieba.view;

import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements android.support.v4.view.bq {
    final /* synthetic */ MultiImageView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(MultiImageView multiImageView) {
        this.a = multiImageView;
    }

    @Override // android.support.v4.view.bq
    public void onPageScrollStateChanged(int i) {
        android.support.v4.view.bq bqVar;
        android.support.v4.view.bq bqVar2;
        bqVar = this.a.g;
        if (bqVar != null) {
            bqVar2 = this.a.g;
            bqVar2.onPageScrollStateChanged(i);
        }
    }

    @Override // android.support.v4.view.bq
    public void onPageScrolled(int i, float f, int i2) {
        android.support.v4.view.bq bqVar;
        android.support.v4.view.bq bqVar2;
        bqVar = this.a.g;
        if (bqVar != null) {
            bqVar2 = this.a.g;
            bqVar2.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.bq
    public void onPageSelected(int i) {
        GalleryViewPager galleryViewPager;
        GalleryViewPager galleryViewPager2;
        boolean z;
        android.support.v4.view.bq bqVar;
        android.support.v4.view.bq bqVar2;
        GalleryViewPager galleryViewPager3;
        boolean z2;
        GalleryViewPager galleryViewPager4;
        q imageView;
        GalleryViewPager galleryViewPager5;
        com.baidu.tieba.util.bo.e(getClass().getName(), "onPageSelected", "postion = " + String.valueOf(i));
        galleryViewPager = this.a.e;
        View findViewWithTag = galleryViewPager.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof ca) && (imageView = ((ca) findViewWithTag).getImageView()) != null) {
            galleryViewPager5 = this.a.e;
            galleryViewPager5.setSelectedView(imageView);
            imageView.o();
        }
        galleryViewPager2 = this.a.e;
        int childCount = galleryViewPager2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            galleryViewPager4 = this.a.e;
            View childAt = galleryViewPager4.getChildAt(i2);
            if (childAt != null && (childAt instanceof ca)) {
                ((ca) childAt).e();
            }
        }
        UtilHelper.NetworkStateInfo g = UtilHelper.g(this.a.getContext());
        z = this.a.l;
        if (z && (g == UtilHelper.NetworkStateInfo.WIFI || g == UtilHelper.NetworkStateInfo.ThreeG)) {
            for (int i3 = 0; i3 < childCount; i3++) {
                galleryViewPager3 = this.a.e;
                View childAt2 = galleryViewPager3.getChildAt(i3);
                if (childAt2 != null && (childAt2 instanceof ca)) {
                    z2 = this.a.o;
                    ((ca) childAt2).a(z2);
                }
            }
        }
        bqVar = this.a.g;
        if (bqVar != null) {
            bqVar2 = this.a.g;
            bqVar2.onPageSelected(i);
        }
    }
}
