package com.baidu.tieba.tbadkCore.b;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.util.f {
    final /* synthetic */ c bWD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, Context context) {
        super(context);
        this.bWD = cVar;
    }

    @Override // com.baidu.tbadk.util.f, android.text.style.ClickableSpan
    public void onClick(View view) {
        String str;
        str = this.bWD.text;
        startWebActivity(str);
    }
}
