package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.ab;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    private final /* synthetic */ int Sg;
    final /* synthetic */ ab eYI;
    private final /* synthetic */ ab.a eYJ;
    private final /* synthetic */ ImageFileInfo eYK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, ab.a aVar, int i, ImageFileInfo imageFileInfo) {
        this.eYI = abVar;
        this.eYJ = aVar;
        this.Sg = i;
        this.eYK = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.eYI.eYF;
        if (zVar != null && this.eYJ.eYN) {
            zVar2 = this.eYI.eYF;
            zVar2.a(this.Sg, this.eYK);
        }
    }
}
