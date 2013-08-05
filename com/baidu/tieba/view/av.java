package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MultiImageView f1825a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(MultiImageView multiImageView) {
        this.f1825a = multiImageView;
    }

    @Override // com.baidu.tieba.view.o
    public void a(j jVar, boolean z, boolean z2) {
        GalleryViewPager galleryViewPager;
        galleryViewPager = this.f1825a.e;
        if (galleryViewPager.getSelectedView() == jVar) {
            this.f1825a.setZoomButton(jVar);
        }
    }
}
