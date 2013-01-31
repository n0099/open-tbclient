package com.baidu.tieba.pb;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
class al implements com.baidu.tieba.c.d {
    final /* synthetic */ ak a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.a = akVar;
    }

    @Override // com.baidu.tieba.c.d
    public void a(Bitmap bitmap, String str, boolean z) {
        PbActivity pbActivity;
        ListView listView;
        if (bitmap != null) {
            pbActivity = this.a.a;
            listView = pbActivity.d;
            ImageView imageView = (ImageView) listView.findViewWithTag(str);
            if (imageView != null) {
                imageView.invalidate();
            }
        }
    }
}
