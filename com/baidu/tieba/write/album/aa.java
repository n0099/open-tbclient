package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.y;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    private final /* synthetic */ int aak;
    final /* synthetic */ y gft;
    private final /* synthetic */ y.a gfu;
    private final /* synthetic */ ImageFileInfo gfv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar, y.a aVar, int i, ImageFileInfo imageFileInfo) {
        this.gft = yVar;
        this.gfu = aVar;
        this.aak = i;
        this.gfv = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        w wVar;
        w wVar2;
        wVar = this.gft.gfo;
        if (wVar != null && this.gfu.gfz) {
            wVar2 = this.gft.gfo;
            wVar2.a(this.aak - 3, this.gfv);
        }
    }
}
