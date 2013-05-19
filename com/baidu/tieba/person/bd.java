package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
class bd implements com.baidu.tieba.d.d {
    final /* synthetic */ bc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bc bcVar) {
        this.a = bcVar;
    }

    @Override // com.baidu.tieba.d.d
    public void a(Bitmap bitmap, String str, boolean z) {
        PersonLbsActivity personLbsActivity;
        ListView listView;
        if (bitmap != null) {
            personLbsActivity = this.a.a;
            listView = personLbsActivity.c;
            ImageView imageView = (ImageView) listView.findViewWithTag(str);
            if (imageView != null) {
                imageView.invalidate();
            }
        }
    }
}
