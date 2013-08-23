package com.baidu.tieba.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements n {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MultiImageView f1854a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(MultiImageView multiImageView) {
        this.f1854a = multiImageView;
    }

    @Override // com.baidu.tieba.view.n
    public void a(j jVar) {
        GalleryViewPager galleryViewPager;
        boolean z;
        GalleryViewPager galleryViewPager2;
        GalleryViewPager galleryViewPager3;
        galleryViewPager = this.f1854a.e;
        if (jVar == galleryViewPager.getCurrentView()) {
            z = this.f1854a.l;
            if (z) {
                galleryViewPager2 = this.f1854a.e;
                int childCount = galleryViewPager2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    galleryViewPager3 = this.f1854a.e;
                    View childAt = galleryViewPager3.getChildAt(i);
                    if (childAt != null && (childAt instanceof bf) && ((bf) childAt).getImageView() != jVar) {
                        ((bf) childAt).d();
                    }
                }
            }
            jVar.e();
        }
    }
}
