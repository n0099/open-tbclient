package com.baidu.tieba.util;

import android.view.View;
import android.widget.ListView;
/* loaded from: classes.dex */
final class aj implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ ListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ListView listView) {
        this.a = listView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        View findViewWithTag;
        if (eVar != null && (findViewWithTag = this.a.findViewWithTag(str)) != null) {
            findViewWithTag.invalidate();
        }
    }
}
