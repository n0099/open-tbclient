package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.ab;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    private final /* synthetic */ int Tf;
    final /* synthetic */ ab fQZ;
    private final /* synthetic */ ab.a fRa;
    private final /* synthetic */ ImageFileInfo fRb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, ab.a aVar, int i, ImageFileInfo imageFileInfo) {
        this.fQZ = abVar;
        this.fRa = aVar;
        this.Tf = i;
        this.fRb = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.fQZ.fQW;
        if (zVar != null && this.fRa.fRe) {
            zVar2 = this.fQZ.fQW;
            zVar2.b(this.Tf, this.fRb);
        }
    }
}
