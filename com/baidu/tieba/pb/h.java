package com.baidu.tieba.pb;

import android.content.Intent;
import com.baidu.cloudsdk.social.core.SocialConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tieba.view.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImageActivity f2136a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ImageActivity imageActivity) {
        this.f2136a = imageActivity;
    }

    @Override // com.baidu.tieba.view.a
    public void a_(int i) {
        boolean z;
        a aVar;
        z = this.f2136a.D;
        if (z) {
            Intent intent = new Intent("com.baidu.tieba.broadcast.imagepb.pagechanged");
            intent.putExtra("index", -1);
            intent.putExtra(SocialConstants.PARAM_STATE, i);
            this.f2136a.sendBroadcast(intent);
        } else if (i == 0) {
            aVar = this.f2136a.w;
            aVar.b();
        }
    }
}
