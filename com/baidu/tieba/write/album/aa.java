package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ x dkB;
    private final /* synthetic */ ImageFileInfo dkD;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar, int i, ImageFileInfo imageFileInfo) {
        this.dkB = xVar;
        this.val$position = i;
        this.dkD = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u uVar;
        u uVar2;
        uVar = this.dkB.dkz;
        if (uVar != null) {
            uVar2 = this.dkB.dkz;
            uVar2.a(this.val$position, this.dkD);
        }
    }
}
