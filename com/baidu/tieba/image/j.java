package com.baidu.tieba.image;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class j extends BroadcastReceiver {
    final /* synthetic */ ImageViewerActivity this$0;

    private j(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(ImageViewerActivity imageViewerActivity, j jVar) {
        this(imageViewerActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ImageViewerActivity.a(this.this$0, intent.getBooleanExtra("hasnext", false));
        ImageViewerActivity.a(this.this$0, intent.getStringExtra("nexttile"));
        ImageViewerActivity.a(this.this$0, intent.getStringArrayListExtra("url"));
        ImageViewerActivity.a(this.this$0, intent.getIntExtra("count", -1));
        int intExtra = intent.getIntExtra("index", -1);
        ImageViewerActivity.c(this.this$0).setUrlData(ImageViewerActivity.d(this.this$0));
        ImageViewerActivity.c(this.this$0).setNextTitle(ImageViewerActivity.e(this.this$0));
        ImageViewerActivity.c(this.this$0).setHasNext(ImageViewerActivity.f(this.this$0));
        if (intExtra >= 0) {
            ImageViewerActivity.b(this.this$0, intExtra);
            ImageViewerActivity.c(this.this$0).a(ImageViewerActivity.g(this.this$0), false);
        }
    }
}
