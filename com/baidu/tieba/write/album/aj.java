package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class aj implements x {
    final /* synthetic */ ag fzH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ag agVar) {
        this.fzH = agVar;
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
        oVar = this.fzH.fxZ;
        int maxImagesAllowed = oVar.getMaxImagesAllowed();
        oVar2 = this.fzH.fxZ;
        if (oVar2.size() >= maxImagesAllowed) {
            albumActivity2 = this.fzH.fyo;
            if (!albumActivity2.blt()) {
                this.fzH.showToast(String.format(this.fzH.getPageContext().getString(r.j.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
                return;
            }
        }
        oVar3 = this.fzH.fxZ;
        if (oVar3.blN()) {
            oVar5 = this.fzH.fxZ;
            oVar5.rf(String.valueOf(System.currentTimeMillis()));
        }
        oVar4 = this.fzH.fxZ;
        String blM = oVar4.blM();
        albumActivity = this.fzH.fyo;
        albumActivity.ra(blM);
    }
}
