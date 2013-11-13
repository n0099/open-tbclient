package com.baidu.tieba.util;

import android.view.View;
import android.widget.ListView;
/* loaded from: classes.dex */
final class al implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ListView f2483a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ListView listView) {
        this.f2483a = listView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        View findViewWithTag;
        if (eVar != null && (findViewWithTag = this.f2483a.findViewWithTag(str)) != null) {
            findViewWithTag.invalidate();
        }
    }
}
