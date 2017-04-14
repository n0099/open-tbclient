package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class aj implements x {
    final /* synthetic */ ag fOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ag agVar) {
        this.fOn = agVar;
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
        oVar = this.fOn.fMH;
        int maxImagesAllowed = oVar.getMaxImagesAllowed();
        oVar2 = this.fOn.fMH;
        if (oVar2.size() >= maxImagesAllowed) {
            albumActivity2 = this.fOn.fMV;
            if (!albumActivity2.bno()) {
                this.fOn.showToast(String.format(this.fOn.getPageContext().getString(w.l.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
                return;
            }
        }
        oVar3 = this.fOn.fMH;
        if (oVar3.bnI()) {
            oVar5 = this.fOn.fMH;
            oVar5.ra(String.valueOf(System.currentTimeMillis()));
        }
        oVar4 = this.fOn.fMH;
        String bnH = oVar4.bnH();
        albumActivity = this.fOn.fMV;
        albumActivity.hB(bnH);
    }
}
