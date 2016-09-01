package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.ab;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    private final /* synthetic */ int VV;
    final /* synthetic */ ab gbe;
    private final /* synthetic */ ab.a gbf;
    private final /* synthetic */ ImageFileInfo gbg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, ab.a aVar, int i, ImageFileInfo imageFileInfo) {
        this.gbe = abVar;
        this.gbf = aVar;
        this.VV = i;
        this.gbg = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.gbe.gbb;
        if (zVar != null && this.gbf.gbj) {
            zVar2 = this.gbe.gbb;
            zVar2.b(this.VV, this.gbg);
        }
    }
}
