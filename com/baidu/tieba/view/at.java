package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements q {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MultiImageView f2664a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(MultiImageView multiImageView) {
        this.f2664a = multiImageView;
    }

    @Override // com.baidu.tieba.view.q
    public void a(l lVar, boolean z, boolean z2) {
        GalleryViewPager galleryViewPager;
        galleryViewPager = this.f2664a.e;
        if (galleryViewPager.getSelectedView() == lVar) {
            this.f2664a.setZoomButton(lVar);
        }
    }
}
