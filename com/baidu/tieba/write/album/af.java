package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class af implements View.OnClickListener {
    private final /* synthetic */ int RY;
    final /* synthetic */ ac czc;
    private final /* synthetic */ ImageFileInfo cze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ac acVar, int i, ImageFileInfo imageFileInfo) {
        this.czc = acVar;
        this.RY = i;
        this.cze = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.czc.cza;
        if (zVar != null) {
            zVar2 = this.czc.cza;
            zVar2.a(this.RY, this.cze);
        }
    }
}
