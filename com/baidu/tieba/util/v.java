package com.baidu.tieba.util;

import android.view.View;
import android.widget.ListView;
/* loaded from: classes.dex */
class v implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ ListView f1929a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ListView listView) {
        this.f1929a = listView;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.c cVar, String str, boolean z) {
        View findViewWithTag;
        if (cVar != null && (findViewWithTag = this.f1929a.findViewWithTag(str)) != null) {
            findViewWithTag.invalidate();
        }
    }
}
