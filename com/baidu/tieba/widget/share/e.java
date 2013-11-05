package com.baidu.tieba.widget.share;

import com.baidu.cloudsdk.social.share.ShareContent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements f {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShareContent f2604a;
    final /* synthetic */ String b;
    final /* synthetic */ d c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, ShareContent shareContent, String str) {
        this.c = dVar;
        this.f2604a = shareContent;
        this.b = str;
    }

    @Override // com.baidu.tieba.widget.share.f
    public void a() {
        this.c.a(this.f2604a, this.b, false);
    }
}
