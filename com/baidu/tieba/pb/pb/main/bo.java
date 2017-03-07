package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.gif.GifView;
/* loaded from: classes.dex */
class bo implements com.baidu.adp.lib.e.c<GifView> {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(PbActivity pbActivity) {
        this.elO = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: aKP */
    public GifView fF() {
        return new GifView(this.elO.getPageContext().getPageActivity());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: g */
    public void o(GifView gifView) {
        gifView.onDestroy();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: h */
    public GifView p(GifView gifView) {
        return gifView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: i */
    public GifView q(GifView gifView) {
        return gifView;
    }
}
