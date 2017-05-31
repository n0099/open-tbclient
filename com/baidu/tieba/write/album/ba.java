package com.baidu.tieba.write.album;

import com.baidu.tieba.write.album.TransparentHeadGridView;
/* loaded from: classes.dex */
class ba implements TransparentHeadGridView.c {
    final /* synthetic */ TransparentHeadGridView fVT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(TransparentHeadGridView transparentHeadGridView) {
        this.fVT = transparentHeadGridView;
    }

    @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
    public void Ho() {
        this.fVT.setVisibility(8);
        if (this.fVT.fVs != null) {
            this.fVT.fVs.bof();
        }
    }
}
