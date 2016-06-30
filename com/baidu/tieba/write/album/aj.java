package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class aj implements x {
    final /* synthetic */ ag fDY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ag agVar) {
        this.fDY = agVar;
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
        oVar = this.fDY.fCA;
        int maxImagesAllowed = oVar.getMaxImagesAllowed();
        oVar2 = this.fDY.fCA;
        if (oVar2.size() >= maxImagesAllowed) {
            albumActivity2 = this.fDY.fCP;
            if (!albumActivity2.bjP()) {
                this.fDY.showToast(String.format(this.fDY.getPageContext().getString(u.j.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
                return;
            }
        }
        oVar3 = this.fDY.fCA;
        if (oVar3.bkf()) {
            oVar5 = this.fDY.fCA;
            oVar5.qM(String.valueOf(System.currentTimeMillis()));
        }
        oVar4 = this.fDY.fCA;
        String bke = oVar4.bke();
        albumActivity = this.fDY.fCP;
        albumActivity.qJ(bke);
    }
}
