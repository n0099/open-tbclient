package com.baidu.tieba.util;

import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
class as implements com.baidu.tbadk.imageManager.d {
    private final /* synthetic */ ListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ListView listView) {
        this.a = listView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar != null) {
            ImageView imageView = (ImageView) this.a.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                imageView.setImageBitmap(bVar.h());
                imageView = (ImageView) this.a.findViewWithTag(str);
            }
        }
    }
}
