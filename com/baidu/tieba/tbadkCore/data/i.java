package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.tbadk.util.f {
    final /* synthetic */ h dzu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(h hVar, Context context) {
        super(context);
        this.dzu = hVar;
    }

    @Override // com.baidu.tbadk.util.f, android.text.style.ClickableSpan
    public void onClick(View view) {
        String str;
        str = this.dzu.text;
        gc(str);
    }
}
