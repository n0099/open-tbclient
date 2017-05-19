package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.y;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    private final /* synthetic */ int aak;
    final /* synthetic */ y fNc;
    private final /* synthetic */ y.a fNd;
    private final /* synthetic */ ImageFileInfo fNe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar, y.a aVar, int i, ImageFileInfo imageFileInfo) {
        this.fNc = yVar;
        this.fNd = aVar;
        this.aak = i;
        this.fNe = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        w wVar;
        w wVar2;
        wVar = this.fNc.fMX;
        if (wVar != null && this.fNd.fNi) {
            wVar2 = this.fNc.fMX;
            wVar2.a(this.aak - 3, this.fNe);
        }
    }
}
