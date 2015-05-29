package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.gif.GifView;
/* loaded from: classes.dex */
class al implements com.baidu.adp.lib.e.c<GifView> {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: abe */
    public GifView hk() {
        return new GifView(this.bKT.getPageContext().getPageActivity());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: g */
    public void k(GifView gifView) {
        gifView.onDestroy();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: h */
    public GifView l(GifView gifView) {
        return gifView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: i */
    public GifView m(GifView gifView) {
        return gifView;
    }
}
