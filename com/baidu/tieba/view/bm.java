package com.baidu.tieba.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements y {
    final /* synthetic */ MultiImageView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(MultiImageView multiImageView) {
        this.a = multiImageView;
    }

    @Override // com.baidu.tieba.view.y
    public void a(u uVar) {
        GalleryViewPager galleryViewPager;
        boolean z;
        GalleryViewPager galleryViewPager2;
        GalleryViewPager galleryViewPager3;
        galleryViewPager = this.a.e;
        if (uVar == galleryViewPager.getCurrentView()) {
            z = this.a.l;
            if (z) {
                galleryViewPager2 = this.a.e;
                int childCount = galleryViewPager2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    galleryViewPager3 = this.a.e;
                    View childAt = galleryViewPager3.getChildAt(i);
                    if (childAt != null && (childAt instanceof cq) && ((cq) childAt).getImageView() != uVar) {
                        ((cq) childAt).d();
                    }
                }
            }
            uVar.e();
        }
    }
}
