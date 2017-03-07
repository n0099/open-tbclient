package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class aj implements x {
    final /* synthetic */ ag fME;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ag agVar) {
        this.fME = agVar;
    }

    @Override // com.baidu.tieba.write.album.x
    public void a(int i, ImageFileInfo imageFileInfo) {
        o oVar;
        o oVar2;
        o oVar3;
        o oVar4;
        AlbumActivity albumActivity;
        o oVar5;
        AlbumActivity albumActivity2;
        oVar = this.fME.fKY;
        int maxImagesAllowed = oVar.getMaxImagesAllowed();
        oVar2 = this.fME.fKY;
        if (oVar2.size() >= maxImagesAllowed) {
            albumActivity2 = this.fME.fLm;
            if (!albumActivity2.bmE()) {
                this.fME.showToast(String.format(this.fME.getPageContext().getString(w.l.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
                return;
            }
        }
        oVar3 = this.fME.fKY;
        if (oVar3.bmY()) {
            oVar5 = this.fME.fKY;
            oVar5.qG(String.valueOf(System.currentTimeMillis()));
        }
        oVar4 = this.fME.fKY;
        String bmX = oVar4.bmX();
        albumActivity = this.fME.fLm;
        albumActivity.hx(bmX);
    }
}
