package com.baidu.tieba.write.vote;

import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ WriteVoteActivity dnv;
    private final /* synthetic */ ImageFileInfo dnw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(WriteVoteActivity writeVoteActivity, ImageFileInfo imageFileInfo) {
        this.dnv = writeVoteActivity;
        this.dnw = imageFileInfo;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        n nVar;
        if (aVar != null) {
            nVar = this.dnv.dnn;
            nVar.b(this.dnw, aVar);
        }
    }
}
