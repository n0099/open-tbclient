package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    private final /* synthetic */ int aaP;
    final /* synthetic */ ab fQx;
    private final /* synthetic */ ImageFileInfo fQz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar, int i, ImageFileInfo imageFileInfo) {
        this.fQx = abVar;
        this.aaP = i;
        this.fQz = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        xVar = this.fQx.fQv;
        if (xVar != null) {
            xVar2 = this.fQx.fQv;
            xVar2.a(this.aaP, this.fQz);
        }
    }
}
