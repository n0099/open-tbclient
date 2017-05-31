package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.y;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    private final /* synthetic */ int aaj;
    final /* synthetic */ y fUJ;
    private final /* synthetic */ y.a fUK;
    private final /* synthetic */ ImageFileInfo fUL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar, y.a aVar, int i, ImageFileInfo imageFileInfo) {
        this.fUJ = yVar;
        this.fUK = aVar;
        this.aaj = i;
        this.fUL = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        w wVar;
        w wVar2;
        wVar = this.fUJ.fUE;
        if (wVar != null && this.fUK.fUP) {
            wVar2 = this.fUJ.fUE;
            wVar2.a(this.aaj - 3, this.fUL);
        }
    }
}
