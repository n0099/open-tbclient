package com.baidu.tieba.util;

import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
class w implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ ListView f1930a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(ListView listView) {
        this.f1930a = listView;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.c cVar, String str, boolean z) {
        if (cVar != null) {
            ImageView imageView = (ImageView) this.f1930a.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                imageView.setImageBitmap(cVar.f());
                imageView = (ImageView) this.f1930a.findViewWithTag(str);
            }
        }
    }
}
