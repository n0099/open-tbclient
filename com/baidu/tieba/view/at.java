package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements q {
    final /* synthetic */ MultiImageView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(MultiImageView multiImageView) {
        this.a = multiImageView;
    }

    @Override // com.baidu.tieba.view.q
    public void a(l lVar, boolean z, boolean z2) {
        GalleryViewPager galleryViewPager;
        galleryViewPager = this.a.e;
        if (galleryViewPager.getSelectedView() == lVar) {
            this.a.setZoomButton(lVar);
        }
    }
}
