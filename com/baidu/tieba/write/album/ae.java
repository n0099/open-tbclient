package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    private final /* synthetic */ int VV;
    final /* synthetic */ ab gbe;
    private final /* synthetic */ ImageFileInfo gbg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar, int i, ImageFileInfo imageFileInfo) {
        this.gbe = abVar;
        this.VV = i;
        this.gbg = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        xVar = this.gbe.gbc;
        if (xVar != null) {
            xVar2 = this.gbe.gbc;
            xVar2.b(this.VV, this.gbg);
        }
    }
}
