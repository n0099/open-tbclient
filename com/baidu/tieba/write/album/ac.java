package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {
    private final /* synthetic */ int Rz;
    final /* synthetic */ aa cuK;
    private final /* synthetic */ af cuL;
    private final /* synthetic */ ImageFileInfo cuM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar, af afVar, int i, ImageFileInfo imageFileInfo) {
        this.cuK = aaVar;
        this.cuL = afVar;
        this.Rz = i;
        this.cuM = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        y yVar;
        y yVar2;
        yVar = this.cuK.cuH;
        if (yVar != null && this.cuL.cuP) {
            yVar2 = this.cuK.cuH;
            yVar2.onClick(this.Rz, this.cuM);
        }
    }
}
