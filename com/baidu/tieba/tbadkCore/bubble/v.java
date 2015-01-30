package com.baidu.tieba.tbadkCore.bubble;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.d;
import com.baidu.tieba.tbadkCore.bubble.BubbleListData;
/* loaded from: classes.dex */
class v implements d {
    private final /* synthetic */ x bXV;
    private final /* synthetic */ BubbleListData.BubbleData bXW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(x xVar, BubbleListData.BubbleData bubbleData) {
        this.bXV = xVar;
        this.bXW = bubbleData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(a aVar) {
        aVar.dismiss();
        if (this.bXV != null) {
            this.bXV.hN(this.bXW.getBcode());
        }
    }
}
