package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ x dlb;
    private final /* synthetic */ ImageFileInfo dld;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar, int i, ImageFileInfo imageFileInfo) {
        this.dlb = xVar;
        this.val$position = i;
        this.dld = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u uVar;
        u uVar2;
        uVar = this.dlb.dkZ;
        if (uVar != null) {
            uVar2 = this.dlb.dkZ;
            uVar2.a(this.val$position, this.dld);
        }
    }
}
