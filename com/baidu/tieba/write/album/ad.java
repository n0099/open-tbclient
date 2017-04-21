package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.ab;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    private final /* synthetic */ int aaP;
    final /* synthetic */ ab fQx;
    private final /* synthetic */ ab.a fQy;
    private final /* synthetic */ ImageFileInfo fQz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, ab.a aVar, int i, ImageFileInfo imageFileInfo) {
        this.fQx = abVar;
        this.fQy = aVar;
        this.aaP = i;
        this.fQz = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.fQx.fQu;
        if (zVar != null && this.fQy.fQC) {
            zVar2 = this.fQx.fQu;
            zVar2.a(this.aaP, this.fQz);
        }
    }
}
