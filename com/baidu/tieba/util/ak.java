package com.baidu.tieba.util;

import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
final class ak implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ ListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ListView listView) {
        this.a = listView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar != null) {
            ImageView imageView = (ImageView) this.a.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                imageView.setImageBitmap(eVar.f());
                imageView = (ImageView) this.a.findViewWithTag(str);
            }
        }
    }
}
