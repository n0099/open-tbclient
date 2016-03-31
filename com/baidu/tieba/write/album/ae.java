package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    private final /* synthetic */ int WS;
    final /* synthetic */ ab eHP;
    private final /* synthetic */ ImageFileInfo eHR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar, int i, ImageFileInfo imageFileInfo) {
        this.eHP = abVar;
        this.WS = i;
        this.eHR = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        xVar = this.eHP.eHN;
        if (xVar != null) {
            xVar2 = this.eHP.eHN;
            xVar2.a(this.WS, this.eHR);
        }
    }
}
