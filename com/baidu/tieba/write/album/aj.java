package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class aj implements x {
    final /* synthetic */ ag eIc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ag agVar) {
        this.eIc = agVar;
    }

    @Override // com.baidu.tieba.write.album.x
    public void a(int i, ImageFileInfo imageFileInfo) {
        o oVar;
        o oVar2;
        o oVar3;
        o oVar4;
        AlbumActivity albumActivity;
        o oVar5;
        oVar = this.eIc.eGD;
        int maxImagesAllowed = oVar.getMaxImagesAllowed();
        oVar2 = this.eIc.eGD;
        if (oVar2.size() < maxImagesAllowed) {
            oVar3 = this.eIc.eGD;
            if (oVar3.aZn()) {
                oVar5 = this.eIc.eGD;
                oVar5.oN(String.valueOf(System.currentTimeMillis()));
            }
            oVar4 = this.eIc.eGD;
            String aZm = oVar4.aZm();
            albumActivity = this.eIc.eGS;
            albumActivity.oK(aZm);
            return;
        }
        this.eIc.showToast(String.format(this.eIc.getPageContext().getString(t.j.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
    }
}
