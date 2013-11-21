package com.baidu.tieba.view;

import android.view.View;
/* loaded from: classes.dex */
class br implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UserIconBox f2564a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(UserIconBox userIconBox) {
        this.f2564a = userIconBox;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        View findViewWithTag = this.f2564a.findViewWithTag(str);
        if (findViewWithTag != null && eVar != null) {
            findViewWithTag.invalidate();
        }
    }
}
