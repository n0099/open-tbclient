package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
class bb implements View.OnClickListener {
    final /* synthetic */ com.baidu.tieba.editortool.h a;
    final /* synthetic */ WriteImagePreview b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(WriteImagePreview writeImagePreview, com.baidu.tieba.editortool.h hVar) {
        this.b = writeImagePreview;
        this.a = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.a(28, this.b.d);
    }
}
