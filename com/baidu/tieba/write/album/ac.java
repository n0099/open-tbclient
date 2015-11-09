package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {
    final /* synthetic */ z dmJ;
    private final /* synthetic */ ImageFileInfo dmL;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar, int i, ImageFileInfo imageFileInfo) {
        this.dmJ = zVar;
        this.val$position = i;
        this.dmL = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        v vVar;
        v vVar2;
        vVar = this.dmJ.dmH;
        if (vVar != null) {
            vVar2 = this.dmJ.dmH;
            vVar2.a(this.val$position, this.dmL);
        }
    }
}
