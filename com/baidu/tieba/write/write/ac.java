package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.editortools.y aAL;
    final /* synthetic */ WriteActivity glP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(WriteActivity writeActivity, com.baidu.tbadk.editortools.y yVar) {
        this.glP = writeActivity;
        this.aAL = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aAL != null) {
            this.aAL.b(new com.baidu.tbadk.editortools.a(48, -1, true));
        }
    }
}
