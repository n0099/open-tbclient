package com.baidu.tieba.write.album;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ak implements x {
    final /* synthetic */ ah cuH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ah ahVar) {
        this.cuH = ahVar;
    }

    @Override // com.baidu.tieba.write.album.x
    public void onClick(int i, ImageFileInfo imageFileInfo) {
        n nVar;
        n nVar2;
        n nVar3;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        nVar = this.cuH.ctp;
        int maxImagesAllowed = nVar.getMaxImagesAllowed();
        nVar2 = this.cuH.ctp;
        if (nVar2.size() < maxImagesAllowed) {
            nVar3 = this.cuH.ctp;
            String apN = nVar3.apN();
            if (!TextUtils.isEmpty(apN)) {
                albumActivity2 = this.cuH.ctu;
                az.a(albumActivity2.getPageContext(), apN);
                return;
            }
            albumActivity = this.cuH.ctu;
            az.d(albumActivity.getPageContext());
            return;
        }
        this.cuH.showToast(String.format(this.cuH.getPageContext().getString(com.baidu.tieba.y.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
    }
}
