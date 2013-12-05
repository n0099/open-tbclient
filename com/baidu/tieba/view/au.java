package com.baidu.tieba.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements p {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MultiImageView f2665a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(MultiImageView multiImageView) {
        this.f2665a = multiImageView;
    }

    @Override // com.baidu.tieba.view.p
    public void a(l lVar) {
        GalleryViewPager galleryViewPager;
        boolean z;
        GalleryViewPager galleryViewPager2;
        GalleryViewPager galleryViewPager3;
        galleryViewPager = this.f2665a.e;
        if (lVar == galleryViewPager.getCurrentView()) {
            z = this.f2665a.l;
            if (z) {
                galleryViewPager2 = this.f2665a.e;
                int childCount = galleryViewPager2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    galleryViewPager3 = this.f2665a.e;
                    View childAt = galleryViewPager3.getChildAt(i);
                    if (childAt != null && (childAt instanceof bo) && ((bo) childAt).getImageView() != lVar) {
                        ((bo) childAt).d();
                    }
                }
            }
            lVar.e();
        }
    }
}
