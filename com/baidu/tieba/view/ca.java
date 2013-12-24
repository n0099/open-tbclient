package com.baidu.tieba.view;

import android.view.View;
/* loaded from: classes.dex */
class ca implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ UserIconBox a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(UserIconBox userIconBox) {
        this.a = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        View findViewWithTag = this.a.findViewWithTag(str);
        if (findViewWithTag != null && eVar != null) {
            findViewWithTag.invalidate();
        }
    }
}
