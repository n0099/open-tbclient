package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class af implements View.OnClickListener {
    private final /* synthetic */ int RY;
    final /* synthetic */ ac czd;
    private final /* synthetic */ ImageFileInfo czf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ac acVar, int i, ImageFileInfo imageFileInfo) {
        this.czd = acVar;
        this.RY = i;
        this.czf = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.czd.czb;
        if (zVar != null) {
            zVar2 = this.czd.czb;
            zVar2.a(this.RY, this.czf);
        }
    }
}
