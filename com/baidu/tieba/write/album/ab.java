package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ab implements View.OnClickListener {
    final /* synthetic */ y cQS;
    private final /* synthetic */ ImageFileInfo cQU;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(y yVar, int i, ImageFileInfo imageFileInfo) {
        this.cQS = yVar;
        this.val$position = i;
        this.cQU = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        v vVar;
        v vVar2;
        vVar = this.cQS.cQQ;
        if (vVar != null) {
            vVar2 = this.cQS.cQQ;
            vVar2.a(this.val$position, this.cQU);
        }
    }
}
