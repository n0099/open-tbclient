package com.baidu.tieba.imMessageCenter.mention;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class bb implements com.baidu.tbadk.editortools.pb.b {
    final /* synthetic */ av dni;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(av avVar) {
        this.dni = avVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.b
    public void CJ() {
        ReplyMessageActivity replyMessageActivity;
        replyMessageActivity = this.dni.dmR;
        replyMessageActivity.showProgressBar();
    }
}
