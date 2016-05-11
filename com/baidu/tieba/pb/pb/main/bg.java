package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.gif.GifView;
/* loaded from: classes.dex */
class bg implements com.baidu.adp.lib.f.c<GifView> {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: awX */
    public GifView dE() {
        return new GifView(this.djE.getPageContext().getPageActivity());
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
