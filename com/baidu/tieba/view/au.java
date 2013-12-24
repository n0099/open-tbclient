package com.baidu.tieba.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements p {
    final /* synthetic */ MultiImageView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(MultiImageView multiImageView) {
        this.a = multiImageView;
    }

    @Override // com.baidu.tieba.view.p
    public void a(l lVar) {
        GalleryViewPager galleryViewPager;
        boolean z;
        GalleryViewPager galleryViewPager2;
        GalleryViewPager galleryViewPager3;
        galleryViewPager = this.a.e;
        if (lVar == galleryViewPager.getCurrentView()) {
            z = this.a.l;
            if (z) {
                galleryViewPager2 = this.a.e;
                int childCount = galleryViewPager2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    galleryViewPager3 = this.a.e;
                    View childAt = galleryViewPager3.getChildAt(i);
                    if (childAt != null && (childAt instanceof bu) && ((bu) childAt).getImageView() != lVar) {
                        ((bu) childAt).d();
                    }
                }
            }
            lVar.e();
        }
    }
}
