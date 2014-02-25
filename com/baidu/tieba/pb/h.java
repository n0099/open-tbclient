package com.baidu.tieba.pb;

import android.content.Intent;
import com.baidu.cloudsdk.social.core.SocialConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tieba.view.a {
    final /* synthetic */ ImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ImageActivity imageActivity) {
        this.a = imageActivity;
    }

    @Override // com.baidu.tieba.view.a
    public void a(int i) {
        boolean z;
        a aVar;
        z = this.a.B;
        if (z) {
            Intent intent = new Intent(com.baidu.tieba.data.i.c());
            intent.putExtra("index", -1);
            intent.putExtra(SocialConstants.PARAM_STATE, i);
            this.a.sendBroadcast(intent);
        } else if (i == 0) {
            aVar = this.a.u;
            aVar.b();
        }
    }
}
