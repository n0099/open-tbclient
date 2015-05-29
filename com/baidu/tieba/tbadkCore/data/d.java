package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.util.h {
    final /* synthetic */ c csa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, Context context) {
        super(context);
        this.csa = cVar;
    }

    @Override // com.baidu.tbadk.util.h, android.text.style.ClickableSpan
    public void onClick(View view) {
        String str;
        str = this.csa.text;
        fh(str);
    }
}
