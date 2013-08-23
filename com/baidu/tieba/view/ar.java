package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MultiImageView f1853a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(MultiImageView multiImageView) {
        this.f1853a = multiImageView;
    }

    @Override // com.baidu.tieba.view.o
    public void a(j jVar, boolean z, boolean z2) {
        GalleryViewPager galleryViewPager;
        galleryViewPager = this.f1853a.e;
        if (galleryViewPager.getSelectedView() == jVar) {
            this.f1853a.setZoomButton(jVar);
        }
    }
}
