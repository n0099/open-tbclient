package com.baidu.tieba.pb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class i extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImageActivity f1533a;

    private i(ImageActivity imageActivity) {
        this.f1533a = imageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(ImageActivity imageActivity, i iVar) {
        this(imageActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ImageActivity.a(this.f1533a, intent.getBooleanExtra("hasnext", false));
        ImageActivity.a(this.f1533a, intent.getStringExtra("nexttitle"));
        ImageActivity.a(this.f1533a, intent.getStringArrayListExtra("url"));
        ImageActivity.a(this.f1533a, intent.getIntExtra("count", -1));
        int intExtra = intent.getIntExtra("index", -1);
        ImageActivity.c(this.f1533a).setUrlData(ImageActivity.d(this.f1533a));
        ImageActivity.c(this.f1533a).setNextTitle(ImageActivity.e(this.f1533a));
        ImageActivity.c(this.f1533a).setHasNext(ImageActivity.f(this.f1533a));
        if (intExtra >= 0) {
            ImageActivity.b(this.f1533a, intExtra);
            ImageActivity.c(this.f1533a).a(ImageActivity.g(this.f1533a), false);
        }
    }
}
