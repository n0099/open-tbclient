package com.baidu.tieba.write.album;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class ah implements v {
    final /* synthetic */ ae dmW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ae aeVar) {
        this.dmW = aeVar;
    }

    @Override // com.baidu.tieba.write.album.v
    public void a(int i, ImageFileInfo imageFileInfo) {
        m mVar;
        m mVar2;
        m mVar3;
        m mVar4;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        m mVar5;
        mVar = this.dmW.dlv;
        int maxImagesAllowed = mVar.getMaxImagesAllowed();
        mVar2 = this.dmW.dlv;
        if (mVar2.size() < maxImagesAllowed) {
            mVar3 = this.dmW.dlv;
            if (mVar3.aCk()) {
                mVar5 = this.dmW.dlv;
                mVar5.mr(String.valueOf(System.currentTimeMillis()));
            }
            mVar4 = this.dmW.dlv;
            String aCj = mVar4.aCj();
            if (!StringUtils.isNull(aCj, true)) {
                albumActivity2 = this.dmW.dlE;
                com.baidu.tbadk.core.util.am.a(albumActivity2.getPageContext(), aCj);
                return;
            }
            albumActivity = this.dmW.dlE;
            com.baidu.tbadk.core.util.am.c(albumActivity.getPageContext());
            return;
        }
        this.dmW.showToast(String.format(this.dmW.getPageContext().getString(i.h.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
    }
}
