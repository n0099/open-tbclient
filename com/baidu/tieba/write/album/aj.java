package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class aj implements x {
    final /* synthetic */ ag fIk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ag agVar) {
        this.fIk = agVar;
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
        oVar = this.fIk.fGE;
        int maxImagesAllowed = oVar.getMaxImagesAllowed();
        oVar2 = this.fIk.fGE;
        if (oVar2.size() >= maxImagesAllowed) {
            albumActivity2 = this.fIk.fGS;
            if (!albumActivity2.bmR()) {
                this.fIk.showToast(String.format(this.fIk.getPageContext().getString(r.l.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
                return;
            }
        }
        oVar3 = this.fIk.fGE;
        if (oVar3.bnl()) {
            oVar5 = this.fIk.fGE;
            oVar5.ry(String.valueOf(System.currentTimeMillis()));
        }
        oVar4 = this.fIk.fGE;
        String bnk = oVar4.bnk();
        albumActivity = this.fIk.fGS;
        albumActivity.hH(bnk);
    }
}
