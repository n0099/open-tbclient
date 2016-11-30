package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.ab;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    private final /* synthetic */ int WD;
    final /* synthetic */ ab gkS;
    private final /* synthetic */ ab.a gkT;
    private final /* synthetic */ ImageFileInfo gkU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, ab.a aVar, int i, ImageFileInfo imageFileInfo) {
        this.gkS = abVar;
        this.gkT = aVar;
        this.WD = i;
        this.gkU = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.gkS.gkP;
        if (zVar != null && this.gkT.gkX) {
            zVar2 = this.gkS.gkP;
            zVar2.b(this.WD, this.gkU);
        }
    }
}
