package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements p {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MultiImageView f1980a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(MultiImageView multiImageView) {
        this.f1980a = multiImageView;
    }

    @Override // com.baidu.tieba.view.p
    public void a(k kVar, boolean z, boolean z2) {
        GalleryViewPager galleryViewPager;
        galleryViewPager = this.f1980a.e;
        if (galleryViewPager.getSelectedView() == kVar) {
            this.f1980a.setZoomButton(kVar);
        }
    }
}
