package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.x;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ x dlb;
    private final /* synthetic */ x.a dlc;
    private final /* synthetic */ ImageFileInfo dld;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar, x.a aVar, int i, ImageFileInfo imageFileInfo) {
        this.dlb = xVar;
        this.dlc = aVar;
        this.val$position = i;
        this.dld = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        v vVar;
        v vVar2;
        vVar = this.dlb.dkY;
        if (vVar != null && this.dlc.dlg) {
            vVar2 = this.dlb.dkY;
            vVar2.a(this.val$position, this.dld);
        }
    }
}
