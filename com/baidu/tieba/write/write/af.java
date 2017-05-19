package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.editortools.y azW;
    final /* synthetic */ WriteActivity fSV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(WriteActivity writeActivity, com.baidu.tbadk.editortools.y yVar) {
        this.fSV = writeActivity;
        this.azW = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.azW != null) {
            this.azW.b(new com.baidu.tbadk.editortools.a(48, -1, true));
        }
    }
}
