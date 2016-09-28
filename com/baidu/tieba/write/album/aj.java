package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class aj implements x {
    final /* synthetic */ ag gdz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ag agVar) {
        this.gdz = agVar;
    }

    @Override // com.baidu.tieba.write.album.x
    public void b(int i, ImageFileInfo imageFileInfo) {
        o oVar;
        o oVar2;
        o oVar3;
        o oVar4;
        AlbumActivity albumActivity;
        o oVar5;
        AlbumActivity albumActivity2;
        oVar = this.gdz.gbZ;
        int maxImagesAllowed = oVar.getMaxImagesAllowed();
        oVar2 = this.gdz.gbZ;
        if (oVar2.size() >= maxImagesAllowed) {
            albumActivity2 = this.gdz.gco;
            if (!albumActivity2.bsh()) {
                this.gdz.showToast(String.format(this.gdz.getPageContext().getString(r.j.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
                return;
            }
        }
        oVar3 = this.gdz.gbZ;
        if (oVar3.bsx()) {
            oVar5 = this.gdz.gbZ;
            oVar5.sw(String.valueOf(System.currentTimeMillis()));
        }
        oVar4 = this.gdz.gbZ;
        String bsw = oVar4.bsw();
        albumActivity = this.gdz.gco;
        albumActivity.st(bsw);
    }
}
