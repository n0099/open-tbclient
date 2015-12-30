package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ MsgReplyCardView chF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(MsgReplyCardView msgReplyCardView) {
        this.chF = msgReplyCardView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.d.a aVar;
        int i;
        aVar = this.chF.bKU;
        i = this.chF.anc;
        aVar.onItemViewClick(view, 14, i, 0L);
    }
}
