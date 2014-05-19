package com.baidu.tieba.pb.main;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.gif.GifView;
/* loaded from: classes.dex */
class aj implements com.baidu.adp.lib.d.c<GifView> {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    /* renamed from: b */
    public GifView a() {
        BdLog.d("PbActivity", "GifViewPool", "makeObject");
        return new GifView(this.a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public void a(GifView gifView) {
        BdLog.d("PbActivity", "GifViewPool", "destroyObject");
        gifView.e();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public GifView b(GifView gifView) {
        BdLog.d("PbActivity", "GifViewPool", "activateObject");
        return gifView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public GifView c(GifView gifView) {
        BdLog.d("PbActivity", "GifViewPool", "passivateObject");
        return gifView;
    }
}
