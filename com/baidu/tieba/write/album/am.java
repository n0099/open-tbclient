package com.baidu.tieba.write.album;

import com.baidu.tieba.write.album.TbCameraView;
/* loaded from: classes.dex */
class am implements TbCameraView.c {
    final /* synthetic */ ac ggh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ac acVar) {
        this.ggh = acVar;
    }

    @Override // com.baidu.tieba.write.album.TbCameraView.c
    public boolean bsz() {
        return !com.baidu.tbadk.core.util.ag.d(this.ggh.getPageContext().getPageActivity(), 1);
    }
}
