package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
class bm implements com.baidu.tieba.d.d {
    final /* synthetic */ bl a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bl blVar) {
        this.a = blVar;
    }

    @Override // com.baidu.tieba.d.d
    public void a(Bitmap bitmap, String str, boolean z) {
        PersonListActivity personListActivity;
        ListView listView;
        personListActivity = this.a.a;
        listView = personListActivity.d;
        ImageView imageView = (ImageView) listView.findViewWithTag(str);
        if (imageView != null && bitmap != null) {
            imageView.setImageBitmap(bitmap);
            imageView.setTag(null);
        }
    }
}
