package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class aj implements x {
    final /* synthetic */ ag fRl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ag agVar) {
        this.fRl = agVar;
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
        oVar = this.fRl.fPM;
        int maxImagesAllowed = oVar.getMaxImagesAllowed();
        oVar2 = this.fRl.fPM;
        if (oVar2.size() >= maxImagesAllowed) {
            albumActivity2 = this.fRl.fQb;
            if (!albumActivity2.bnl()) {
                this.fRl.showToast(String.format(this.fRl.getPageContext().getString(u.j.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
                return;
            }
        }
        oVar3 = this.fRl.fPM;
        if (oVar3.bnB()) {
            oVar5 = this.fRl.fPM;
            oVar5.rx(String.valueOf(System.currentTimeMillis()));
        }
        oVar4 = this.fRl.fPM;
        String bnA = oVar4.bnA();
        albumActivity = this.fRl.fQb;
        albumActivity.ru(bnA);
    }
}
