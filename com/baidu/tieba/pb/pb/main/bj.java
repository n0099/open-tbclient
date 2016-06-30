package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.gif.GifView;
/* loaded from: classes.dex */
class bj implements com.baidu.adp.lib.f.c<GifView> {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: aFi */
    public GifView dF() {
        return new GifView(this.dPF.getPageContext().getPageActivity());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: g */
    public void l(GifView gifView) {
        gifView.onDestroy();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: h */
    public GifView m(GifView gifView) {
        return gifView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: i */
    public GifView n(GifView gifView) {
        return gifView;
    }
}
