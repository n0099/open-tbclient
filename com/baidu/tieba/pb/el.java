package com.baidu.tieba.pb;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class el implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ eb f2168a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public el(eb ebVar) {
        this.f2168a = ebVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar != null) {
            ImageView imageView = (ImageView) this.f2168a.c.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                eVar.a(imageView);
                imageView = (ImageView) this.f2168a.c.findViewWithTag(str);
            }
        }
    }
}
