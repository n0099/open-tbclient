package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class m implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ l a;
    private final /* synthetic */ View b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, View view) {
        this.a = lVar;
        this.b = view;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        View findViewWithTag = this.b.findViewWithTag(str);
        if (findViewWithTag != null) {
            findViewWithTag.invalidate();
        }
    }
}
