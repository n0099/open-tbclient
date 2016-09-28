package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.ab;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    private final /* synthetic */ int Wf;
    final /* synthetic */ ab gdn;
    private final /* synthetic */ ab.a gdo;
    private final /* synthetic */ ImageFileInfo gdp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, ab.a aVar, int i, ImageFileInfo imageFileInfo) {
        this.gdn = abVar;
        this.gdo = aVar;
        this.Wf = i;
        this.gdp = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.gdn.gdk;
        if (zVar != null && this.gdo.gds) {
            zVar2 = this.gdn.gdk;
            zVar2.b(this.Wf, this.gdp);
        }
    }
}
