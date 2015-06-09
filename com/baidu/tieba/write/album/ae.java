package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    private final /* synthetic */ int RY;
    final /* synthetic */ ac czd;
    private final /* synthetic */ ah cze;
    private final /* synthetic */ ImageFileInfo czf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ac acVar, ah ahVar, int i, ImageFileInfo imageFileInfo) {
        this.czd = acVar;
        this.cze = ahVar;
        this.RY = i;
        this.czf = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa aaVar;
        aa aaVar2;
        aaVar = this.czd.cza;
        if (aaVar != null && this.cze.czi) {
            aaVar2 = this.czd.cza;
            aaVar2.a(this.RY, this.czf);
        }
    }
}
