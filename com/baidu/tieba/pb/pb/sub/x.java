package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.gif.GifView;
/* loaded from: classes.dex */
class x implements com.baidu.adp.lib.e.c<GifView> {
    final /* synthetic */ NewSubPbActivity esV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(NewSubPbActivity newSubPbActivity) {
        this.esV = newSubPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: aKV */
    public GifView fK() {
        return new GifView(this.esV.getPageContext().getPageActivity());
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
