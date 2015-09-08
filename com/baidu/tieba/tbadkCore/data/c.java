package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.util.e {
    final /* synthetic */ b cRb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, Context context) {
        super(context);
        this.cRb = bVar;
    }

    @Override // com.baidu.tbadk.util.e, android.text.style.ClickableSpan
    public void onClick(View view) {
        String str;
        str = this.cRb.text;
        fH(str);
    }
}
