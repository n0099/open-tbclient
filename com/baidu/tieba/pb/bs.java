package com.baidu.tieba.pb;

import com.baidu.tbadk.gif.GifView;
/* loaded from: classes.dex */
final class bs implements com.baidu.adp.lib.d.c<GifView> {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ GifView a() {
        com.baidu.adp.lib.util.e.e("NewPbActivity", "GifViewPool", "makeObject");
        return new GifView(this.a);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ void a(GifView gifView) {
        com.baidu.adp.lib.util.e.e("NewPbActivity", "GifViewPool", "destroyObject");
        gifView.c();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ GifView b(GifView gifView) {
        GifView gifView2 = gifView;
        com.baidu.adp.lib.util.e.e("NewPbActivity", "GifViewPool", "activateObject");
        return gifView2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ GifView c(GifView gifView) {
        GifView gifView2 = gifView;
        com.baidu.adp.lib.util.e.e("NewPbActivity", "GifViewPool", "passivateObject");
        return gifView2;
    }
}
