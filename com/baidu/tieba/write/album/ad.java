package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.ab;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    private final /* synthetic */ int Sx;
    final /* synthetic */ ab fDM;
    private final /* synthetic */ ab.a fDN;
    private final /* synthetic */ ImageFileInfo fDO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, ab.a aVar, int i, ImageFileInfo imageFileInfo) {
        this.fDM = abVar;
        this.fDN = aVar;
        this.Sx = i;
        this.fDO = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.fDM.fDJ;
        if (zVar != null && this.fDN.fDR) {
            zVar2 = this.fDM.fDJ;
            zVar2.b(this.Sx, this.fDO);
        }
    }
}
