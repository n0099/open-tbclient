package com.baidu.tieba.write.album;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class aj implements x {
    final /* synthetic */ ag dTB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ag agVar) {
        this.dTB = agVar;
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
        oVar = this.dTB.dRW;
        int maxImagesAllowed = oVar.getMaxImagesAllowed();
        oVar2 = this.dTB.dRW;
        if (oVar2.size() < maxImagesAllowed) {
            oVar3 = this.dTB.dRW;
            if (oVar3.aKc()) {
                oVar5 = this.dTB.dRW;
                oVar5.nk(String.valueOf(System.currentTimeMillis()));
            }
            oVar4 = this.dTB.dRW;
            String aKb = oVar4.aKb();
            if (!StringUtils.isNull(aKb, true)) {
                albumActivity2 = this.dTB.dSj;
                ar.b(albumActivity2.getPageContext(), aKb);
                return;
            }
            albumActivity = this.dTB.dSj;
            ar.c(albumActivity.getPageContext());
            return;
        }
        this.dTB.showToast(String.format(this.dTB.getPageContext().getString(n.j.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
    }
}
