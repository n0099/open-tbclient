package com.baidu.tieba.recommend;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ h a;
    private final /* synthetic */ View b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(h hVar, View view) {
        this.a = hVar;
        this.b = view;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        View findViewWithTag;
        if (this.b != null && (findViewWithTag = this.b.findViewWithTag(str)) != null) {
            findViewWithTag.invalidate();
        }
    }
}
