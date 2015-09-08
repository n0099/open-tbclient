package com.baidu.tieba.write.album;

import android.text.TextUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class ag implements v {
    final /* synthetic */ ad cZQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ad adVar) {
        this.cZQ = adVar;
    }

    @Override // com.baidu.tieba.write.album.v
    public void a(int i, ImageFileInfo imageFileInfo) {
        m mVar;
        m mVar2;
        m mVar3;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        mVar = this.cZQ.cYt;
        int maxImagesAllowed = mVar.getMaxImagesAllowed();
        mVar2 = this.cZQ.cYt;
        if (mVar2.size() < maxImagesAllowed) {
            mVar3 = this.cZQ.cYt;
            String ayj = mVar3.ayj();
            if (!TextUtils.isEmpty(ayj)) {
                albumActivity2 = this.cZQ.cYB;
                com.baidu.tbadk.core.util.ak.a(albumActivity2.getPageContext(), ayj);
                return;
            }
            albumActivity = this.cZQ.cYB;
            com.baidu.tbadk.core.util.ak.c(albumActivity.getPageContext());
            return;
        }
        this.cZQ.showToast(String.format(this.cZQ.getPageContext().getString(i.h.editor_mutiiamge_max), Integer.valueOf(maxImagesAllowed)));
    }
}
