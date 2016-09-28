package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    private final /* synthetic */ int Wf;
    final /* synthetic */ ab gdn;
    private final /* synthetic */ ImageFileInfo gdp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar, int i, ImageFileInfo imageFileInfo) {
        this.gdn = abVar;
        this.Wf = i;
        this.gdp = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        xVar = this.gdn.gdl;
        if (xVar != null) {
            xVar2 = this.gdn.gdl;
            xVar2.b(this.Wf, this.gdp);
        }
    }
}
