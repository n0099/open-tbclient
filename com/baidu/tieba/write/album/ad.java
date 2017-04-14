package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.ab;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    private final /* synthetic */ int aaO;
    final /* synthetic */ ab fOb;
    private final /* synthetic */ ab.a fOc;
    private final /* synthetic */ ImageFileInfo fOd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, ab.a aVar, int i, ImageFileInfo imageFileInfo) {
        this.fOb = abVar;
        this.fOc = aVar;
        this.aaO = i;
        this.fOd = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.fOb.fNY;
        if (zVar != null && this.fOc.fOg) {
            zVar2 = this.fOb.fNY;
            zVar2.a(this.aaO, this.fOd);
        }
    }
}
