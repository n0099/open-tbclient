package com.baidu.tieba.view;

import android.view.View;
/* loaded from: classes.dex */
class bu implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UserIconBox f2681a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(UserIconBox userIconBox) {
        this.f2681a = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        View findViewWithTag = this.f2681a.findViewWithTag(str);
        if (findViewWithTag != null && eVar != null) {
            findViewWithTag.invalidate();
        }
    }
}
