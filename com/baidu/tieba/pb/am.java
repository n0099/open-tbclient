package com.baidu.tieba.pb;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
class am implements com.baidu.tieba.c.d {
    final /* synthetic */ ak a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ak akVar) {
        this.a = akVar;
    }

    @Override // com.baidu.tieba.c.d
    public void a(Bitmap bitmap, String str, boolean z) {
        PbActivity pbActivity;
        ListView listView;
        PbActivity pbActivity2;
        ListView listView2;
        if (bitmap != null) {
            pbActivity = this.a.a;
            listView = pbActivity.d;
            ImageView imageView = (ImageView) listView.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                imageView.setImageBitmap(bitmap);
                pbActivity2 = this.a.a;
                listView2 = pbActivity2.d;
                imageView = (ImageView) listView2.findViewWithTag(str);
            }
        }
    }
}
