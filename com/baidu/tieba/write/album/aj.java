package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class aj implements x {
    final /* synthetic */ ag eYU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ag agVar) {
        this.eYU = agVar;
    }

    @Override // com.baidu.tieba.write.album.x
    public void a(int i, ImageFileInfo imageFileInfo) {
        o oVar;
        o oVar2;
        o oVar3;
        o oVar4;
        AlbumActivity albumActivity;
        o oVar5;
        oVar = this.eYU.eXw;
        int maxImagesAllowed = oVar.getMaxImagesAllowed();
        oVar2 = this.eYU.eXw;
        if (oVar2.size() < maxImagesAllowed) {
            oVar3 = this.eYU.eXw;
            if (oVar3.bbJ()) {
                oVar5 = this.eYU.eXw;
                oVar5.pc(String.valueOf(System.currentTimeMillis()));
            }
            oVar4 = this.eYU.eXw;
            String bbI = oVar4.bbI();
            albumActivity = this.eYU.eXL;
            albumActivity.oZ(bbI);
            return;
        }
        this.eYU.showToast(String.format(this.eYU.getPageContext().getString(t.j.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
    }
}
