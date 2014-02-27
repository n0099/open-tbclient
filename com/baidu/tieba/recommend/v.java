package com.baidu.tieba.recommend;

import android.view.View;
/* loaded from: classes.dex */
final class v implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ t a;
    private final /* synthetic */ View b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar, View view) {
        this.a = tVar;
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
