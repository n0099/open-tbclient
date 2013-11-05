package com.baidu.tieba.recommend;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f2284a;
    final /* synthetic */ h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(h hVar, View view) {
        this.b = hVar;
        this.f2284a = view;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        View findViewWithTag;
        if (this.f2284a != null && (findViewWithTag = this.f2284a.findViewWithTag(str)) != null) {
            findViewWithTag.invalidate();
        }
    }
}
