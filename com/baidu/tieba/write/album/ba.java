package com.baidu.tieba.write.album;

import com.baidu.tieba.write.album.TransparentHeadGridView;
/* loaded from: classes.dex */
class ba implements TransparentHeadGridView.c {
    final /* synthetic */ TransparentHeadGridView ggE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(TransparentHeadGridView transparentHeadGridView) {
        this.ggE = transparentHeadGridView;
    }

    @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
    public void HL() {
        this.ggE.setVisibility(8);
        if (this.ggE.ggd != null) {
            this.ggE.ggd.bsC();
        }
    }
}
