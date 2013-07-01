package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements m {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MultiImageView f1508a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(MultiImageView multiImageView) {
        this.f1508a = multiImageView;
    }

    @Override // com.baidu.tieba.view.m
    public void a(h hVar, boolean z, boolean z2) {
        GalleryViewPager galleryViewPager;
        galleryViewPager = this.f1508a.e;
        if (galleryViewPager.getSelectedView() == hVar) {
            this.f1508a.setZoomButton(hVar);
        }
    }
}
