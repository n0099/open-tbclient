package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
class ba implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.editortool.h f2701a;
    final /* synthetic */ WriteImagePreview b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(WriteImagePreview writeImagePreview, com.baidu.tieba.editortool.h hVar) {
        this.b = writeImagePreview;
        this.f2701a = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2701a.a(28, this.b.d);
    }
}
