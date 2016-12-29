package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    private final /* synthetic */ int VX;
    final /* synthetic */ ab fzv;
    private final /* synthetic */ ImageFileInfo fzx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar, int i, ImageFileInfo imageFileInfo) {
        this.fzv = abVar;
        this.VX = i;
        this.fzx = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        xVar = this.fzv.fzt;
        if (xVar != null) {
            xVar2 = this.fzv.fzt;
            xVar2.a(this.VX, this.fzx);
        }
    }
}
