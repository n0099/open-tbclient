package com.baidu.tieba.write.album;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class aj implements x {
    final /* synthetic */ ag eog;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ag agVar) {
        this.eog = agVar;
    }

    @Override // com.baidu.tieba.write.album.x
    public void a(int i, ImageFileInfo imageFileInfo) {
        o oVar;
        o oVar2;
        o oVar3;
        o oVar4;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        o oVar5;
        oVar = this.eog.emG;
        int maxImagesAllowed = oVar.getMaxImagesAllowed();
        oVar2 = this.eog.emG;
        if (oVar2.size() < maxImagesAllowed) {
            oVar3 = this.eog.emG;
            if (oVar3.aSN()) {
                oVar5 = this.eog.emG;
                oVar5.nA(String.valueOf(System.currentTimeMillis()));
            }
            oVar4 = this.eog.emG;
            String aSM = oVar4.aSM();
            if (!StringUtils.isNull(aSM, true)) {
                albumActivity2 = this.eog.emU;
                aq.b(albumActivity2.getPageContext(), aSM);
                return;
            }
            albumActivity = this.eog.emU;
            aq.c(albumActivity.getPageContext());
            return;
        }
        this.eog.showToast(String.format(this.eog.getPageContext().getString(t.j.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
    }
}
