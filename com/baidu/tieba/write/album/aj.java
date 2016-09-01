package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class aj implements x {
    final /* synthetic */ ag gbq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ag agVar) {
        this.gbq = agVar;
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
        oVar = this.gbq.fZQ;
        int maxImagesAllowed = oVar.getMaxImagesAllowed();
        oVar2 = this.gbq.fZQ;
        if (oVar2.size() >= maxImagesAllowed) {
            albumActivity2 = this.gbq.gaf;
            if (!albumActivity2.brB()) {
                this.gbq.showToast(String.format(this.gbq.getPageContext().getString(t.j.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
                return;
            }
        }
        oVar3 = this.gbq.fZQ;
        if (oVar3.brR()) {
            oVar5 = this.gbq.fZQ;
            oVar5.sh(String.valueOf(System.currentTimeMillis()));
        }
        oVar4 = this.gbq.fZQ;
        String brQ = oVar4.brQ();
        albumActivity = this.gbq.gaf;
        albumActivity.se(brQ);
    }
}
