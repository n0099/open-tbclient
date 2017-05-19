package com.baidu.tieba.write.album;

import com.baidu.tieba.write.album.TransparentHeadGridView;
/* loaded from: classes.dex */
class ba implements TransparentHeadGridView.c {
    final /* synthetic */ TransparentHeadGridView fOm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(TransparentHeadGridView transparentHeadGridView) {
        this.fOm = transparentHeadGridView;
    }

    @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
    public void Ht() {
        this.fOm.setVisibility(8);
        if (this.fOm.fNL != null) {
            this.fOm.fNL.bmI();
        }
    }
}
