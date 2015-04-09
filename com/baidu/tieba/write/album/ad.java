package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    private final /* synthetic */ int Rz;
    final /* synthetic */ aa cuK;
    private final /* synthetic */ ImageFileInfo cuM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(aa aaVar, int i, ImageFileInfo imageFileInfo) {
        this.cuK = aaVar;
        this.Rz = i;
        this.cuM = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        xVar = this.cuK.cuI;
        if (xVar != null) {
            xVar2 = this.cuK.cuI;
            xVar2.onClick(this.Rz, this.cuM);
        }
    }
}
