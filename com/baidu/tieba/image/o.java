package com.baidu.tieba.image;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
/* loaded from: classes.dex */
class o extends BroadcastReceiver {
    final /* synthetic */ ImageViewerActivity this$0;

    private o(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(ImageViewerActivity imageViewerActivity, o oVar) {
        this(imageViewerActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ImageViewerActivity.c(this.this$0, intent.getBooleanExtra(ImageViewerConfig.HAS_NEXT, false));
        ImageViewerActivity.a(this.this$0, intent.getStringExtra(ImageViewerConfig.NEXT_TILE));
        ImageViewerActivity.a(this.this$0, intent.getStringArrayListExtra(ImageViewerConfig.URL));
        ImageViewerActivity.b(this.this$0, intent.getIntExtra(ImageViewerConfig.COUNT, -1));
        int intExtra = intent.getIntExtra(ImageViewerConfig.INDEX, -1);
        ImageViewerActivity.e(this.this$0).setUrlData(ImageViewerActivity.o(this.this$0));
        ImageViewerActivity.e(this.this$0).setNextTitle(ImageViewerActivity.r(this.this$0));
        ImageViewerActivity.e(this.this$0).setHasNext(ImageViewerActivity.s(this.this$0));
        if (intExtra >= 0) {
            ImageViewerActivity.a(this.this$0, intExtra);
            ImageViewerActivity.e(this.this$0).setCurrentItem(ImageViewerActivity.t(this.this$0), false);
        }
    }
}
