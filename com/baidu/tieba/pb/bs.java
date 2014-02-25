package com.baidu.tieba.pb;

import com.baidu.tbadk.gif.GifView;
/* loaded from: classes.dex */
class bs implements com.baidu.adp.lib.d.c<GifView> {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    /* renamed from: b */
    public GifView a() {
        com.baidu.adp.lib.util.f.e("NewPbActivity", "GifViewPool", "makeObject");
        return new GifView(this.a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public void a(GifView gifView) {
        com.baidu.adp.lib.util.f.e("NewPbActivity", "GifViewPool", "destroyObject");
        gifView.e();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public GifView b(GifView gifView) {
        com.baidu.adp.lib.util.f.e("NewPbActivity", "GifViewPool", "activateObject");
        return gifView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public GifView c(GifView gifView) {
        com.baidu.adp.lib.util.f.e("NewPbActivity", "GifViewPool", "passivateObject");
        return gifView;
    }
}
