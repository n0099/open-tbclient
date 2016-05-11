package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    private final /* synthetic */ int Sg;
    final /* synthetic */ ab eYJ;
    private final /* synthetic */ ImageFileInfo eYL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar, int i, ImageFileInfo imageFileInfo) {
        this.eYJ = abVar;
        this.Sg = i;
        this.eYL = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        xVar = this.eYJ.eYH;
        if (xVar != null) {
            xVar2 = this.eYJ.eYH;
            xVar2.a(this.Sg, this.eYL);
        }
    }
}
