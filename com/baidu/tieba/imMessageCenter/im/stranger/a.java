package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ MsgReplyCardView bOC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(MsgReplyCardView msgReplyCardView) {
        this.bOC = msgReplyCardView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.c.a aVar;
        int i;
        aVar = this.bOC.bsh;
        i = this.bOC.anQ;
        aVar.onItemViewClick(view, 14, i, 0L);
    }
}
