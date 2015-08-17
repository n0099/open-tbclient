package com.baidu.tieba.write.album;

import android.text.TextUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class ag implements v {
    final /* synthetic */ ad cRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ad adVar) {
        this.cRf = adVar;
    }

    @Override // com.baidu.tieba.write.album.v
    public void a(int i, ImageFileInfo imageFileInfo) {
        m mVar;
        m mVar2;
        m mVar3;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        mVar = this.cRf.cPJ;
        int maxImagesAllowed = mVar.getMaxImagesAllowed();
        mVar2 = this.cRf.cPJ;
        if (mVar2.size() < maxImagesAllowed) {
            mVar3 = this.cRf.cPJ;
            String atQ = mVar3.atQ();
            if (!TextUtils.isEmpty(atQ)) {
                albumActivity2 = this.cRf.cPQ;
                com.baidu.tbadk.core.util.ak.a(albumActivity2.getPageContext(), atQ);
                return;
            }
            albumActivity = this.cRf.cPQ;
            com.baidu.tbadk.core.util.ak.c(albumActivity.getPageContext());
            return;
        }
        this.cRf.showToast(String.format(this.cRf.getPageContext().getString(i.C0057i.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
    }
}
