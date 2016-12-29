package com.baidu.tieba.imMessageCenter.mention;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements com.baidu.tbadk.editortools.e.c {
    final /* synthetic */ bb ddm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bb bbVar) {
        this.ddm = bbVar;
    }

    @Override // com.baidu.tbadk.editortools.e.c
    public void CZ() {
        ReplyMessageActivity replyMessageActivity;
        replyMessageActivity = this.ddm.dcV;
        replyMessageActivity.showProgressBar();
    }
}
