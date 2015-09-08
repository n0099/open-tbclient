package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.y;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ y cZD;
    private final /* synthetic */ y.a cZE;
    private final /* synthetic */ ImageFileInfo cZF;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar, y.a aVar, int i, ImageFileInfo imageFileInfo) {
        this.cZD = yVar;
        this.cZE = aVar;
        this.val$position = i;
        this.cZF = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        w wVar;
        w wVar2;
        wVar = this.cZD.cZA;
        if (wVar != null && this.cZE.cZI) {
            wVar2 = this.cZD.cZA;
            wVar2.a(this.val$position, this.cZF);
        }
    }
}
