package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    private final /* synthetic */ int RY;
    final /* synthetic */ ac czc;
    private final /* synthetic */ ah czd;
    private final /* synthetic */ ImageFileInfo cze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ac acVar, ah ahVar, int i, ImageFileInfo imageFileInfo) {
        this.czc = acVar;
        this.czd = ahVar;
        this.RY = i;
        this.cze = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa aaVar;
        aa aaVar2;
        aaVar = this.czc.cyZ;
        if (aaVar != null && this.czd.czh) {
            aaVar2 = this.czc.cyZ;
            aaVar2.a(this.RY, this.cze);
        }
    }
}
