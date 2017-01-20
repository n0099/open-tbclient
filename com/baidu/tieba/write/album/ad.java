package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.ab;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    private final /* synthetic */ int Vn;
    final /* synthetic */ ab fHY;
    private final /* synthetic */ ab.a fHZ;
    private final /* synthetic */ ImageFileInfo fIa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, ab.a aVar, int i, ImageFileInfo imageFileInfo) {
        this.fHY = abVar;
        this.fHZ = aVar;
        this.Vn = i;
        this.fIa = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.fHY.fHV;
        if (zVar != null && this.fHZ.fId) {
            zVar2 = this.fHY.fHV;
            zVar2.a(this.Vn, this.fIa);
        }
    }
}
