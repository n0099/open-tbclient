package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class aj implements x {
    final /* synthetic */ ag eYV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ag agVar) {
        this.eYV = agVar;
    }

    @Override // com.baidu.tieba.write.album.x
    public void a(int i, ImageFileInfo imageFileInfo) {
        o oVar;
        o oVar2;
        o oVar3;
        o oVar4;
        AlbumActivity albumActivity;
        o oVar5;
        oVar = this.eYV.eXx;
        int maxImagesAllowed = oVar.getMaxImagesAllowed();
        oVar2 = this.eYV.eXx;
        if (oVar2.size() < maxImagesAllowed) {
            oVar3 = this.eYV.eXx;
            if (oVar3.bbC()) {
                oVar5 = this.eYV.eXx;
                oVar5.pc(String.valueOf(System.currentTimeMillis()));
            }
            oVar4 = this.eYV.eXx;
            String bbB = oVar4.bbB();
            albumActivity = this.eYV.eXM;
            albumActivity.oZ(bbB);
            return;
        }
        this.eYV.showToast(String.format(this.eYV.getPageContext().getString(t.j.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
    }
}
