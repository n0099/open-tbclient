package com.baidu.tieba.mention;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements com.baidu.tbadk.editortools.c.b {
    final /* synthetic */ ak bXb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ak akVar) {
        this.bXb = akVar;
    }

    @Override // com.baidu.tbadk.editortools.c.b
    public void Bz() {
        SingleMentionActivity singleMentionActivity;
        singleMentionActivity = this.bXb.bWM;
        singleMentionActivity.showProgressBar();
    }
}
