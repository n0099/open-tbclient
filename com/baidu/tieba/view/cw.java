package com.baidu.tieba.view;

import android.view.View;
/* loaded from: classes.dex */
class cw implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ UserIconBox a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(UserIconBox userIconBox) {
        this.a = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        View findViewWithTag = this.a.findViewWithTag(str);
        if (findViewWithTag != null && dVar != null) {
            findViewWithTag.invalidate();
        }
    }
}
