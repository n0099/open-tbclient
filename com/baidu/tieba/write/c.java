package com.baidu.tieba.write;

import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        ListView listView;
        listView = this.a.a.d;
        ImageView imageView = (ImageView) listView.findViewWithTag(str);
        if (imageView != null && dVar != null) {
            dVar.a(imageView);
            imageView.setTag(null);
        }
    }
}
