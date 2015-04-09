package com.baidu.tieba.write.album;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ak implements x {
    final /* synthetic */ ah cuX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ah ahVar) {
        this.cuX = ahVar;
    }

    @Override // com.baidu.tieba.write.album.x
    public void onClick(int i, ImageFileInfo imageFileInfo) {
        n nVar;
        n nVar2;
        n nVar3;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        nVar = this.cuX.ctF;
        int maxImagesAllowed = nVar.getMaxImagesAllowed();
        nVar2 = this.cuX.ctF;
        if (nVar2.size() < maxImagesAllowed) {
            nVar3 = this.cuX.ctF;
            String aqc = nVar3.aqc();
            if (!TextUtils.isEmpty(aqc)) {
                albumActivity2 = this.cuX.ctK;
                az.a(albumActivity2.getPageContext(), aqc);
                return;
            }
            albumActivity = this.cuX.ctK;
            az.d(albumActivity.getPageContext());
            return;
        }
        this.cuX.showToast(String.format(this.cuX.getPageContext().getString(com.baidu.tieba.y.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
    }
}
