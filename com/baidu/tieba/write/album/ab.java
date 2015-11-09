package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.z;
/* loaded from: classes.dex */
class ab implements View.OnClickListener {
    final /* synthetic */ z dmJ;
    private final /* synthetic */ z.a dmK;
    private final /* synthetic */ ImageFileInfo dmL;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar, z.a aVar, int i, ImageFileInfo imageFileInfo) {
        this.dmJ = zVar;
        this.dmK = aVar;
        this.val$position = i;
        this.dmL = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        xVar = this.dmJ.dmG;
        if (xVar != null && this.dmK.dmO) {
            xVar2 = this.dmJ.dmG;
            xVar2.a(this.val$position, this.dmL);
        }
    }
}
