package com.baidu.tieba.write;

import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2655a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f2655a = bVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        ListView listView;
        listView = this.f2655a.f2648a.e;
        ImageView imageView = (ImageView) listView.findViewWithTag(str);
        if (imageView != null && eVar != null) {
            eVar.a(imageView);
            imageView.setTag(null);
        }
    }
}
