package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class aj implements x {
    final /* synthetic */ ag gle;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ag agVar) {
        this.gle = agVar;
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
        oVar = this.gle.gjE;
        int maxImagesAllowed = oVar.getMaxImagesAllowed();
        oVar2 = this.gle.gjE;
        if (oVar2.size() >= maxImagesAllowed) {
            albumActivity2 = this.gle.gjT;
            if (!albumActivity2.buC()) {
                this.gle.showToast(String.format(this.gle.getPageContext().getString(r.j.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
                return;
            }
        }
        oVar3 = this.gle.gjE;
        if (oVar3.buS()) {
            oVar5 = this.gle.gjE;
            oVar5.sS(String.valueOf(System.currentTimeMillis()));
        }
        oVar4 = this.gle.gjE;
        String buR = oVar4.buR();
        albumActivity = this.gle.gjT;
        albumActivity.sP(buR);
    }
}
