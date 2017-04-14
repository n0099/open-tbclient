package com.baidu.tieba.write.b;

import android.view.View;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ a fOB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fOB = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fOB.b(new com.baidu.tbadk.editortools.a(18, -1, null));
    }
}
