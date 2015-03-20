package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    private final /* synthetic */ int Rx;
    final /* synthetic */ aa cuu;
    private final /* synthetic */ ImageFileInfo cuw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(aa aaVar, int i, ImageFileInfo imageFileInfo) {
        this.cuu = aaVar;
        this.Rx = i;
        this.cuw = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        xVar = this.cuu.cus;
        if (xVar != null) {
            xVar2 = this.cuu.cus;
            xVar2.onClick(this.Rx, this.cuw);
        }
    }
}
