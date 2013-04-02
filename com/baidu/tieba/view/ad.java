package com.baidu.tieba.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements android.support.v4.view.aj {
    final /* synthetic */ MultiImageView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MultiImageView multiImageView) {
        this.a = multiImageView;
    }

    @Override // android.support.v4.view.aj
    public void b(int i) {
        android.support.v4.view.aj ajVar;
        android.support.v4.view.aj ajVar2;
        ajVar = this.a.g;
        if (ajVar != null) {
            ajVar2 = this.a.g;
            ajVar2.b(i);
        }
    }

    @Override // android.support.v4.view.aj
    public void a(int i, float f, int i2) {
        android.support.v4.view.aj ajVar;
        android.support.v4.view.aj ajVar2;
        ajVar = this.a.g;
        if (ajVar != null) {
            ajVar2 = this.a.g;
            ajVar2.a(i, f, i2);
        }
    }

    @Override // android.support.v4.view.aj
    public void a(int i) {
        GalleryViewPager galleryViewPager;
        GalleryViewPager galleryViewPager2;
        boolean z;
        android.support.v4.view.aj ajVar;
        android.support.v4.view.aj ajVar2;
        GalleryViewPager galleryViewPager3;
        GalleryViewPager galleryViewPager4;
        f imageView;
        GalleryViewPager galleryViewPager5;
        com.baidu.tieba.c.ag.e(getClass().getName(), "onPageSelected", "postion = " + String.valueOf(i));
        galleryViewPager = this.a.e;
        View findViewWithTag = galleryViewPager.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof ah) && (imageView = ((ah) findViewWithTag).getImageView()) != null) {
            galleryViewPager5 = this.a.e;
            galleryViewPager5.setSelectedView(imageView);
            imageView.o();
        }
        galleryViewPager2 = this.a.e;
        int childCount = galleryViewPager2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            galleryViewPager4 = this.a.e;
            View childAt = galleryViewPager4.getChildAt(i2);
            if (childAt != null && (childAt instanceof ah)) {
                ((ah) childAt).e();
            }
        }
        com.baidu.tieba.c.z c = com.baidu.tieba.c.w.c(this.a.getContext());
        z = this.a.l;
        if (z && (c == com.baidu.tieba.c.z.WIFI || c == com.baidu.tieba.c.z.ThreeG)) {
            for (int i3 = 0; i3 < childCount; i3++) {
                galleryViewPager3 = this.a.e;
                View childAt2 = galleryViewPager3.getChildAt(i3);
                if (childAt2 != null && (childAt2 instanceof ah)) {
                    ((ah) childAt2).f();
                }
            }
        }
        ajVar = this.a.g;
        if (ajVar != null) {
            ajVar2 = this.a.g;
            ajVar2.a(i);
        }
    }
}
