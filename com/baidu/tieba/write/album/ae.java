package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    private final /* synthetic */ int Tf;
    final /* synthetic */ ab fQZ;
    private final /* synthetic */ ImageFileInfo fRb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar, int i, ImageFileInfo imageFileInfo) {
        this.fQZ = abVar;
        this.Tf = i;
        this.fRb = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        xVar = this.fQZ.fQX;
        if (xVar != null) {
            xVar2 = this.fQZ.fQX;
            xVar2.b(this.Tf, this.fRb);
        }
    }
}
