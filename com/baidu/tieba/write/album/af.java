package com.baidu.tieba.write.album;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class af implements u {
    final /* synthetic */ ac dlo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ac acVar) {
        this.dlo = acVar;
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
        lVar = this.dlo.djP;
        int maxImagesAllowed = lVar.getMaxImagesAllowed();
        lVar2 = this.dlo.djP;
        if (lVar2.size() < maxImagesAllowed) {
            lVar3 = this.dlo.djP;
            if (lVar3.aBy()) {
                lVar5 = this.dlo.djP;
                lVar5.mn(String.valueOf(System.currentTimeMillis()));
            }
            lVar4 = this.dlo.djP;
            String aBx = lVar4.aBx();
            if (!StringUtils.isNull(aBx, true)) {
                albumActivity2 = this.dlo.djW;
                am.a(albumActivity2.getPageContext(), aBx);
                return;
            }
            albumActivity = this.dlo.djW;
            am.c(albumActivity.getPageContext());
            return;
        }
        this.dlo.showToast(String.format(this.dlo.getPageContext().getString(i.h.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
    }
}
