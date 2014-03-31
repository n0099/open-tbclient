package com.baidu.tieba.signall;

import android.view.View;
/* loaded from: classes.dex */
final class m implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ k a;
    private final /* synthetic */ View b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, View view) {
        this.a = kVar;
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
