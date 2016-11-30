package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    private final /* synthetic */ int WD;
    final /* synthetic */ ab gkS;
    private final /* synthetic */ ImageFileInfo gkU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar, int i, ImageFileInfo imageFileInfo) {
        this.gkS = abVar;
        this.WD = i;
        this.gkU = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        xVar = this.gkS.gkQ;
        if (xVar != null) {
            xVar2 = this.gkS.gkQ;
            xVar2.b(this.WD, this.gkU);
        }
    }
}
