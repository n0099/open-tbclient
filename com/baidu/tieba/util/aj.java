package com.baidu.tieba.util;

import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
final class aj implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ListView f2580a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ListView listView) {
        this.f2580a = listView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar != null) {
            ImageView imageView = (ImageView) this.f2580a.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                imageView.setImageBitmap(eVar.f());
                imageView = (ImageView) this.f2580a.findViewWithTag(str);
            }
        }
    }
}
