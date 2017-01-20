package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    private final /* synthetic */ int Vn;
    final /* synthetic */ ab fHY;
    private final /* synthetic */ ImageFileInfo fIa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar, int i, ImageFileInfo imageFileInfo) {
        this.fHY = abVar;
        this.Vn = i;
        this.fIa = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        xVar = this.fHY.fHW;
        if (xVar != null) {
            xVar2 = this.fHY.fHW;
            xVar2.a(this.Vn, this.fIa);
        }
    }
}
