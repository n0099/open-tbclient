package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
final class h implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ g a;
    private final /* synthetic */ View b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, View view) {
        this.a = gVar;
        this.b = view;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        View findViewWithTag = this.b.findViewWithTag(str);
        if (findViewWithTag != null) {
            findViewWithTag.invalidate();
        }
    }
}
