package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.y;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ y cQS;
    private final /* synthetic */ y.a cQT;
    private final /* synthetic */ ImageFileInfo cQU;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar, y.a aVar, int i, ImageFileInfo imageFileInfo) {
        this.cQS = yVar;
        this.cQT = aVar;
        this.val$position = i;
        this.cQU = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        w wVar;
        w wVar2;
        wVar = this.cQS.cQP;
        if (wVar != null && this.cQT.cQX) {
            wVar2 = this.cQS.cQP;
            wVar2.a(this.val$position, this.cQU);
        }
    }
}
