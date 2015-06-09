package com.baidu.tieba.write.album;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class am implements z {
    final /* synthetic */ aj czq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(aj ajVar) {
        this.czq = ajVar;
    }

    @Override // com.baidu.tieba.write.album.z
    public void a(int i, ImageFileInfo imageFileInfo) {
        p pVar;
        p pVar2;
        p pVar3;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        pVar = this.czq.cxV;
        int maxImagesAllowed = pVar.getMaxImagesAllowed();
        pVar2 = this.czq.cxV;
        if (pVar2.size() < maxImagesAllowed) {
            pVar3 = this.czq.cxV;
            String arT = pVar3.arT();
            if (!TextUtils.isEmpty(arT)) {
                albumActivity2 = this.czq.cya;
                ax.a(albumActivity2.getPageContext(), arT);
                return;
            }
            albumActivity = this.czq.cya;
            ax.b(albumActivity.getPageContext());
            return;
        }
        this.czq.showToast(String.format(this.czq.getPageContext().getString(com.baidu.tieba.t.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
    }
}
