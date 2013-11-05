package com.baidu.tieba.view;

import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements android.support.v4.view.bq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MultiImageView f2512a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(MultiImageView multiImageView) {
        this.f2512a = multiImageView;
    }

    @Override // android.support.v4.view.bq
    public void onPageScrollStateChanged(int i) {
        android.support.v4.view.bq bqVar;
        android.support.v4.view.bq bqVar2;
        bqVar = this.f2512a.g;
        if (bqVar != null) {
            bqVar2 = this.f2512a.g;
            bqVar2.onPageScrollStateChanged(i);
        }
    }

    @Override // android.support.v4.view.bq
    public void onPageScrolled(int i, float f, int i2) {
        android.support.v4.view.bq bqVar;
        android.support.v4.view.bq bqVar2;
        bqVar = this.f2512a.g;
        if (bqVar != null) {
            bqVar2 = this.f2512a.g;
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
        boolean z3;
        GalleryViewPager galleryViewPager4;
        k imageView;
        GalleryViewPager galleryViewPager5;
        com.baidu.tieba.util.be.e(getClass().getName(), "onPageSelected", "postion = " + String.valueOf(i));
        galleryViewPager = this.f2512a.e;
        View findViewWithTag = galleryViewPager.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof bk) && (imageView = ((bk) findViewWithTag).getImageView()) != null) {
            galleryViewPager5 = this.f2512a.e;
            galleryViewPager5.setSelectedView(imageView);
            imageView.o();
        }
        galleryViewPager2 = this.f2512a.e;
        int childCount = galleryViewPager2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            galleryViewPager4 = this.f2512a.e;
            View childAt = galleryViewPager4.getChildAt(i2);
            if (childAt != null && (childAt instanceof bk)) {
                ((bk) childAt).e();
            }
        }
        UtilHelper.NetworkStateInfo i3 = UtilHelper.i(this.f2512a.getContext());
        z = this.f2512a.l;
        if (z && (i3 == UtilHelper.NetworkStateInfo.WIFI || i3 == UtilHelper.NetworkStateInfo.ThreeG)) {
            for (int i4 = 0; i4 < childCount; i4++) {
                galleryViewPager3 = this.f2512a.e;
                View childAt2 = galleryViewPager3.getChildAt(i4);
                if (childAt2 != null && (childAt2 instanceof bk)) {
                    z2 = this.f2512a.n;
                    z3 = this.f2512a.o;
                    ((bk) childAt2).a(z2, z3);
                }
            }
        }
        bqVar = this.f2512a.g;
        if (bqVar != null) {
            bqVar2 = this.f2512a.g;
            bqVar2.onPageSelected(i);
        }
    }
}
