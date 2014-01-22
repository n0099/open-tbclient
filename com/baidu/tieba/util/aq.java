package com.baidu.tieba.util;

import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
final class aq implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ ListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ListView listView) {
        this.a = listView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        if (dVar != null) {
            ImageView imageView = (ImageView) this.a.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                imageView.setImageBitmap(dVar.h());
                imageView = (ImageView) this.a.findViewWithTag(str);
            }
        }
    }
}
