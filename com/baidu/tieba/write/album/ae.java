package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    final /* synthetic */ ab dTo;
    private final /* synthetic */ ImageFileInfo dTq;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar, int i, ImageFileInfo imageFileInfo) {
        this.dTo = abVar;
        this.val$position = i;
        this.dTq = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        xVar = this.dTo.dTm;
        if (xVar != null) {
            xVar2 = this.dTo.dTm;
            xVar2.a(this.val$position, this.dTq);
        }
    }
}
