package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    final /* synthetic */ ab dLP;
    private final /* synthetic */ ImageFileInfo dLR;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar, int i, ImageFileInfo imageFileInfo) {
        this.dLP = abVar;
        this.val$position = i;
        this.dLR = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        xVar = this.dLP.dLN;
        if (xVar != null) {
            xVar2 = this.dLP.dLN;
            xVar2.a(this.val$position, this.dLR);
        }
    }
}
