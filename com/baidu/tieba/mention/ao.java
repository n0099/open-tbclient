package com.baidu.tieba.mention;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements com.baidu.tbadk.editortools.c.b {
    final /* synthetic */ ak bWv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ak akVar) {
        this.bWv = akVar;
    }

    @Override // com.baidu.tbadk.editortools.c.b
    public void Bm() {
        SingleMentionActivity singleMentionActivity;
        singleMentionActivity = this.bWv.bWg;
        singleMentionActivity.showProgressBar();
    }
}
