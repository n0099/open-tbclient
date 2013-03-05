package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
class c implements com.baidu.tieba.c.d {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.tieba.c.d
    public void a(Bitmap bitmap, String str, boolean z) {
        AtListActivity atListActivity;
        ListView listView;
        atListActivity = this.a.a;
        listView = atListActivity.f;
        ImageView imageView = (ImageView) listView.findViewWithTag(str);
        if (imageView != null && bitmap != null) {
            imageView.setImageBitmap(bitmap);
            imageView.setTag(null);
        }
    }
}
