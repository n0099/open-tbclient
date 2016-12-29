package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.ab;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    private final /* synthetic */ int VX;
    final /* synthetic */ ab fzv;
    private final /* synthetic */ ab.a fzw;
    private final /* synthetic */ ImageFileInfo fzx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, ab.a aVar, int i, ImageFileInfo imageFileInfo) {
        this.fzv = abVar;
        this.fzw = aVar;
        this.VX = i;
        this.fzx = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.fzv.fzs;
        if (zVar != null && this.fzw.fzA) {
            zVar2 = this.fzv.fzs;
            zVar2.a(this.VX, this.fzx);
        }
    }
}
