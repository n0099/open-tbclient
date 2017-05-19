package com.baidu.tieba.write.album;

import com.baidu.tieba.write.album.TbCameraView;
/* loaded from: classes.dex */
class am implements TbCameraView.c {
    final /* synthetic */ ac fNP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ac acVar) {
        this.fNP = acVar;
    }

    @Override // com.baidu.tieba.write.album.TbCameraView.c
    public boolean bmF() {
        return !com.baidu.tbadk.core.util.ae.d(this.fNP.getPageContext().getPageActivity(), 1);
    }
}
