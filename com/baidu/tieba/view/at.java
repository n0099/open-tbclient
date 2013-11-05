package com.baidu.tieba.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MultiImageView f2514a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(MultiImageView multiImageView) {
        this.f2514a = multiImageView;
    }

    @Override // com.baidu.tieba.view.o
    public void a(k kVar) {
        GalleryViewPager galleryViewPager;
        boolean z;
        GalleryViewPager galleryViewPager2;
        GalleryViewPager galleryViewPager3;
        galleryViewPager = this.f2514a.e;
        if (kVar == galleryViewPager.getCurrentView()) {
            z = this.f2514a.l;
            if (z) {
                galleryViewPager2 = this.f2514a.e;
                int childCount = galleryViewPager2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    galleryViewPager3 = this.f2514a.e;
                    View childAt = galleryViewPager3.getChildAt(i);
                    if (childAt != null && (childAt instanceof bk) && ((bk) childAt).getImageView() != kVar) {
                        ((bk) childAt).d();
                    }
                }
            }
            kVar.e();
        }
    }
}
