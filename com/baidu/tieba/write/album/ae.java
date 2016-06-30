package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    private final /* synthetic */ int Sx;
    final /* synthetic */ ab fDM;
    private final /* synthetic */ ImageFileInfo fDO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar, int i, ImageFileInfo imageFileInfo) {
        this.fDM = abVar;
        this.Sx = i;
        this.fDO = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        xVar = this.fDM.fDK;
        if (xVar != null) {
            xVar2 = this.fDM.fDK;
            xVar2.b(this.Sx, this.fDO);
        }
    }
}
