package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements z {
    final /* synthetic */ MultiImageView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(MultiImageView multiImageView) {
        this.a = multiImageView;
    }

    @Override // com.baidu.tieba.view.z
    public void a(u uVar, boolean z, boolean z2) {
        GalleryViewPager galleryViewPager;
        galleryViewPager = this.a.e;
        if (galleryViewPager.getSelectedView() == uVar) {
            this.a.setZoomButton(uVar);
        }
    }
}
