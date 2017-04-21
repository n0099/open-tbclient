package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class aj implements x {
    final /* synthetic */ ag fQJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ag agVar) {
        this.fQJ = agVar;
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
        oVar = this.fQJ.fPd;
        int maxImagesAllowed = oVar.getMaxImagesAllowed();
        oVar2 = this.fQJ.fPd;
        if (oVar2.size() >= maxImagesAllowed) {
            albumActivity2 = this.fQJ.fPr;
            if (!albumActivity2.bop()) {
                this.fQJ.showToast(String.format(this.fQJ.getPageContext().getString(w.l.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
                return;
            }
        }
        oVar3 = this.fQJ.fPd;
        if (oVar3.boJ()) {
            oVar5 = this.fQJ.fPd;
            oVar5.rb(String.valueOf(System.currentTimeMillis()));
        }
        oVar4 = this.fQJ.fPd;
        String boI = oVar4.boI();
        albumActivity = this.fQJ.fPr;
        albumActivity.hC(boI);
    }
}
