package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
class be implements com.baidu.tieba.c.d {
    final /* synthetic */ bd a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bd bdVar) {
        this.a = bdVar;
    }

    @Override // com.baidu.tieba.c.d
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
