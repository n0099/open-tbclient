package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    private final /* synthetic */ int YA;
    final /* synthetic */ ab enS;
    private final /* synthetic */ ImageFileInfo enU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar, int i, ImageFileInfo imageFileInfo) {
        this.enS = abVar;
        this.YA = i;
        this.enU = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        xVar = this.enS.enQ;
        if (xVar != null) {
            xVar2 = this.enS.enQ;
            xVar2.a(this.YA, this.enU);
        }
    }
}
