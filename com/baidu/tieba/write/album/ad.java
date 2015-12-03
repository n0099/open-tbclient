package com.baidu.tieba.write.album;

import android.view.View;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.ab;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    final /* synthetic */ ab dLP;
    private final /* synthetic */ ab.a dLQ;
    private final /* synthetic */ ImageFileInfo dLR;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, ab.a aVar, int i, ImageFileInfo imageFileInfo) {
        this.dLP = abVar;
        this.dLQ = aVar;
        this.val$position = i;
        this.dLR = imageFileInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.dLP.dLM;
        if (zVar != null && this.dLQ.dLU) {
            zVar2 = this.dLP.dLM;
            zVar2.a(this.val$position, this.dLR);
        }
    }
}
