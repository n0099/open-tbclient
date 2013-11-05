package com.baidu.tieba.util;

import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
final class ad implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ListView f2416a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ListView listView) {
        this.f2416a = listView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        com.baidu.adp.lib.h.d.d("loadimg:" + str + " bitmap:" + (eVar == null));
        if (eVar != null) {
            ImageView imageView = (ImageView) this.f2416a.findViewWithTag(str);
            while (imageView != null) {
                com.baidu.adp.lib.h.d.d("--loadimg:" + str + " bitmap:" + (eVar == null));
                imageView.setTag(null);
                imageView.setImageBitmap(eVar.f());
                imageView = (ImageView) this.f2416a.findViewWithTag(str);
            }
        }
    }
}
