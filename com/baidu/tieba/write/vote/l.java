package com.baidu.tieba.write.vote;

import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ WriteVoteActivity dpK;
    private final /* synthetic */ ImageFileInfo dpL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(WriteVoteActivity writeVoteActivity, ImageFileInfo imageFileInfo) {
        this.dpK = writeVoteActivity;
        this.dpL = imageFileInfo;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        n nVar;
        if (aVar != null) {
            nVar = this.dpK.dpC;
            nVar.b(this.dpL, aVar);
        }
    }
}
