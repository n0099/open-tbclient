package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.ab;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    private final /* synthetic */ int WS;
    final /* synthetic */ ab eHP;
    private final /* synthetic */ ab.a eHQ;
    private final /* synthetic */ ImageFileInfo eHR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, ab.a aVar, int i, ImageFileInfo imageFileInfo) {
        this.eHP = abVar;
        this.eHQ = aVar;
        this.WS = i;
        this.eHR = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.eHP.eHM;
        if (zVar != null && this.eHQ.eHU) {
            zVar2 = this.eHP.eHM;
            zVar2.a(this.WS, this.eHR);
        }
    }
}
