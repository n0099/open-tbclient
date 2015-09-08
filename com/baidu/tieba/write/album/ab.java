package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ab implements View.OnClickListener {
    final /* synthetic */ y cZD;
    private final /* synthetic */ ImageFileInfo cZF;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(y yVar, int i, ImageFileInfo imageFileInfo) {
        this.cZD = yVar;
        this.val$position = i;
        this.cZF = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        v vVar;
        v vVar2;
        vVar = this.cZD.cZB;
        if (vVar != null) {
            vVar2 = this.cZD.cZB;
            vVar2.a(this.val$position, this.cZF);
        }
    }
}
