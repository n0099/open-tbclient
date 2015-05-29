package com.baidu.tieba.write.album;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class am implements z {
    final /* synthetic */ aj czp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(aj ajVar) {
        this.czp = ajVar;
    }

    @Override // com.baidu.tieba.write.album.z
    public void a(int i, ImageFileInfo imageFileInfo) {
        p pVar;
        p pVar2;
        p pVar3;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        pVar = this.czp.cxU;
        int maxImagesAllowed = pVar.getMaxImagesAllowed();
        pVar2 = this.czp.cxU;
        if (pVar2.size() < maxImagesAllowed) {
            pVar3 = this.czp.cxU;
            String arS = pVar3.arS();
            if (!TextUtils.isEmpty(arS)) {
                albumActivity2 = this.czp.cxZ;
                ax.a(albumActivity2.getPageContext(), arS);
                return;
            }
            albumActivity = this.czp.cxZ;
            ax.b(albumActivity.getPageContext());
            return;
        }
        this.czp.showToast(String.format(this.czp.getPageContext().getString(com.baidu.tieba.t.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
    }
}
