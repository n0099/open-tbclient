package com.baidu.tieba.widget.share;

import com.baidu.cloudsdk.social.share.ShareContent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements f {
    final /* synthetic */ ShareContent a;
    final /* synthetic */ String b;
    final /* synthetic */ d c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, ShareContent shareContent, String str) {
        this.c = dVar;
        this.a = shareContent;
        this.b = str;
    }

    @Override // com.baidu.tieba.widget.share.f
    public void a() {
        this.c.a(this.a, this.b, false);
    }
}
