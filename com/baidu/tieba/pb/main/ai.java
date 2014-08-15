package com.baidu.tieba.pb.main;

import com.baidu.tbadk.gif.GifView;
/* loaded from: classes.dex */
class ai implements com.baidu.adp.lib.d.c<GifView> {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    /* renamed from: b */
    public GifView a() {
        return new GifView(this.a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public void a(GifView gifView) {
        gifView.e();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public GifView b(GifView gifView) {
        return gifView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public GifView c(GifView gifView) {
        return gifView;
    }
}
