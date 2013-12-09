package com.baidu.tieba.pb;

import android.content.Intent;
import com.baidu.cloudsdk.social.core.SocialConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tieba.view.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImageActivity f2271a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ImageActivity imageActivity) {
        this.f2271a = imageActivity;
    }

    @Override // com.baidu.tieba.view.a
    public void a(int i) {
        boolean z;
        a aVar;
        z = this.f2271a.B;
        if (z) {
            Intent intent = new Intent("com.baidu.tieba.broadcast.imagepb.pagechanged");
            intent.putExtra("index", -1);
            intent.putExtra(SocialConstants.PARAM_STATE, i);
            this.f2271a.sendBroadcast(intent);
        } else if (i == 0) {
            aVar = this.f2271a.u;
            aVar.b();
        }
    }
}
