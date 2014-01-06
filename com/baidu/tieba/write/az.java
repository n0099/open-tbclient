package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
class az implements View.OnClickListener {
    final /* synthetic */ com.baidu.tieba.editortool.t a;
    final /* synthetic */ WriteImagePreview b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(WriteImagePreview writeImagePreview, com.baidu.tieba.editortool.t tVar) {
        this.b = writeImagePreview;
        this.a = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.a(28, this.b.d);
    }
}
