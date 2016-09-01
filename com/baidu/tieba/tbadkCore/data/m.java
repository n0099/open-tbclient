package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.util.i {
    final /* synthetic */ l fsw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(l lVar, Context context) {
        super(context);
        this.fsw = lVar;
    }

    @Override // com.baidu.tbadk.util.i, android.text.style.ClickableSpan
    public void onClick(View view) {
        String str;
        str = this.fsw.text;
        gq(str);
    }
}
