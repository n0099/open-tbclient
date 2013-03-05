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
