package com.baidu.tieba.pb.main;

import com.baidu.tbadk.gif.GifView;
/* loaded from: classes.dex */
final class aj implements com.baidu.adp.lib.d.c<GifView> {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ GifView a() {
        com.baidu.adp.lib.util.f.e("PbActivity", "GifViewPool", "makeObject");
        return new GifView(this.a);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ void a(GifView gifView) {
        com.baidu.adp.lib.util.f.e("PbActivity", "GifViewPool", "destroyObject");
        gifView.c();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ GifView b(GifView gifView) {
        GifView gifView2 = gifView;
        com.baidu.adp.lib.util.f.e("PbActivity", "GifViewPool", "activateObject");
        return gifView2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ GifView c(GifView gifView) {
        GifView gifView2 = gifView;
        com.baidu.adp.lib.util.f.e("PbActivity", "GifViewPool", "passivateObject");
        return gifView2;
    }
}
