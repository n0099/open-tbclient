package com.baidu.tieba.square;

import android.view.View;
import android.widget.ImageView;
/* loaded from: classes.dex */
class m implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f2428a;
    final /* synthetic */ i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar, View view) {
        this.b = iVar;
        this.f2428a = view;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        View findViewWithTag = this.f2428a.findViewWithTag(str);
        if (findViewWithTag instanceof ImageView) {
            ImageView imageView = (ImageView) findViewWithTag;
            imageView.setImageBitmap(eVar.f());
            imageView.invalidate();
        }
    }
}
