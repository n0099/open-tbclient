package com.baidu.tieba.write.vote;

import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ WriteVoteActivity eKX;
    private final /* synthetic */ ImageFileInfo eKY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(WriteVoteActivity writeVoteActivity, ImageFileInfo imageFileInfo) {
        this.eKX = writeVoteActivity;
        this.eKY = imageFileInfo;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        o oVar;
        if (aVar != null) {
            oVar = this.eKX.eKQ;
            oVar.b(this.eKY, aVar);
        }
    }
}
