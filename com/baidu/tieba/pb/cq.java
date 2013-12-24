package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements View.OnClickListener {
    final /* synthetic */ com.baidu.tieba.editortool.h a;
    final /* synthetic */ PbEditorToolView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(PbEditorToolView pbEditorToolView, com.baidu.tieba.editortool.h hVar) {
        this.b = pbEditorToolView;
        this.a = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.a(10, null);
    }
}
