package com.baidu.tieba.view;

import android.view.View;
/* loaded from: classes.dex */
class db implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ UserIconBox a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(UserIconBox userIconBox) {
        this.a = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        View findViewWithTag = this.a.findViewWithTag(str);
        if (findViewWithTag != null && bVar != null) {
            findViewWithTag.invalidate();
        }
    }
}
