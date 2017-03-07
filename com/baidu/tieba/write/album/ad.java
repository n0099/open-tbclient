package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.ab;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    private final /* synthetic */ int aay;
    final /* synthetic */ ab fMs;
    private final /* synthetic */ ab.a fMt;
    private final /* synthetic */ ImageFileInfo fMu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, ab.a aVar, int i, ImageFileInfo imageFileInfo) {
        this.fMs = abVar;
        this.fMt = aVar;
        this.aay = i;
        this.fMu = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.fMs.fMp;
        if (zVar != null && this.fMt.fMx) {
            zVar2 = this.fMs.fMp;
            zVar2.a(this.aay, this.fMu);
        }
    }
}
