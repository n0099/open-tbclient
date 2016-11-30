package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.gif.GifView;
/* loaded from: classes.dex */
class x implements com.baidu.adp.lib.f.c<GifView> {
    final /* synthetic */ NewSubPbActivity eEs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(NewSubPbActivity newSubPbActivity) {
        this.eEs = newSubPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: aPI */
    public GifView ez() {
        return new GifView(this.eEs.getPageContext().getPageActivity());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: g */
    public void o(GifView gifView) {
        gifView.onDestroy();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: h */
    public GifView p(GifView gifView) {
        return gifView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: i */
    public GifView q(GifView gifView) {
        return gifView;
    }
}
