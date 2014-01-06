package com.baidu.tieba.recommend;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ View a;
    final /* synthetic */ h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(h hVar, View view) {
        this.b = hVar;
        this.a = view;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        View findViewWithTag;
        if (this.a != null && (findViewWithTag = this.a.findViewWithTag(str)) != null) {
            findViewWithTag.invalidate();
        }
    }
}
