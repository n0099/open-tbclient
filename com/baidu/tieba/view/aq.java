package com.baidu.tieba.view;

import android.support.v4.view.bq;
import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements bq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MultiImageView f1852a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(MultiImageView multiImageView) {
        this.f1852a = multiImageView;
    }

    @Override // android.support.v4.view.bq
    public void b(int i) {
        bq bqVar;
        bq bqVar2;
        bqVar = this.f1852a.g;
        if (bqVar != null) {
            bqVar2 = this.f1852a.g;
            bqVar2.b(i);
        }
    }

    @Override // android.support.v4.view.bq
    public void a(int i, float f, int i2) {
        bq bqVar;
        bq bqVar2;
        bqVar = this.f1852a.g;
        if (bqVar != null) {
            bqVar2 = this.f1852a.g;
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
        com.baidu.tieba.util.aq.e(getClass().getName(), "onPageSelected", "postion = " + String.valueOf(i));
        galleryViewPager = this.f1852a.e;
        View findViewWithTag = galleryViewPager.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof bf) && (imageView = ((bf) findViewWithTag).getImageView()) != null) {
            galleryViewPager5 = this.f1852a.e;
            galleryViewPager5.setSelectedView(imageView);
            imageView.o();
        }
        galleryViewPager2 = this.f1852a.e;
        int childCount = galleryViewPager2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            galleryViewPager4 = this.f1852a.e;
            View childAt = galleryViewPager4.getChildAt(i2);
            if (childAt != null && (childAt instanceof bf)) {
                ((bf) childAt).e();
            }
        }
        UtilHelper.NetworkStateInfo i3 = UtilHelper.i(this.f1852a.getContext());
        z = this.f1852a.l;
        if (z && (i3 == UtilHelper.NetworkStateInfo.WIFI || i3 == UtilHelper.NetworkStateInfo.ThreeG)) {
            for (int i4 = 0; i4 < childCount; i4++) {
                galleryViewPager3 = this.f1852a.e;
                View childAt2 = galleryViewPager3.getChildAt(i4);
                if (childAt2 != null && (childAt2 instanceof bf)) {
                    ((bf) childAt2).f();
                }
            }
        }
        bqVar = this.f1852a.g;
        if (bqVar != null) {
            bqVar2 = this.f1852a.g;
            bqVar2.a_(i);
        }
    }
}
