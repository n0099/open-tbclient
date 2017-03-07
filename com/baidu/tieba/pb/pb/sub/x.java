package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.gif.GifView;
/* loaded from: classes.dex */
class x implements com.baidu.adp.lib.e.c<GifView> {
    final /* synthetic */ NewSubPbActivity euQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(NewSubPbActivity newSubPbActivity) {
        this.euQ = newSubPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: aKP */
    public GifView fF() {
        return new GifView(this.euQ.getPageContext().getPageActivity());
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
