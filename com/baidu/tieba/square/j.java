package com.baidu.tieba.square;

import android.view.View;
import android.widget.ImageView;
/* loaded from: classes.dex */
class j implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1726a;
    private final /* synthetic */ View b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, View view) {
        this.f1726a = hVar;
        this.b = view;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        View findViewWithTag = this.b.findViewWithTag(str);
        if (findViewWithTag instanceof ImageView) {
            ((ImageView) findViewWithTag).invalidate();
        }
    }
}
