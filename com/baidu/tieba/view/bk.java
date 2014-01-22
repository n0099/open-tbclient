package com.baidu.tieba.view;

import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements android.support.v4.view.bq {
    final /* synthetic */ MultiImageView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(MultiImageView multiImageView) {
        this.a = multiImageView;
    }

    @Override // android.support.v4.view.bq
    public void b(int i) {
        android.support.v4.view.bq bqVar;
        android.support.v4.view.bq bqVar2;
        bqVar = this.a.g;
        if (bqVar != null) {
            bqVar2 = this.a.g;
            bqVar2.b(i);
        }
    }

    @Override // android.support.v4.view.bq
    public void a(int i, float f, int i2) {
        android.support.v4.view.bq bqVar;
        android.support.v4.view.bq bqVar2;
        bqVar = this.a.g;
        if (bqVar != null) {
            bqVar2 = this.a.g;
            bqVar2.a(i, f, i2);
        }
    }

    @Override // android.support.v4.view.bq
    public void a_(int i) {
        GalleryViewPager galleryViewPager;
        GalleryViewPager galleryViewPager2;
        boolean z;
        android.support.v4.view.bq bqVar;
        android.support.v4.view.bq bqVar2;
        GalleryViewPager galleryViewPager3;
        boolean z2;
        GalleryViewPager galleryViewPager4;
        u imageView;
        GalleryViewPager galleryViewPager5;
        com.baidu.adp.lib.g.e.e(getClass().getName(), "onPageSelected", "postion = " + String.valueOf(i));
        galleryViewPager = this.a.e;
        View findViewWithTag = galleryViewPager.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof cq) && (imageView = ((cq) findViewWithTag).getImageView()) != null) {
            galleryViewPager5 = this.a.e;
            galleryViewPager5.setSelectedView(imageView);
            imageView.o();
        }
        galleryViewPager2 = this.a.e;
        int childCount = galleryViewPager2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            galleryViewPager4 = this.a.e;
            View childAt = galleryViewPager4.getChildAt(i2);
            if (childAt != null && (childAt instanceof cq)) {
                ((cq) childAt).e();
            }
        }
        UtilHelper.NetworkStateInfo g = UtilHelper.g(this.a.getContext());
        z = this.a.l;
        if (z && (g == UtilHelper.NetworkStateInfo.WIFI || g == UtilHelper.NetworkStateInfo.ThreeG)) {
            for (int i3 = 0; i3 < childCount; i3++) {
                galleryViewPager3 = this.a.e;
                View childAt2 = galleryViewPager3.getChildAt(i3);
                if (childAt2 != null && (childAt2 instanceof cq)) {
                    z2 = this.a.o;
                    ((cq) childAt2).a(z2);
                }
            }
        }
        bqVar = this.a.g;
        if (bqVar != null) {
            bqVar2 = this.a.g;
            bqVar2.a_(i);
        }
    }
}
