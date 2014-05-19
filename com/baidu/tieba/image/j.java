package com.baidu.tieba.image;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class j extends BroadcastReceiver {
    final /* synthetic */ ImageViewerActivity a;

    private j(ImageViewerActivity imageViewerActivity) {
        this.a = imageViewerActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(ImageViewerActivity imageViewerActivity, j jVar) {
        this(imageViewerActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ImageViewerActivity.a(this.a, intent.getBooleanExtra("hasnext", false));
        ImageViewerActivity.a(this.a, intent.getStringExtra("nexttile"));
        ImageViewerActivity.a(this.a, intent.getStringArrayListExtra("url"));
        ImageViewerActivity.a(this.a, intent.getIntExtra("count", -1));
        int intExtra = intent.getIntExtra("index", -1);
        ImageViewerActivity.c(this.a).setUrlData(ImageViewerActivity.d(this.a));
        ImageViewerActivity.c(this.a).setNextTitle(ImageViewerActivity.e(this.a));
        ImageViewerActivity.c(this.a).setHasNext(ImageViewerActivity.f(this.a));
        if (intExtra >= 0) {
            ImageViewerActivity.b(this.a, intExtra);
            ImageViewerActivity.c(this.a).a(ImageViewerActivity.g(this.a), false);
        }
    }
}
