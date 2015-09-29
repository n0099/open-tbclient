package com.baidu.tieba.write.album;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class af implements u {
    final /* synthetic */ ac dkO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ac acVar) {
        this.dkO = acVar;
    }

    @Override // com.baidu.tieba.write.album.u
    public void a(int i, ImageFileInfo imageFileInfo) {
        l lVar;
        l lVar2;
        l lVar3;
        l lVar4;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        l lVar5;
        lVar = this.dkO.djp;
        int maxImagesAllowed = lVar.getMaxImagesAllowed();
        lVar2 = this.dkO.djp;
        if (lVar2.size() < maxImagesAllowed) {
            lVar3 = this.dkO.djp;
            if (lVar3.aBo()) {
                lVar5 = this.dkO.djp;
                lVar5.mk(String.valueOf(System.currentTimeMillis()));
            }
            lVar4 = this.dkO.djp;
            String aBn = lVar4.aBn();
            if (!StringUtils.isNull(aBn, true)) {
                albumActivity2 = this.dkO.djw;
                com.baidu.tbadk.core.util.al.a(albumActivity2.getPageContext(), aBn);
                return;
            }
            albumActivity = this.dkO.djw;
            com.baidu.tbadk.core.util.al.c(albumActivity.getPageContext());
            return;
        }
        this.dkO.showToast(String.format(this.dkO.getPageContext().getString(i.h.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
    }
}
