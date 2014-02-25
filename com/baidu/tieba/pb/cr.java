package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cr implements View.OnClickListener {
    final /* synthetic */ PbEditorToolView a;
    private final /* synthetic */ com.baidu.tieba.editortool.z b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(PbEditorToolView pbEditorToolView, com.baidu.tieba.editortool.z zVar) {
        this.a = pbEditorToolView;
        this.b = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.b.a(10, null);
    }
}
