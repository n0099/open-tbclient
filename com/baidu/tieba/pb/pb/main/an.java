package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.gif.GifView;
/* loaded from: classes.dex */
class an implements com.baidu.adp.lib.e.c<GifView> {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: agb */
    public GifView ha() {
        return new GifView(this.cjN.getPageContext().getPageActivity());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: g */
    public void l(GifView gifView) {
        gifView.onDestroy();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: h */
    public GifView m(GifView gifView) {
        return gifView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: i */
    public GifView n(GifView gifView) {
        return gifView;
    }
}
