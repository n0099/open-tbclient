package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.ab;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    final /* synthetic */ ab dTo;
    private final /* synthetic */ ab.a dTp;
    private final /* synthetic */ ImageFileInfo dTq;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, ab.a aVar, int i, ImageFileInfo imageFileInfo) {
        this.dTo = abVar;
        this.dTp = aVar;
        this.val$position = i;
        this.dTq = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.dTo.dTl;
        if (zVar != null && this.dTp.dTt) {
            zVar2 = this.dTo.dTl;
            zVar2.a(this.val$position, this.dTq);
        }
    }
}
