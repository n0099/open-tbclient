package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.ab;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    private final /* synthetic */ int YA;
    final /* synthetic */ ab enS;
    private final /* synthetic */ ab.a enT;
    private final /* synthetic */ ImageFileInfo enU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, ab.a aVar, int i, ImageFileInfo imageFileInfo) {
        this.enS = abVar;
        this.enT = aVar;
        this.YA = i;
        this.enU = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.enS.enP;
        if (zVar != null && this.enT.enX) {
            zVar2 = this.enS.enP;
            zVar2.a(this.YA, this.enU);
        }
    }
}
