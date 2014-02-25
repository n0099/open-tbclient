package com.baidu.tieba.pb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.cloudsdk.social.core.SocialConstants;
/* loaded from: classes.dex */
class i extends BroadcastReceiver {
    final /* synthetic */ ImageActivity a;

    private i(ImageActivity imageActivity) {
        this.a = imageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(ImageActivity imageActivity, i iVar) {
        this(imageActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ImageActivity.a(this.a, intent.getBooleanExtra("hasnext", false));
        ImageActivity.a(this.a, intent.getStringExtra("nexttitle"));
        ImageActivity.a(this.a, intent.getStringArrayListExtra(SocialConstants.PARAM_URL));
        ImageActivity.a(this.a, intent.getIntExtra("count", -1));
        int intExtra = intent.getIntExtra("index", -1);
        ImageActivity.c(this.a).setUrlData(ImageActivity.d(this.a));
        ImageActivity.c(this.a).setNextTitle(ImageActivity.e(this.a));
        ImageActivity.c(this.a).setHasNext(ImageActivity.f(this.a));
        if (intExtra >= 0) {
            ImageActivity.b(this.a, intExtra);
            ImageActivity.c(this.a).a(ImageActivity.g(this.a), false);
        }
    }
}
