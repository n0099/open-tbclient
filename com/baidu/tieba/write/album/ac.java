package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {
    private final /* synthetic */ int Rx;
    final /* synthetic */ aa cuu;
    private final /* synthetic */ af cuv;
    private final /* synthetic */ ImageFileInfo cuw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar, af afVar, int i, ImageFileInfo imageFileInfo) {
        this.cuu = aaVar;
        this.cuv = afVar;
        this.Rx = i;
        this.cuw = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        y yVar;
        y yVar2;
        yVar = this.cuu.cur;
        if (yVar != null && this.cuv.cuz) {
            yVar2 = this.cuu.cur;
            yVar2.onClick(this.Rx, this.cuw);
        }
    }
}
