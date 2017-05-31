package com.baidu.tieba.write.album;

import com.baidu.tieba.write.album.TbCameraView;
/* loaded from: classes.dex */
class am implements TbCameraView.c {
    final /* synthetic */ ac fVw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ac acVar) {
        this.fVw = acVar;
    }

    @Override // com.baidu.tieba.write.album.TbCameraView.c
    public boolean boc() {
        return !com.baidu.tbadk.core.util.ae.d(this.fVw.getPageContext().getPageActivity(), 1);
    }
}
