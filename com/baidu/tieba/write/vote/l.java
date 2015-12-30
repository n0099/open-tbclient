package com.baidu.tieba.write.vote;

import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ WriteVoteActivity dWm;
    private final /* synthetic */ ImageFileInfo dWn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(WriteVoteActivity writeVoteActivity, ImageFileInfo imageFileInfo) {
        this.dWm = writeVoteActivity;
        this.dWn = imageFileInfo;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        n nVar;
        if (aVar != null) {
            nVar = this.dWm.dWe;
            nVar.b(this.dWn, aVar);
        }
    }
}
