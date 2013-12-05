package com.baidu.tieba.write;

import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2805a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f2805a = bVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        ListView listView;
        listView = this.f2805a.f2801a.d;
        ImageView imageView = (ImageView) listView.findViewWithTag(str);
        if (imageView != null && eVar != null) {
            eVar.a(imageView);
            imageView.setTag(null);
        }
    }
}
