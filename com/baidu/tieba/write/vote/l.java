package com.baidu.tieba.write.vote;

import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ WriteVoteActivity erf;
    private final /* synthetic */ ImageFileInfo erg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(WriteVoteActivity writeVoteActivity, ImageFileInfo imageFileInfo) {
        this.erf = writeVoteActivity;
        this.erg = imageFileInfo;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        n nVar;
        if (aVar != null) {
            nVar = this.erf.eqX;
            nVar.b(this.erg, aVar);
        }
    }
}
