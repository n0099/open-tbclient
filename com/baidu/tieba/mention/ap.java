package com.baidu.tieba.mention;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.tbadk.editortools.c.c {
    final /* synthetic */ al cbA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(al alVar) {
        this.cbA = alVar;
    }

    @Override // com.baidu.tbadk.editortools.c.c
    public void AX() {
        SingleMentionActivity singleMentionActivity;
        singleMentionActivity = this.cbA.cbm;
        singleMentionActivity.showProgressBar();
    }
}
