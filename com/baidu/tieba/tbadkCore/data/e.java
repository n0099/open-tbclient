package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.util.f {
    final /* synthetic */ d cZb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, Context context) {
        super(context);
        this.cZb = dVar;
    }

    @Override // com.baidu.tbadk.util.f, android.text.style.ClickableSpan
    public void onClick(View view) {
        String str;
        str = this.cZb.text;
        fM(str);
    }
}
