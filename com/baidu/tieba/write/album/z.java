package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.x;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ x dkB;
    private final /* synthetic */ x.a dkC;
    private final /* synthetic */ ImageFileInfo dkD;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar, x.a aVar, int i, ImageFileInfo imageFileInfo) {
        this.dkB = xVar;
        this.dkC = aVar;
        this.val$position = i;
        this.dkD = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        v vVar;
        v vVar2;
        vVar = this.dkB.dky;
        if (vVar != null && this.dkC.dkG) {
            vVar2 = this.dkB.dky;
            vVar2.a(this.val$position, this.dkD);
        }
    }
}
