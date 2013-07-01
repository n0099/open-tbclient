package com.baidu.tieba.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements l {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MultiImageView f1509a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(MultiImageView multiImageView) {
        this.f1509a = multiImageView;
    }

    @Override // com.baidu.tieba.view.l
    public void a(h hVar) {
        GalleryViewPager galleryViewPager;
        boolean z;
        GalleryViewPager galleryViewPager2;
        GalleryViewPager galleryViewPager3;
        galleryViewPager = this.f1509a.e;
        if (hVar == galleryViewPager.getCurrentView()) {
            z = this.f1509a.l;
            if (z) {
                galleryViewPager2 = this.f1509a.e;
                int childCount = galleryViewPager2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    galleryViewPager3 = this.f1509a.e;
                    View childAt = galleryViewPager3.getChildAt(i);
                    if (childAt != null && (childAt instanceof aq) && ((aq) childAt).getImageView() != hVar) {
                        ((aq) childAt).d();
                    }
                }
            }
            hVar.e();
        }
    }
}
