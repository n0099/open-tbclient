package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
class at implements com.baidu.tieba.c.d {
    final /* synthetic */ as a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.a = asVar;
    }

    @Override // com.baidu.tieba.c.d
    public void a(Bitmap bitmap, String str, boolean z) {
        PersonListActivity personListActivity;
        ListView listView;
        personListActivity = this.a.a;
        listView = personListActivity.c;
        ImageView imageView = (ImageView) listView.findViewWithTag(str);
        if (imageView == null || bitmap == null) {
            return;
        }
        imageView.setImageBitmap(bitmap);
        imageView.setTag(null);
    }
}
