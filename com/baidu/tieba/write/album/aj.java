package com.baidu.tieba.write.album;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class aj implements x {
    final /* synthetic */ ag dMc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ag agVar) {
        this.dMc = agVar;
    }

    @Override // com.baidu.tieba.write.album.x
    public void a(int i, ImageFileInfo imageFileInfo) {
        o oVar;
        o oVar2;
        o oVar3;
        o oVar4;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        o oVar5;
        oVar = this.dMc.dKx;
        int maxImagesAllowed = oVar.getMaxImagesAllowed();
        oVar2 = this.dMc.dKx;
        if (oVar2.size() < maxImagesAllowed) {
            oVar3 = this.dMc.dKx;
            if (oVar3.aHH()) {
                oVar5 = this.dMc.dKx;
                oVar5.nm(String.valueOf(System.currentTimeMillis()));
            }
            oVar4 = this.dMc.dKx;
            String aHG = oVar4.aHG();
            if (!StringUtils.isNull(aHG, true)) {
                albumActivity2 = this.dMc.dKK;
                ar.b(albumActivity2.getPageContext(), aHG);
                return;
            }
            albumActivity = this.dMc.dKK;
            ar.c(albumActivity.getPageContext());
            return;
        }
        this.dMc.showToast(String.format(this.dMc.getPageContext().getString(n.i.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
    }
}
