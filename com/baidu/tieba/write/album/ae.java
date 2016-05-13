package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    private final /* synthetic */ int Sg;
    final /* synthetic */ ab eYI;
    private final /* synthetic */ ImageFileInfo eYK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar, int i, ImageFileInfo imageFileInfo) {
        this.eYI = abVar;
        this.Sg = i;
        this.eYK = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        xVar = this.eYI.eYG;
        if (xVar != null) {
            xVar2 = this.eYI.eYG;
            xVar2.a(this.Sg, this.eYK);
        }
    }
}
