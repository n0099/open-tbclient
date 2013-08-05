package com.baidu.tieba.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements n {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MultiImageView f1826a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(MultiImageView multiImageView) {
        this.f1826a = multiImageView;
    }

    @Override // com.baidu.tieba.view.n
    public void a(j jVar) {
        GalleryViewPager galleryViewPager;
        boolean z;
        GalleryViewPager galleryViewPager2;
        GalleryViewPager galleryViewPager3;
        galleryViewPager = this.f1826a.e;
        if (jVar == galleryViewPager.getCurrentView()) {
            z = this.f1826a.l;
            if (z) {
                galleryViewPager2 = this.f1826a.e;
                int childCount = galleryViewPager2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    galleryViewPager3 = this.f1826a.e;
                    View childAt = galleryViewPager3.getChildAt(i);
                    if (childAt != null && (childAt instanceof bg) && ((bg) childAt).getImageView() != jVar) {
                        ((bg) childAt).d();
                    }
                }
            }
            jVar.e();
        }
    }
}
