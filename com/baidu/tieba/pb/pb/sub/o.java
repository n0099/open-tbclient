package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.gif.GifView;
/* loaded from: classes.dex */
class o implements com.baidu.adp.lib.f.c<GifView> {
    final /* synthetic */ NewSubPbActivity ejr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(NewSubPbActivity newSubPbActivity) {
        this.ejr = newSubPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: aIt */
    public GifView dE() {
        return new GifView(this.ejr.getPageContext().getPageActivity());
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
