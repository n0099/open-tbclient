package com.baidu.tieba.write.vote;

import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ WriteVoteActivity eKX;
    private final /* synthetic */ ImageFileInfo eKY;
    private final /* synthetic */ String eKZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteVoteActivity writeVoteActivity, ImageFileInfo imageFileInfo, String str) {
        this.eKX = writeVoteActivity;
        this.eKY = imageFileInfo;
        this.eKZ = str;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        o oVar;
        if (aVar != null) {
            oVar = this.eKX.eKQ;
            oVar.a(this.eKY, aVar, this.eKZ);
        }
    }
}
