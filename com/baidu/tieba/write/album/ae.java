package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    private final /* synthetic */ int aay;
    final /* synthetic */ ab fMs;
    private final /* synthetic */ ImageFileInfo fMu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar, int i, ImageFileInfo imageFileInfo) {
        this.fMs = abVar;
        this.aay = i;
        this.fMu = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        xVar = this.fMs.fMq;
        if (xVar != null) {
            xVar2 = this.fMs.fMq;
            xVar2.a(this.aay, this.fMu);
        }
    }
}
