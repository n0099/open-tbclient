package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ MsgReplyCardView cxG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(MsgReplyCardView msgReplyCardView) {
        this.cxG = msgReplyCardView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.d.a aVar;
        int i;
        aVar = this.cxG.bZF;
        i = this.cxG.aka;
        aVar.a(view, 14, i, 0L);
    }
}
