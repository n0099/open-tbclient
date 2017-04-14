package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    private final /* synthetic */ int aaO;
    final /* synthetic */ ab fOb;
    private final /* synthetic */ ImageFileInfo fOd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar, int i, ImageFileInfo imageFileInfo) {
        this.fOb = abVar;
        this.aaO = i;
        this.fOd = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        xVar = this.fOb.fNZ;
        if (xVar != null) {
            xVar2 = this.fOb.fNZ;
            xVar2.a(this.aaO, this.fOd);
        }
    }
}
