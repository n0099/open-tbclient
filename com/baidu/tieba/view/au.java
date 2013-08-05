package com.baidu.tieba.view;

import android.support.v4.view.bq;
import android.view.View;
import com.baidu.tieba.util.NetWorkCore;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements bq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MultiImageView f1824a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(MultiImageView multiImageView) {
        this.f1824a = multiImageView;
    }

    @Override // android.support.v4.view.bq
    public void b(int i) {
        bq bqVar;
        bq bqVar2;
        bqVar = this.f1824a.g;
        if (bqVar != null) {
            bqVar2 = this.f1824a.g;
            bqVar2.b(i);
        }
    }

    @Override // android.support.v4.view.bq
    public void a(int i, float f, int i2) {
        bq bqVar;
        bq bqVar2;
        bqVar = this.f1824a.g;
        if (bqVar != null) {
            bqVar2 = this.f1824a.g;
            bqVar2.a(i, f, i2);
        }
    }

    @Override // android.support.v4.view.bq
    public void a_(int i) {
        GalleryViewPager galleryViewPager;
        GalleryViewPager galleryViewPager2;
        boolean z;
        bq bqVar;
        bq bqVar2;
        GalleryViewPager galleryViewPager3;
        GalleryViewPager galleryViewPager4;
        j imageView;
        GalleryViewPager galleryViewPager5;
        com.baidu.tieba.util.aj.e(getClass().getName(), "onPageSelected", "postion = " + String.valueOf(i));
        galleryViewPager = this.f1824a.e;
        View findViewWithTag = galleryViewPager.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof bg) && (imageView = ((bg) findViewWithTag).getImageView()) != null) {
            galleryViewPager5 = this.f1824a.e;
            galleryViewPager5.setSelectedView(imageView);
            imageView.o();
        }
        galleryViewPager2 = this.f1824a.e;
        int childCount = galleryViewPager2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            galleryViewPager4 = this.f1824a.e;
            View childAt = galleryViewPager4.getChildAt(i2);
            if (childAt != null && (childAt instanceof bg)) {
                ((bg) childAt).e();
            }
        }
        NetWorkCore.NetworkStateInfo c = NetWorkCore.c(this.f1824a.getContext());
        z = this.f1824a.l;
        if (z && (c == NetWorkCore.NetworkStateInfo.WIFI || c == NetWorkCore.NetworkStateInfo.ThreeG)) {
            for (int i3 = 0; i3 < childCount; i3++) {
                galleryViewPager3 = this.f1824a.e;
                View childAt2 = galleryViewPager3.getChildAt(i3);
                if (childAt2 != null && (childAt2 instanceof bg)) {
                    ((bg) childAt2).f();
                }
            }
        }
        bqVar = this.f1824a.g;
        if (bqVar != null) {
            bqVar2 = this.f1824a.g;
            bqVar2.a_(i);
        }
    }
}
